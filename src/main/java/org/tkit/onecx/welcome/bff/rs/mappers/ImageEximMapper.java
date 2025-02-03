package org.tkit.onecx.welcome.bff.rs.mappers;

import java.util.Comparator;

import org.mapstruct.*;
import org.tkit.quarkus.rs.mappers.OffsetDateTimeMapper;

import gen.org.tkit.onecx.welcome.bff.rs.internal.model.*;
import gen.org.tkit.onecx.welcome.exim.client.model.*;

@Mapper(uses = { OffsetDateTimeMapper.class })
public interface ImageEximMapper {

    WelcomeSnapshotDTO mapSnapshot(WelcomeSnapshot welcomeSnapshot);

    WelcomeSnapshot mapSnapshotDTO(WelcomeSnapshotDTO welcomeSnapshotDTO);

    @Mapping(target = "removeImagesItem", ignore = true)
    WelcomeConfigDTO map(WelcomeConfig config);

    WelcomeConfig map(WelcomeConfigDTO configDTO);

    EximImageDTO map(EximImage eximImage);

    @AfterMapping
    default void sortAfterMap(@MappingTarget WelcomeConfigDTO configDTO) {
        configDTO.getImages().sort(Comparator.comparingInt(image -> Integer.parseInt(image.getImage().getPosition())));
    }

    EximImage map(EximImageDTO eximImageDTO);

    ExportWelcomeRequest mapExport(ExportWelcomeRequestDTO exportWelcomeRequestDTO);

    @Mapping(target = "imageId", ignore = true)
    ImageInfo map(EximImageInfoDTO eximImageInfoDTO);

    @Mapping(target = "imageId", ignore = true)
    ImageData map(EximImageDataDTO eximImageDataDTO);

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
