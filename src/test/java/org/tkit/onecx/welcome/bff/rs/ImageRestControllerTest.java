package org.tkit.onecx.welcome.bff.rs;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static jakarta.ws.rs.core.Response.Status.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import java.io.File;
import java.io.IOException;
import java.util.*;

import jakarta.ws.rs.HttpMethod;
import jakarta.ws.rs.core.Response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockserver.client.MockServerClient;
import org.mockserver.model.JsonBody;
import org.mockserver.model.MediaType;
import org.testcontainers.shaded.org.apache.commons.io.FileUtils;
import org.tkit.onecx.welcome.bff.rs.controllers.ImagesRestController;
import org.tkit.quarkus.log.cdi.LogService;

import gen.org.tkit.onecx.welcome.bff.rs.internal.model.ImageDataResponseDTO;
import gen.org.tkit.onecx.welcome.bff.rs.internal.model.ImageInfoDTO;
import gen.org.tkit.onecx.welcome.bff.rs.internal.model.ImageInfoReorderRequestDTO;
import gen.org.tkit.onecx.welcome.bff.rs.internal.model.ProblemDetailResponseDTO;
import gen.org.tkit.onecx.welcome.client.model.ImageDataResponse;
import gen.org.tkit.onecx.welcome.client.model.ImageInfo;
import gen.org.tkit.onecx.welcome.client.model.ProblemDetailResponse;
import io.quarkiverse.mockserver.test.InjectMockServerClient;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@LogService
@TestHTTPEndpoint(ImagesRestController.class)
public class ImageRestControllerTest extends AbstractTest {
    @InjectMockServerClient
    MockServerClient mockServerClient;

    private static final String MEDIA_TYPE_IMAGE_PNG = "image/png";

    private static final File FILE = new File(
            Objects.requireNonNull(ImagesRestController.class.getResource("/images/Testimage.jpg")).getFile());

    static final String mockId = "MOCK";

    @BeforeEach
    void resetExpectation() {
        try {
            mockServerClient.clear(mockId);
        } catch (Exception ex) {
            //  mockId not existing
        }
    }

    @Test
    void getImageDataByIdTest() {
        ImageDataResponse response = new ImageDataResponse();
        response.setImageData(new byte[] { (byte) 0xe0, 0x4f, (byte) 0xd0,
                0x20, (byte) 0xea, 0x3a, 0x69, 0x10, (byte) 0xa2, (byte) 0xd8, 0x08, 0x00, 0x2b,
                0x30, 0x30, (byte) 0x9d });
        response.setImageId("id");

        // create mock rest endpoint
        mockServerClient.when(request().withPath("/internal/images/" + "d-11-111").withMethod(HttpMethod.GET))
                .withId(mockId)
                .respond(httpRequest -> response().withStatusCode(Response.Status.OK.getStatusCode())
                        .withContentType(MediaType.APPLICATION_JSON)
                        .withBody(JsonBody.json(response)));

        var data = given()
                .contentType(APPLICATION_JSON)
                .auth().oauth2(keycloakClient.getAccessToken(ADMIN))
                .header(APM_HEADER_PARAM, ADMIN)
                .pathParam("id", "d-11-111")
                .get("/{id}")
                .then()
                .statusCode(OK.getStatusCode())
                .extract().as(ImageDataResponseDTO.class);

        assertThat(data).isNotNull();
        assertThat(data.getImageData()).isNotEmpty();
    }

    @Test
    void getImageInfoByIdTest() {
        ImageInfo response = new ImageInfo();
        response.visible(true).imageId("someId").position("0");

        // create mock rest endpoint
        mockServerClient.when(request().withPath("/internal/images/info/" + "11-111").withMethod(HttpMethod.GET))
                .withId(mockId)
                .respond(httpRequest -> response().withStatusCode(Response.Status.OK.getStatusCode())
                        .withContentType(MediaType.APPLICATION_JSON)
                        .withBody(JsonBody.json(response)));
        var data = given()
                .contentType(APPLICATION_JSON)
                .auth().oauth2(keycloakClient.getAccessToken(ADMIN))
                .header(APM_HEADER_PARAM, ADMIN)
                .pathParam("id", "11-111")
                .get("/info/{id}")
                .then()
                .statusCode(OK.getStatusCode())
                .extract().as(ImageInfoDTO.class);

        assertThat(data).isNotNull();
        assertThat(data.getImageId()).isEqualTo("someId");
        assertThat(data.getPosition()).isEqualTo("0");

    }

