package org.tkit.onecx.welcome.bff.rs.mappers;

import gen.org.tkit.onecx.welcome.bff.rs.internal.model.ImageDataResponseDTO;
import gen.org.tkit.onecx.welcome.bff.rs.internal.model.ImageInfoDTO;
import gen.org.tkit.onecx.welcome.client.model.ImageDataResponse;
import gen.org.tkit.onecx.welcome.client.model.ImageInfo;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-01T16:06:51+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Azul Systems, Inc.)"
)
@ApplicationScoped
public class ImageMapperImpl implements ImageMapper {

    @Override
    public ImageDataResponseDTO map(ImageDataResponse imageDataResponse) {
        if ( imageDataResponse == null ) {
            return null;
        }

        ImageDataResponseDTO imageDataResponseDTO = new ImageDataResponseDTO();

        imageDataResponseDTO.setImageId( imageDataResponse.getImageId() );
        byte[] imageData = imageDataResponse.getImageData();
        if ( imageData != null ) {
            imageDataResponseDTO.setImageData( Arrays.copyOf( imageData, imageData.length ) );
        }
        imageDataResponseDTO.setDataLength( imageDataResponse.getDataLength() );
        imageDataResponseDTO.setMimeType( imageDataResponse.getMimeType() );
        imageDataResponseDTO.setModificationCount( imageDataResponse.getModificationCount() );
        imageDataResponseDTO.setCreationDate( imageDataResponse.getCreationDate() );
        imageDataResponseDTO.setCreationUser( imageDataResponse.getCreationUser() );
        imageDataResponseDTO.setModificationDate( imageDataResponse.getModificationDate() );
        imageDataResponseDTO.setModificationUser( imageDataResponse.getModificationUser() );

        return imageDataResponseDTO;
    }

    @Override
    public ImageInfo map(ImageInfoDTO info) {
        if ( info == null ) {
            return null;
        }

        ImageInfo imageInfo = new ImageInfo();

        imageInfo.position( info.getPosition() );
        imageInfo.visible( info.getVisible() );
        imageInfo.url( info.getUrl() );
        imageInfo.imageId( info.getImageId() );
        imageInfo.id( info.getId() );
        imageInfo.modificationCount( info.getModificationCount() );
        imageInfo.creationDate( info.getCreationDate() );
        imageInfo.creationUser( info.getCreationUser() );
        imageInfo.modificationDate( info.getModificationDate() );
        imageInfo.modificationUser( info.getModificationUser() );

        return imageInfo;
    }

    @Override
    public ImageInfoDTO map(ImageInfo imageInfo) {
        if ( imageInfo == null ) {
            return null;
        }

        ImageInfoDTO imageInfoDTO = new ImageInfoDTO();

        imageInfoDTO.setPosition( imageInfo.getPosition() );
        imageInfoDTO.setVisible( imageInfo.getVisible() );
        imageInfoDTO.setUrl( imageInfo.getUrl() );
        imageInfoDTO.setImageId( imageInfo.getImageId() );
        imageInfoDTO.setId( imageInfo.getId() );
        imageInfoDTO.setModificationCount( imageInfo.getModificationCount() );
        imageInfoDTO.setCreationDate( imageInfo.getCreationDate() );
        imageInfoDTO.setCreationUser( imageInfo.getCreationUser() );
        imageInfoDTO.setModificationDate( imageInfo.getModificationDate() );
        imageInfoDTO.setModificationUser( imageInfo.getModificationUser() );

        return imageInfoDTO;
    }

    @Override
    public List<ImageInfoDTO> map(List<ImageInfo> list) {
        if ( list == null ) {
            return null;
        }

        List<ImageInfoDTO> list1 = new ArrayList<ImageInfoDTO>( list.size() );
        for ( ImageInfo imageInfo : list ) {
            list1.add( map( imageInfo ) );
        }

        return list1;
    }
}
