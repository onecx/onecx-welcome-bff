package org.tkit.onecx.welcome.bff.rs.controllers;

import java.util.Arrays;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;
import org.tkit.onecx.welcome.bff.rs.mappers.ExceptionMapper;
import org.tkit.onecx.welcome.bff.rs.mappers.ImageMapper;
import org.tkit.quarkus.log.cdi.LogService;

import gen.org.tkit.onecx.welcome.bff.rs.internal.ImagesInternalApiService;
import gen.org.tkit.onecx.welcome.bff.rs.internal.model.*;
import gen.org.tkit.onecx.welcome.client.api.ImagesInternalApi;
import gen.org.tkit.onecx.welcome.client.model.ImageDataResponse;
import gen.org.tkit.onecx.welcome.client.model.ImageInfo;

@ApplicationScoped
@Transactional(value = Transactional.TxType.NOT_SUPPORTED)
@LogService
public class ImagesRestController implements ImagesInternalApiService {
    @Inject
    @RestClient
    ImagesInternalApi welcomeClient;

    @Inject
    ImageMapper mapper;

    @Inject
    ExceptionMapper exceptionMapper;

    @Override
    public Response createImage(Integer contentLength, byte[] body) {
        try (Response response = welcomeClient.createImage(contentLength, body)) {
            ImageDataResponseDTO responseDTO = mapper.map(response.readEntity(ImageDataResponse.class));
            return Response.status(response.getStatus()).entity(responseDTO).build();
        }
    }

    @Override
    public Response createImageInfo(ImageInfoDTO imageInfoDTO) {
        try (Response response = welcomeClient.createImageInfo(mapper.map(imageInfoDTO))) {
            ImageInfoDTO responseDTO = mapper.map(response.readEntity(ImageInfo.class));
            return Response.status(response.getStatus()).entity(responseDTO).build();
        }
    }

    @Override
    public Response deleteImageInfoById(String id) {
        try (Response response = welcomeClient.deleteImageInfoById(id)) {
            return Response.status(response.getStatus()).build();
        }
    }

    @Override
    public Response getAllImageInfos() {
        try (Response response = welcomeClient.getAllImageInfos()) {
            List<ImageInfoDTO> infoList = mapper.map(Arrays.stream(response.readEntity(ImageInfo[].class)).toList());
            return Response.status(response.getStatus()).entity(infoList).build();
        }
    }

    @Override
    public Response getImageById(String id) {
        try (Response response = welcomeClient.getImageById(id)) {
            ImageDataResponseDTO responseDTO = mapper.map(response.readEntity(ImageDataResponse.class));
            return Response.status(response.getStatus()).entity(responseDTO).build();
        }
    }

    @Override
    public Response getImageInfoById(String id) {
        try (Response response = welcomeClient.getImageInfoById(id)) {
            ImageInfoDTO infoDTO = mapper.map(response.readEntity(ImageInfo.class));
            return Response.status(response.getStatus()).entity(infoDTO).build();
        }
    }

    @Override
    public Response updateImageById(String id, Integer contentLength, byte[] body) {
        try (Response response = welcomeClient.updateImageById(id, contentLength, body)) {
            ImageDataResponseDTO responseDTO = mapper.map(response.readEntity(ImageDataResponse.class));
            return Response.status(response.getStatus()).entity(responseDTO).build();
        }
    }

    @Override
    public Response updateImageInfo(String id, ImageInfoDTO imageInfoDTO) {
        try (Response response = welcomeClient.updateImageInfo(id, mapper.map(imageInfoDTO))) {
            ImageInfoDTO responseDTO = mapper.map(response.readEntity(ImageInfo.class));
            return Response.status(response.getStatus()).entity(responseDTO).build();
        }
    }

    @Override
    public Response updateImageOrder(ImageInfoReorderRequestDTO imageInfoReorderRequestDTO) {
        if (!imageInfoReorderRequestDTO.getImageInfos().isEmpty()) {
            for (ImageInfoDTO imageInfoDTO : imageInfoReorderRequestDTO.getImageInfos()) {
                welcomeClient.updateImageInfo(imageInfoDTO.getId(),
                        mapper.map(imageInfoDTO)).close();
            }
            return Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @ServerExceptionMapper
    public RestResponse<ProblemDetailResponseDTO> constraint(ConstraintViolationException ex) {
        return exceptionMapper.constraint(ex);
    }

    @ServerExceptionMapper
    public Response restException(WebApplicationException ex) {
        return Response.status(ex.getResponse().getStatus()).build();
    }
}