    @Test
    void createImageDataTest() throws IOException {

        ImageDataResponse response = new ImageDataResponse();
        response.setImageData(Base64.getEncoder().encode(FileUtils.readFileToByteArray(FILE)));
        response.setImageId("id");

        // create mock rest endpoint
        mockServerClient.when(request().withPath("/internal/images").withMethod(HttpMethod.POST)
                .withContentType(MediaType.ANY_IMAGE_TYPE)
                .withBody(FileUtils.readFileToByteArray(FILE)))
                .withId(mockId)
                .respond(httpRequest -> response().withStatusCode(Response.Status.OK.getStatusCode())
                        .withContentType(MediaType.APPLICATION_JSON)
                        .withBody(JsonBody.json(response)));

        var data = given()
                .when()
                .auth().oauth2(keycloakClient.getAccessToken(ADMIN))
                .header(APM_HEADER_PARAM, ADMIN)
                .body(FILE)
                .contentType(MEDIA_TYPE_IMAGE_PNG)
                .post()
                .then()
                .statusCode(OK.getStatusCode())
                .extract()
                .body().as(ImageDataResponseDTO.class);
        assertThat(data).isNotNull();
    }

    @Test
    void createImageInfoTest() {

        ImageInfo info = new ImageInfo();
        info.setUrl("someUrl");
        info.setPosition("1");
        info.setWorkspaceName("w1");

        // create mock rest endpoint
        mockServerClient.when(request().withPath("/internal/images/info").withMethod(HttpMethod.POST)
                .withContentType(MediaType.APPLICATION_JSON)
                .withBody(JsonBody.json(info)))
                .withId(mockId)
                .respond(httpRequest -> response().withStatusCode(CREATED.getStatusCode())
                        .withContentType(MediaType.APPLICATION_JSON)
                        .withBody(JsonBody.json(info)));

        ImageInfoDTO infoDTO = new ImageInfoDTO();
        infoDTO.setPosition("1");
        infoDTO.setUrl("someUrl");
        infoDTO.setWorkspaceName("w1");

        var output = given()
                .when()
                .auth().oauth2(keycloakClient.getAccessToken(ADMIN))
                .header(APM_HEADER_PARAM, ADMIN)
                .body(infoDTO)
                .contentType(APPLICATION_JSON)
                .post("/info")
                .then()
                .statusCode(CREATED.getStatusCode())
                .extract().as(ImageInfoDTO.class);

        assertThat(output).isNotNull();
        assertThat(output.getUrl()).isEqualTo(info.getUrl());
    }

    @Test
    void updateImageDataByIdTest() throws IOException {
        ImageDataResponse response = new ImageDataResponse();
        response.setImageData(Base64.getEncoder().encode(FileUtils.readFileToByteArray(FILE)));
        response.setImageId("id");

        // create mock rest endpoint
        mockServerClient.when(request().withPath("/internal/images/d-11-111").withMethod(HttpMethod.PUT)
                .withContentType(MediaType.ANY_IMAGE_TYPE)
                .withBody(FileUtils.readFileToByteArray(FILE)))
                .withId(mockId)
                .respond(httpRequest -> response().withStatusCode(Response.Status.OK.getStatusCode())
                        .withContentType(MediaType.APPLICATION_JSON)
                        .withBody(JsonBody.json(response)));

        var data = given()
                .when()
                .auth().oauth2(keycloakClient.getAccessToken(ADMIN))
                .header(APM_HEADER_PARAM, ADMIN)
                .body(FILE)
                .contentType(MEDIA_TYPE_IMAGE_PNG)
                .pathParam("id", "d-11-111")
                .put("{id}")
                .then()
                .statusCode(OK.getStatusCode())
                .extract()
                .body().as(ImageDataResponseDTO.class);

        assertThat(data).isNotNull();
        assertThat(data.getImageData()).isEqualTo(response.getImageData());

        // create mock rest endpoint
        mockServerClient.when(request().withPath("/internal/images/abc").withMethod(HttpMethod.PUT)
                .withContentType(MediaType.ANY_IMAGE_TYPE)
                .withBody(FileUtils.readFileToByteArray(FILE)))
                .withId(mockId)
                .respond(httpRequest -> response().withStatusCode(NOT_FOUND.getStatusCode()));

        //update not-existing image
        given()
                .when()
                .auth().oauth2(keycloakClient.getAccessToken(ADMIN))
                .header(APM_HEADER_PARAM, ADMIN)
                .body(FILE)
                .contentType(MEDIA_TYPE_IMAGE_PNG)
                .pathParam("id", "not-existing")
                .put("/{id}")
                .then()
                .statusCode(NOT_FOUND.getStatusCode());
    }

