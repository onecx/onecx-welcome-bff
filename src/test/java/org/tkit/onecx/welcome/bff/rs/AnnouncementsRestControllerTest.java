package org.tkit.onecx.welcome.bff.rs;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static jakarta.ws.rs.core.Response.Status.BAD_REQUEST;
import static jakarta.ws.rs.core.Response.Status.OK;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import java.util.List;

import jakarta.ws.rs.HttpMethod;
import jakarta.ws.rs.core.Response;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockserver.client.MockServerClient;
import org.mockserver.model.JsonBody;
import org.mockserver.model.MediaType;
import org.tkit.onecx.welcome.bff.rs.controllers.AnnouncementsRestController;

import gen.org.tkit.onecx.announcement.client.model.AnnouncementPageResultV1;
import gen.org.tkit.onecx.announcement.client.model.AnnouncementSearchCriteriaV1;
import gen.org.tkit.onecx.announcement.client.model.AnnouncementV1;
import gen.org.tkit.onecx.welcome.bff.rs.internal.model.AnnouncementPageResultDTO;
import gen.org.tkit.onecx.welcome.bff.rs.internal.model.AnnouncementSearchCriteriaDTO;
import io.quarkiverse.mockserver.test.InjectMockServerClient;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@TestHTTPEndpoint(AnnouncementsRestController.class)
class AnnouncementsRestControllerTest extends AbstractTest {

    @InjectMockServerClient
    MockServerClient mockServerClient;

    @Test
    void searchAnnouncementsByEmptyCriteriaTest() {

        AnnouncementSearchCriteriaV1 criteriaV1 = new AnnouncementSearchCriteriaV1();
        AnnouncementPageResultV1 response = new AnnouncementPageResultV1();
        response.number(1).size(1).stream(List.of(new AnnouncementV1().title("a1").appId("app1").content("content")));

        // create mock rest endpoint
        mockServerClient.when(request().withPath("/v1/applications/announcements/search").withMethod(HttpMethod.POST)
                .withBody(JsonBody.json(criteriaV1))).withId("mock")
                .respond(httpRequest -> response().withStatusCode(Response.Status.OK.getStatusCode())
                        .withContentType(MediaType.APPLICATION_JSON)
                        .withBody(JsonBody.json(response)));

        AnnouncementSearchCriteriaDTO criteriaDTO = new AnnouncementSearchCriteriaDTO();

        var data = given()
                .contentType(APPLICATION_JSON)
                .auth().oauth2(keycloakClient.getAccessToken(ADMIN))
                .header(APM_HEADER_PARAM, ADMIN)
                .body(criteriaDTO)
                .post()
                .then()
                .statusCode(OK.getStatusCode())
                .extract().as(AnnouncementPageResultDTO.class);

        Assertions.assertThat(data.getStream().size()).isEqualTo(response.getStream().size());
        Assertions.assertThat(data.getStream().get(0).getTitle()).isEqualTo(response.getStream().get(0).getTitle());
        Assertions.assertThat(data.getStream().get(0).getAppId()).isEqualTo(response.getStream().get(0).getAppId());

        mockServerClient.clear("mock");
    }

    @Test
    void searchAnnouncementsByMissingCriteriaTest() {
        given()
                .contentType(APPLICATION_JSON)
                .auth().oauth2(keycloakClient.getAccessToken(ADMIN))
                .header(APM_HEADER_PARAM, ADMIN)
                .post()
                .then()
                .statusCode(BAD_REQUEST.getStatusCode());
    }

    @Test
    void searchAnnouncementsByCriteria_Client_Exception_Test() {

        AnnouncementSearchCriteriaV1 criteriaV1 = new AnnouncementSearchCriteriaV1();

        // create mock rest endpoint
        mockServerClient.when(request().withPath("/v1/applications/announcements/search").withMethod(HttpMethod.POST)
                .withBody(JsonBody.json(criteriaV1)))
                .withId("mock")
                .respond(httpRequest -> response().withStatusCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                        .withContentType(MediaType.APPLICATION_JSON));

        AnnouncementSearchCriteriaDTO criteriaDTO = new AnnouncementSearchCriteriaDTO();

        given()
                .contentType(APPLICATION_JSON)
                .auth().oauth2(keycloakClient.getAccessToken(ADMIN))
                .header(APM_HEADER_PARAM, ADMIN)
                .body(criteriaDTO)
                .post()
                .then()
                .statusCode(BAD_REQUEST.getStatusCode());

        mockServerClient.clear("mock");
    }

}
