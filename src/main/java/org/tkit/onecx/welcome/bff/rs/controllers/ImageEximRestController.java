package org.tkit.onecx.welcome.bff.rs.controllers;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.ClientWebApplicationException;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;
import org.tkit.onecx.welcome.bff.rs.mappers.ExceptionMapper;
import org.tkit.onecx.welcome.bff.rs.mappers.ImageEximMapper;
import org.tkit.quarkus.log.cdi.LogService;

import gen.org.tkit.onecx.welcome.bff.rs.internal.ImagesExportImportApiService;
import gen.org.tkit.onecx.welcome.bff.rs.internal.model.ExportWelcomeRequestDTO;
import gen.org.tkit.onecx.welcome.bff.rs.internal.model.ProblemDetailResponseDTO;
import gen.org.tkit.onecx.welcome.bff.rs.internal.model.WelcomeSnapshotDTO;
import gen.org.tkit.onecx.welcome.exim.client.api.ImagesExportImportApi;
import gen.org.tkit.onecx.welcome.exim.client.model.WelcomeSnapshot;

@ApplicationScoped
@Transactional(value = Transactional.TxType.NOT_SUPPORTED)
@LogService
public class ImageEximRestController implements ImagesExportImportApiService {

    @Inject
    @RestClient
    ImagesExportImportApi eximAPI;

    @Inject
    ImageEximMapper imageMapper;

    @Inject
    ExceptionMapper exceptionMapper;

    @Override
    public Response exportImages(ExportWelcomeRequestDTO exportWelcomeRequestDTO) {
        try (Response response = eximAPI.exportImages(imageMapper.mapExport(exportWelcomeRequestDTO))) {
            return Response.status(response.getStatus())
                    .entity(imageMapper.mapSnapshot(response.readEntity(WelcomeSnapshot.class))).build();
        }
    }

    @Override
    public Response importImages(String workspaceName, WelcomeSnapshotDTO welcomeSnapshotDTO) {
        try (Response response = eximAPI.importImages(workspaceName, imageMapper.mapSnapshotDTO(welcomeSnapshotDTO))) {
            return Response.status(response.getStatus()).build();
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