    @Test
    void updateImageInfoByIdTest() {
        ImageInfo info = new ImageInfo();
        info.setUrl("someUrl");
        info.setPosition("1");
        info.setWorkspaceName("w1");

        // create mock rest endpoint
        mockServerClient.when(request().withPath("/internal/images/info/11-111").withMethod(HttpMethod.PUT)
                .withContentType(MediaType.APPLICATION_JSON)
                .withBody(JsonBody.json(info)))
                .withId(mockId)
                .respond(httpRequest -> response().withStatusCode(CREATED.getStatusCode())
                        .withContentType(MediaType.APPLICATION_JSON)
                        .withBody(JsonBody.json(info)));

        ImageInfoDTO infoDTO = new ImageInfoDTO();
        infoDTO.setPosition("1");
        infoDTO.setUrl("someUrl");
        infoDTO.setWorkspaceName("w1");

        var output = given()
                .when()
                .auth().oauth2(keycloakClient.getAccessToken(ADMIN))
                .header(APM_HEADER_PARAM, ADMIN)
                .body(infoDTO)
                .contentType(APPLICATION_JSON)
                .pathParam("id", "11-111")
                .put("/info/{id}")
                .then()
                .statusCode(CREATED.getStatusCode())
                .extract().as(ImageInfoDTO.class);

        assertThat(output).isNotNull();
        assertThat(output.getUrl()).isEqualTo(info.getUrl());
    }

    @Test
    void updateOrderTest() {
        ImageInfo info = new ImageInfo();
        info.setUrl("someUrl");
        info.setPosition("1");
        info.setId("11-111");
        info.setWorkspaceName("w1");
        ImageInfo info2 = new ImageInfo();
        info2.setUrl("someUrl");
        info2.setPosition("2");
        info2.setId("22-222");
        info2.setWorkspaceName("w1");

        // create mock rest endpoint
        mockServerClient.when(request().withPath("/internal/images/info/11-111").withMethod(HttpMethod.PUT)
                .withContentType(MediaType.APPLICATION_JSON)
                .withBody(JsonBody.json(info)))
                .withId(mockId)
                .respond(httpRequest -> response().withStatusCode(CREATED.getStatusCode())
                        .withContentType(MediaType.APPLICATION_JSON)
                        .withBody(JsonBody.json(info)));

        // create mock rest endpoint
        mockServerClient.when(request().withPath("/internal/images/info/22-222").withMethod(HttpMethod.PUT)
                .withContentType(MediaType.APPLICATION_JSON)
                .withBody(JsonBody.json(info2)))
                .withId("mock2")
                .respond(httpRequest -> response().withStatusCode(CREATED.getStatusCode())
                        .withContentType(MediaType.APPLICATION_JSON)
                        .withBody(JsonBody.json(info2)));

        ImageInfoDTO infoDTO = new ImageInfoDTO();
        infoDTO.setPosition("1");
        infoDTO.setUrl("someUrl");
        infoDTO.setId("11-111");
        infoDTO.setWorkspaceName("w1");

        ImageInfoDTO info2DTO = new ImageInfoDTO();
        info2DTO.setPosition("2");
        info2DTO.setUrl("someUrl");
        info2DTO.setId("22-222");
        info2DTO.setWorkspaceName("w1");

        ImageInfoReorderRequestDTO reorderRequestDTO = new ImageInfoReorderRequestDTO();
        reorderRequestDTO.setImageInfos(List.of(infoDTO, info2DTO));

        given()
                .when()
                .auth().oauth2(keycloakClient.getAccessToken(ADMIN))
                .header(APM_HEADER_PARAM, ADMIN)
                .body(reorderRequestDTO)
                .contentType(APPLICATION_JSON)
                .post("/info/reorder")
                .then()
                .statusCode(OK.getStatusCode());
        mockServerClient.clear("mock2");
    }

