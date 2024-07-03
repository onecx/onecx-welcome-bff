package org.tkit.onecx.welcome.bff.rs.controllers;

import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.ClientWebApplicationException;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;
import org.tkit.onecx.welcome.bff.rs.mappers.AnnouncementMapper;
import org.tkit.onecx.welcome.bff.rs.mappers.ExceptionMapper;

import gen.org.tkit.onecx.announcement.client.api.AnnouncementApi;
import gen.org.tkit.onecx.announcement.client.model.AnnouncementPageResultV1;
import gen.org.tkit.onecx.welcome.bff.rs.internal.AnnouncementsApiService;
import gen.org.tkit.onecx.welcome.bff.rs.internal.model.AnnouncementSearchCriteriaDTO;
import gen.org.tkit.onecx.welcome.bff.rs.internal.model.ProblemDetailResponseDTO;

public class AnnouncementsRestController implements AnnouncementsApiService {

    @Inject
    @RestClient
    AnnouncementApi announcementClient;

    @Inject
    AnnouncementMapper mapper;

    @Inject
    ExceptionMapper exceptionMapper;

    @Override
    public Response searchAnnouncementsByCriteria(AnnouncementSearchCriteriaDTO announcementSearchCriteriaDTO) {
        try (Response response = announcementClient.getAnnouncementsByCriteria(mapper.map(announcementSearchCriteriaDTO))) {
            return Response.status(response.getStatus()).entity(mapper.map(response.readEntity(AnnouncementPageResultV1.class)))
                    .build();
        }
    }

    @ServerExceptionMapper
    public RestResponse<ProblemDetailResponseDTO> constraint(ConstraintViolationException ex) {
        return exceptionMapper.constraint(ex);
    }

    @ServerExceptionMapper
    public Response restException(ClientWebApplicationException ex) {
        return exceptionMapper.clientException(ex);
    }
}
