package org.tkit.onecx.welcome.bff.rs.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.tkit.quarkus.rs.mappers.OffsetDateTimeMapper;

import gen.org.tkit.onecx.announcement.client.model.AnnouncementPageResultV1;
import gen.org.tkit.onecx.announcement.client.model.AnnouncementSearchCriteriaV1;
import gen.org.tkit.onecx.welcome.bff.rs.internal.model.AnnouncementPageResultDTO;
import gen.org.tkit.onecx.welcome.bff.rs.internal.model.AnnouncementSearchCriteriaDTO;

@Mapper(uses = { OffsetDateTimeMapper.class })
public interface AnnouncementMapper {
    AnnouncementSearchCriteriaV1 map(AnnouncementSearchCriteriaDTO announcementSearchCriteriaDTO);

    @Mapping(target = "removeStreamItem", ignore = true)
    AnnouncementPageResultDTO map(AnnouncementPageResultV1 announcementPageResultV1);
}