    @Test
    void updateOrderWithEmptyBodyTest() {
        ImageInfoReorderRequestDTO reorderRequestDTO = new ImageInfoReorderRequestDTO();
        reorderRequestDTO.setImageInfos(List.of());

        given()
                .when()
                .auth().oauth2(keycloakClient.getAccessToken(ADMIN))
                .header(APM_HEADER_PARAM, ADMIN)
                .body(reorderRequestDTO)
                .contentType(APPLICATION_JSON)
                .post("/info/reorder")
                .then()
                .statusCode(BAD_REQUEST.getStatusCode());
    }

    @Test
    void deleteImageInfoByIdTest() {

        // create mock rest endpoint
        mockServerClient.when(request().withPath("/internal/images/info/" + "11-111").withMethod(HttpMethod.DELETE))
                .withId(mockId)
                .respond(httpRequest -> response().withStatusCode(NO_CONTENT.getStatusCode())
                        .withContentType(MediaType.APPLICATION_JSON));

        given()
                .pathParam("id", "11-111")
                .auth().oauth2(keycloakClient.getAccessToken(ADMIN))
                .header(APM_HEADER_PARAM, ADMIN)
                .delete("/info/{id}")
                .then()
                .statusCode(NO_CONTENT.getStatusCode());
    }

    @Test
    void getAllImageInfosTest() {
        List<ImageInfo> infos = new ArrayList<>();
        ImageInfo info = new ImageInfo();
        info.setImageId("111");
        info.setWorkspaceName("w1");
        infos.add(info);

        // create mock rest endpoint
        mockServerClient.when(request().withPath("/internal/images/w1/info").withMethod(HttpMethod.GET))
                .withId(mockId)
                .respond(httpRequest -> response().withStatusCode(Response.Status.OK.getStatusCode())
                        .withContentType(MediaType.APPLICATION_JSON)
                        .withBody(JsonBody.json(infos)));
        var output = given()
                .auth().oauth2(keycloakClient.getAccessToken(ADMIN))
                .header(APM_HEADER_PARAM, ADMIN)
                .pathParam("workspaceName", "w1")
                .get("/{workspaceName/info")
                .then()
                .contentType(APPLICATION_JSON)
                .extract().as(ImageInfoDTO[].class);

        assertThat(output).hasSize(1);
    }

    @Test
    void testMaxUploadSize() throws IOException {

        ProblemDetailResponse error = new ProblemDetailResponse();
        error.setDetail("createImage.contentLength: must be less than or equal to 1100000");

        // create mock rest endpoint
        mockServerClient.when(request().withPath("/internal/images").withMethod(HttpMethod.POST)
                .withContentType(MediaType.ANY_IMAGE_TYPE)
                .withBody(FileUtils.readFileToByteArray(FILE)))
                .withId(mockId)
                .respond(httpRequest -> response().withStatusCode(BAD_REQUEST.getStatusCode())
                        .withContentType(MediaType.APPLICATION_JSON)
                        .withBody(JsonBody.json(error)));

        var exception = given()
                .when()
                .auth().oauth2(keycloakClient.getAccessToken(ADMIN))
                .header(APM_HEADER_PARAM, ADMIN)
                .body(FILE)
                .contentType(MEDIA_TYPE_IMAGE_PNG)
                .post()
                .then()
                .statusCode(BAD_REQUEST.getStatusCode())
                .extract().as(ProblemDetailResponseDTO.class);

        assertThat(exception.getDetail()).isEqualTo(
                "createImage.contentLength: must be less than or equal to 1100000");
    }

}
