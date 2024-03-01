package gen.org.tkit.onecx.welcome.bff.rs.internal.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.File;
import java.time.OffsetDateTime;
import java.io.Serializable;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@org.eclipse.microprofile.openapi.annotations.media.Schema(description="")
@JsonTypeName("ImageDataResponse")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2024-03-01T16:06:42.594475014+01:00[Europe/Berlin]")
public class ImageDataResponseDTO  implements Serializable {
  private @Valid String imageId;
  private @Valid byte[] imageData;
  private @Valid Integer dataLength;
  private @Valid String mimeType;
  private @Valid Integer modificationCount;
  private @Valid OffsetDateTime creationDate;
  private @Valid String creationUser;
  private @Valid OffsetDateTime modificationDate;
  private @Valid String modificationUser;

  /**
   **/
  public ImageDataResponseDTO imageId(String imageId) {
    this.imageId = imageId;
    return this;
  }

  
  @org.eclipse.microprofile.openapi.annotations.media.Schema(description = "")
  @JsonProperty("imageId")
  public String getImageId() {
    return imageId;
  }

  @JsonProperty("imageId")
  public void setImageId(String imageId) {
    this.imageId = imageId;
  }

  /**
   **/
  public ImageDataResponseDTO imageData(byte[] imageData) {
    this.imageData = imageData;
    return this;
  }

  
  @org.eclipse.microprofile.openapi.annotations.media.Schema(description = "")
  @JsonProperty("imageData")
  public byte[] getImageData() {
    return imageData;
  }

  @JsonProperty("imageData")
  public void setImageData(byte[] imageData) {
    this.imageData = imageData;
  }

  /**
   **/
  public ImageDataResponseDTO dataLength(Integer dataLength) {
    this.dataLength = dataLength;
    return this;
  }

  
  @org.eclipse.microprofile.openapi.annotations.media.Schema(description = "")
  @JsonProperty("dataLength")
  public Integer getDataLength() {
    return dataLength;
  }

  @JsonProperty("dataLength")
  public void setDataLength(Integer dataLength) {
    this.dataLength = dataLength;
  }

  /**
   **/
  public ImageDataResponseDTO mimeType(String mimeType) {
    this.mimeType = mimeType;
    return this;
  }

  
  @org.eclipse.microprofile.openapi.annotations.media.Schema(description = "")
  @JsonProperty("mimeType")
  public String getMimeType() {
    return mimeType;
  }

  @JsonProperty("mimeType")
  public void setMimeType(String mimeType) {
    this.mimeType = mimeType;
  }

  /**
   **/
  public ImageDataResponseDTO modificationCount(Integer modificationCount) {
    this.modificationCount = modificationCount;
    return this;
  }

  
  @org.eclipse.microprofile.openapi.annotations.media.Schema(description = "")
  @JsonProperty("modificationCount")
  public Integer getModificationCount() {
    return modificationCount;
  }

  @JsonProperty("modificationCount")
  public void setModificationCount(Integer modificationCount) {
    this.modificationCount = modificationCount;
  }

  /**
   **/
  public ImageDataResponseDTO creationDate(OffsetDateTime creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  
  @org.eclipse.microprofile.openapi.annotations.media.Schema(example = "2022-03-10T12:15:50-04:00", description = "")
  @JsonProperty("creationDate")
  public OffsetDateTime getCreationDate() {
    return creationDate;
  }

  @JsonProperty("creationDate")
  public void setCreationDate(OffsetDateTime creationDate) {
    this.creationDate = creationDate;
  }

  /**
   **/
  public ImageDataResponseDTO creationUser(String creationUser) {
    this.creationUser = creationUser;
    return this;
  }

  
  @org.eclipse.microprofile.openapi.annotations.media.Schema(description = "")
  @JsonProperty("creationUser")
  public String getCreationUser() {
    return creationUser;
  }

  @JsonProperty("creationUser")
  public void setCreationUser(String creationUser) {
    this.creationUser = creationUser;
  }

  /**
   **/
  public ImageDataResponseDTO modificationDate(OffsetDateTime modificationDate) {
    this.modificationDate = modificationDate;
    return this;
  }

  
  @org.eclipse.microprofile.openapi.annotations.media.Schema(example = "2022-03-10T12:15:50-04:00", description = "")
  @JsonProperty("modificationDate")
  public OffsetDateTime getModificationDate() {
    return modificationDate;
  }

  @JsonProperty("modificationDate")
  public void setModificationDate(OffsetDateTime modificationDate) {
    this.modificationDate = modificationDate;
  }

  /**
   **/
  public ImageDataResponseDTO modificationUser(String modificationUser) {
    this.modificationUser = modificationUser;
    return this;
  }

  
  @org.eclipse.microprofile.openapi.annotations.media.Schema(description = "")
  @JsonProperty("modificationUser")
  public String getModificationUser() {
    return modificationUser;
  }

  @JsonProperty("modificationUser")
  public void setModificationUser(String modificationUser) {
    this.modificationUser = modificationUser;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ImageDataResponseDTO imageDataResponse = (ImageDataResponseDTO) o;
    return Objects.equals(this.imageId, imageDataResponse.imageId) &&
        Objects.equals(this.imageData, imageDataResponse.imageData) &&
        Objects.equals(this.dataLength, imageDataResponse.dataLength) &&
        Objects.equals(this.mimeType, imageDataResponse.mimeType) &&
        Objects.equals(this.modificationCount, imageDataResponse.modificationCount) &&
        Objects.equals(this.creationDate, imageDataResponse.creationDate) &&
        Objects.equals(this.creationUser, imageDataResponse.creationUser) &&
        Objects.equals(this.modificationDate, imageDataResponse.modificationDate) &&
        Objects.equals(this.modificationUser, imageDataResponse.modificationUser);
  }

  @Override
  public int hashCode() {
    return Objects.hash(imageId, imageData, dataLength, mimeType, modificationCount, creationDate, creationUser, modificationDate, modificationUser);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImageDataResponseDTO {\n");
    
    sb.append("    imageId: ").append(toIndentedString(imageId)).append("\n");
    sb.append("    imageData: ").append(toIndentedString(imageData)).append("\n");
    sb.append("    dataLength: ").append(toIndentedString(dataLength)).append("\n");
    sb.append("    mimeType: ").append(toIndentedString(mimeType)).append("\n");
    sb.append("    modificationCount: ").append(toIndentedString(modificationCount)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    creationUser: ").append(toIndentedString(creationUser)).append("\n");
    sb.append("    modificationDate: ").append(toIndentedString(modificationDate)).append("\n");
    sb.append("    modificationUser: ").append(toIndentedString(modificationUser)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


}

