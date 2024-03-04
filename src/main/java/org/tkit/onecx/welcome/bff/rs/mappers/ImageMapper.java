package org.tkit.onecx.welcome.bff.rs.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.tkit.quarkus.rs.mappers.OffsetDateTimeMapper;

import gen.org.tkit.onecx.welcome.bff.rs.internal.model.ImageDataResponseDTO;
import gen.org.tkit.onecx.welcome.bff.rs.internal.model.ImageInfoDTO;
import gen.org.tkit.onecx.welcome.client.model.ImageDataResponse;
import gen.org.tkit.onecx.welcome.client.model.ImageInfo;

@Mapper(uses = { OffsetDateTimeMapper.class })
public interface ImageMapper {
    ImageDataResponseDTO map(ImageDataResponse imageDataResponse);

    ImageInfo map(ImageInfoDTO info);

    ImageInfoDTO map(ImageInfo imageInfo);

    List<ImageInfoDTO> map(List<ImageInfo> list);
}
