package org.tkit.onecx.welcome.bff.rs.logs;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;

import org.tkit.quarkus.log.cdi.LogParam;

import gen.org.tkit.onecx.welcome.bff.rs.internal.model.ExportWelcomeRequestDTO;
import gen.org.tkit.onecx.welcome.bff.rs.internal.model.ImageInfoDTO;
import gen.org.tkit.onecx.welcome.bff.rs.internal.model.ImageInfoReorderRequestDTO;
import gen.org.tkit.onecx.welcome.bff.rs.internal.model.WelcomeSnapshotDTO;

@ApplicationScoped
public class ImageLog implements LogParam {

    @Override
    public List<Item> getClasses() {
        return List.of(
                this.item(10, WelcomeSnapshotDTO.class,
                        x -> "WelcomeSnapshotDTO[ id: " + ((WelcomeSnapshotDTO) x).getId() +
                                " ]"),
                this.item(10, ExportWelcomeRequestDTO.class,
                        x -> "ExportWelcomeRequestDTO[ workspace: " + ((ExportWelcomeRequestDTO) x).getWorkspaceName() +
                                " ]"),
                this.item(10, ImageInfoDTO.class,
                        x -> "ImageInfoDTO[ id: " + ((ImageInfoDTO) x).getId() +
                                ",pos: " + ((ImageInfoDTO) x).getPosition() +
                                ",img: " + ((ImageInfoDTO) x).getImageId() +
                                " ]"),
                this.item(10, ImageInfoReorderRequestDTO.class, x -> {
                    var size = 0;
                    List<ImageInfoDTO> tmp = ((ImageInfoReorderRequestDTO) x).getImageInfos();
                    if (tmp != null) {
                        size = tmp.size();
                    }
                    return "ImageInfoReorderRequestDTO[ size: " + size + " ]";
                }));
    }
}
