package org.tkit.onecx.welcome.bff.rs;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static jakarta.ws.rs.core.Response.Status.BAD_REQUEST;
import static jakarta.ws.rs.core.Response.Status.OK;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.HttpMethod;
import jakarta.ws.rs.core.Response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockserver.client.MockServerClient;
import org.mockserver.model.JsonBody;
import org.mockserver.model.MediaType;
import org.tkit.onecx.welcome.bff.rs.controllers.ImageEximRestController;
import org.tkit.quarkus.log.cdi.LogService;

import gen.org.tkit.onecx.welcome.bff.rs.internal.model.*;
import gen.org.tkit.onecx.welcome.exim.client.model.*;
import io.quarkiverse.mockserver.test.InjectMockServerClient;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@LogService
@TestHTTPEndpoint(ImageEximRestController.class)
public class ImageEximRestControllerTest extends AbstractTest {

    @InjectMockServerClient
    MockServerClient mockServerClient;

    static final String MOCK_ID = "MOCK";
    static final byte[] MOCK_BYTES = new byte[] { (byte) 0xe0, 0x4f, (byte) 0xd0,
            0x20, (byte) 0xea, 0x3a, 0x69, 0x10, (byte) 0xa2, (byte) 0xd8, 0x08, 0x00, 0x2b,
            0x30, 0x30, (byte) 0x9d };

    @BeforeEach
    void resetExpectation() {
        try {
            mockServerClient.clear(MOCK_ID);
        } catch (Exception ex) {
            //  mockId not existing
        }
    }

    @Test
    void exportImagesTest() {

        WelcomeSnapshot response = new WelcomeSnapshot();
        List<EximImage> snapshotImages = new ArrayList<>();
        EximImage img1 = new EximImage().image(new ImageInfo().visible(true)).imageData(new ImageData().imageData(MOCK_BYTES));
        snapshotImages.add(img1);
        response.setImages(snapshotImages);
        response.setId("id1");

        // create mock rest endpoint
        mockServerClient.when(request().withPath("/exim/v1/images/export").withMethod(HttpMethod.POST)
                .withBody(JsonBody.json(new ExportWelcomeRequest().workspaceName("w1"))))
                .withId(MOCK_ID)
                .respond(httpRequest -> response().withStatusCode(Response.Status.OK.getStatusCode())
                        .withContentType(MediaType.APPLICATION_JSON)
                        .withBody(JsonBody.json(response)));

        var data = given()
                .contentType(APPLICATION_JSON)
                .auth().oauth2(keycloakClient.getAccessToken(ADMIN))
                .header(APM_HEADER_PARAM, ADMIN)
                .body(new ExportWelcomeRequestDTO().workspaceName("w1"))
                .post("/export")
                .then()
                .statusCode(OK.getStatusCode())
                .extract().as(WelcomeSnapshotDTO.class);

        assertThat(data).isNotNull();
        assertThat(data.getImages()).hasSize(1);
    }

    @Test
    void importImagesTest() {

        WelcomeSnapshot request = new WelcomeSnapshot();
        List<EximImage> snapshotImages = new ArrayList<>();
        EximImage img1 = new EximImage().image(new ImageInfo().visible(true)).imageData(new ImageData().imageData(MOCK_BYTES));
        snapshotImages.add(img1);
        request.setImages(snapshotImages);
        request.setId("id11111111111111111");

        // create mock rest endpoint
        mockServerClient.when(request().withPath("/exim/v1/images/w2/import").withMethod(HttpMethod.POST)
                .withBody(JsonBody.json(request)))
                .withId(MOCK_ID)
                .respond(httpRequest -> response().withStatusCode(Response.Status.OK.getStatusCode()));

        WelcomeSnapshotDTO requestDTO = new WelcomeSnapshotDTO();
        List<EximImageDTO> snapshotImagesDTO = new ArrayList<>();
        EximImageDTO img1DTO = new EximImageDTO().image(new ImageInfoDTO().visible(true).workspaceName("w1"))
                .imageData(new ImageDataResponseDTO().imageData(MOCK_BYTES));
        snapshotImagesDTO.add(img1DTO);
        requestDTO.setImages(snapshotImagesDTO);
        requestDTO.setId("id11111111111111111");

        given()
                .contentType(APPLICATION_JSON)
                .auth().oauth2(keycloakClient.getAccessToken(ADMIN))
                .header(APM_HEADER_PARAM, ADMIN)
                .body(requestDTO)
                .pathParam("workspaceName", "w2")
                .post("/{workspaceName}/import")
                .then()
                .statusCode(OK.getStatusCode());
    }

    @Test
    void importNoSnapshotTest() {
        given()
                .contentType(APPLICATION_JSON)
                .auth().oauth2(keycloakClient.getAccessToken(ADMIN))
                .header(APM_HEADER_PARAM, ADMIN)
                .pathParam("workspaceName", "w2")
                .post("/{workspaceName}/import")
                .then()
                .statusCode(BAD_REQUEST.getStatusCode());
    }

    @Test
    void exportClientExceptionTest() {
        // create mock rest endpoint
        mockServerClient.when(request().withPath("/exim/v1/images/export").withMethod(HttpMethod.POST)
                .withBody(JsonBody.json(new ExportWelcomeRequest().workspaceName("w1"))))
                .withId(MOCK_ID)
                .respond(httpRequest -> response().withStatusCode(BAD_REQUEST.getStatusCode())
                        .withContentType(MediaType.APPLICATION_JSON));
        given()
                .contentType(APPLICATION_JSON)
                .auth().oauth2(keycloakClient.getAccessToken(ADMIN))
                .header(APM_HEADER_PARAM, ADMIN)
                .body(new ExportWelcomeRequestDTO().workspaceName("w1"))
                .post("/export")
                .then()
                .statusCode(BAD_REQUEST.getStatusCode());
    }
}
