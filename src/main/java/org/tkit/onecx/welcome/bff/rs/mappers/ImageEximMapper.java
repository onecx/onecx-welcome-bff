package org.tkit.onecx.welcome.bff.rs.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ValueMapping;
import org.tkit.quarkus.rs.mappers.OffsetDateTimeMapper;

import gen.org.tkit.onecx.welcome.bff.rs.internal.model.*;
import gen.org.tkit.onecx.welcome.exim.client.model.ExportWelcomeRequest;
import gen.org.tkit.onecx.welcome.exim.client.model.ImageData;
import gen.org.tkit.onecx.welcome.exim.client.model.ImageInfo;
import gen.org.tkit.onecx.welcome.exim.client.model.WelcomeSnapshot;

@Mapper(uses = { OffsetDateTimeMapper.class })
public interface ImageEximMapper {

    @Mapping(target = "removeImagesItem", ignore = true)
    WelcomeSnapshotDTO mapSnapshot(WelcomeSnapshot welcomeSnapshot);

    WelcomeSnapshot mapSnapshotDTO(WelcomeSnapshotDTO welcomeSnapshotDTO);

    ExportWelcomeRequest mapExport(ExportWelcomeRequestDTO exportWelcomeRequestDTO);

    @ValueMapping(target = "SCALE_DOWN", source = "SCALE_MINUS_DOWN")
    ObjectFitDTO map(ImageInfo.ObjectFitEnum objectFitEnum);

    @ValueMapping(target = "SCALE_MINUS_DOWN", source = "SCALE_DOWN")
    ImageInfo.ObjectFitEnum map(ObjectFitDTO objectFitEnum);

    @Mapping(target = "workspaceName", ignore = true)
    @Mapping(target = "modificationUser", ignore = true)
    @Mapping(target = "modificationDate", ignore = true)
    @Mapping(target = "modificationCount", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationUser", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    ImageInfoDTO map(ImageInfo info);

    @Mapping(target = "modificationUser", ignore = true)
    @Mapping(target = "modificationDate", ignore = true)
    @Mapping(target = "modificationCount", ignore = true)
    @Mapping(target = "creationUser", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    ImageDataResponseDTO map(ImageData imageData);
}
