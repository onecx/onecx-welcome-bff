package gen.org.tkit.onecx.welcome.bff.rs.internal.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
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
@JsonTypeName("ImageInfo")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2024-03-01T16:06:42.594475014+01:00[Europe/Berlin]")
public class ImageInfoDTO  implements Serializable {
  private @Valid String position;
  private @Valid Boolean visible;
  private @Valid String url;
  private @Valid String imageId;
  private @Valid String id;
  private @Valid Integer modificationCount;
  private @Valid OffsetDateTime creationDate;
  private @Valid String creationUser;
  private @Valid OffsetDateTime modificationDate;
  private @Valid String modificationUser;

  /**
   **/
  public ImageInfoDTO position(String position) {
    this.position = position;
    return this;
  }

  
  @org.eclipse.microprofile.openapi.annotations.media.Schema(description = "")
  @JsonProperty("position")
  public String getPosition() {
    return position;
  }

  @JsonProperty("position")
  public void setPosition(String position) {
    this.position = position;
  }

  /**
   **/
  public ImageInfoDTO visible(Boolean visible) {
    this.visible = visible;
    return this;
  }

  
  @org.eclipse.microprofile.openapi.annotations.media.Schema(description = "")
  @JsonProperty("visible")
  public Boolean getVisible() {
    return visible;
  }

  @JsonProperty("visible")
  public void setVisible(Boolean visible) {
    this.visible = visible;
  }

  /**
   **/
  public ImageInfoDTO url(String url) {
    this.url = url;
    return this;
  }

  
  @org.eclipse.microprofile.openapi.annotations.media.Schema(description = "")
  @JsonProperty("url")
  public String getUrl() {
    return url;
  }

  @JsonProperty("url")
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   **/
  public ImageInfoDTO imageId(String imageId) {
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
  public ImageInfoDTO id(String id) {
    this.id = id;
    return this;
  }

  
  @org.eclipse.microprofile.openapi.annotations.media.Schema(description = "")
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(String id) {
    this.id = id;
  }

  /**
   **/
  public ImageInfoDTO modificationCount(Integer modificationCount) {
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
  public ImageInfoDTO creationDate(OffsetDateTime creationDate) {
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
  public ImageInfoDTO creationUser(String creationUser) {
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
  public ImageInfoDTO modificationDate(OffsetDateTime modificationDate) {
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
  public ImageInfoDTO modificationUser(String modificationUser) {
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
    ImageInfoDTO imageInfo = (ImageInfoDTO) o;
    return Objects.equals(this.position, imageInfo.position) &&
        Objects.equals(this.visible, imageInfo.visible) &&
        Objects.equals(this.url, imageInfo.url) &&
        Objects.equals(this.imageId, imageInfo.imageId) &&
        Objects.equals(this.id, imageInfo.id) &&
        Objects.equals(this.modificationCount, imageInfo.modificationCount) &&
        Objects.equals(this.creationDate, imageInfo.creationDate) &&
        Objects.equals(this.creationUser, imageInfo.creationUser) &&
        Objects.equals(this.modificationDate, imageInfo.modificationDate) &&
        Objects.equals(this.modificationUser, imageInfo.modificationUser);
  }

  @Override
  public int hashCode() {
    return Objects.hash(position, visible, url, imageId, id, modificationCount, creationDate, creationUser, modificationDate, modificationUser);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImageInfoDTO {\n");
    
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
    sb.append("    visible: ").append(toIndentedString(visible)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    imageId: ").append(toIndentedString(imageId)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

