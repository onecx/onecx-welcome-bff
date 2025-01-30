package org.tkit.onecx.welcome.bff.rs.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.tkit.quarkus.rs.mappers.OffsetDateTimeMapper;

import gen.org.tkit.onecx.welcome.bff.rs.internal.model.*;
import gen.org.tkit.onecx.welcome.client.model.ImageDataResponse;
import gen.org.tkit.onecx.welcome.client.model.ImageInfo;

@Mapper(uses = { OffsetDateTimeMapper.class })
public interface ImageMapper {
    ImageDataResponseDTO map(ImageDataResponse imageDataResponse);

    ImageInfo map(ImageInfoDTO info);

    ImageInfoDTO map(ImageInfo imageInfo);

    List<ImageInfoDTO> map(List<ImageInfo> list);

    @ValueMapping(target = "SCALE_DOWN", source = "SCALE_MINUS_DOWN")
    ObjectFitDTO map(ImageInfo.ObjectFitEnum objectFitEnum);

    @ValueMapping(target = "SCALE_MINUS_DOWN", source = "SCALE_DOWN")
    ImageInfo.ObjectFitEnum map(ObjectFitDTO objectFitEnum);
}
