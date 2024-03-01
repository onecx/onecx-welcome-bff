package gen.org.tkit.onecx.welcome.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.Type;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageInfo  {

    private String position;
    private Boolean visible;
    private String url;
    private String imageId;
    private String id;
    private Integer modificationCount;
    private OffsetDateTime creationDate;
    private String creationUser;
    private OffsetDateTime modificationDate;
    private String modificationUser;

    /**
    * Get position
    * @return position
    **/
    @JsonProperty("position")
          @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
    public String getPosition() {
        return position;
    }

    /**
     * Set position
     **/
    public void setPosition(String position) {
        this.position = position;
    }

    public ImageInfo position(String position) {
        this.position = position;
        return this;
    }

    /**
    * Get visible
    * @return visible
    **/
    @JsonProperty("visible")
          @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
    public Boolean getVisible() {
        return visible;
    }

    /**
     * Set visible
     **/
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public ImageInfo visible(Boolean visible) {
        this.visible = visible;
        return this;
    }

    /**
    * Get url
    * @return url
    **/
    @JsonProperty("url")
          @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
    public String getUrl() {
        return url;
    }

    /**
     * Set url
     **/
    public void setUrl(String url) {
        this.url = url;
    }

    public ImageInfo url(String url) {
        this.url = url;
        return this;
    }

    /**
    * Get imageId
    * @return imageId
    **/
    @JsonProperty("imageId")
          @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
    public String getImageId() {
        return imageId;
    }

    /**
     * Set imageId
     **/
    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public ImageInfo imageId(String imageId) {
        this.imageId = imageId;
        return this;
    }

    /**
    * Get id
    * @return id
    **/
    @JsonProperty("id")
          @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Set id
     **/
    public void setId(String id) {
        this.id = id;
    }

    public ImageInfo id(String id) {
        this.id = id;
        return this;
    }

    /**
    * Get modificationCount
    * @return modificationCount
    **/
    @JsonProperty("modificationCount")
          @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
    public Integer getModificationCount() {
        return modificationCount;
    }

    /**
     * Set modificationCount
     **/
    public void setModificationCount(Integer modificationCount) {
        this.modificationCount = modificationCount;
    }

    public ImageInfo modificationCount(Integer modificationCount) {
        this.modificationCount = modificationCount;
        return this;
    }

    /**
    * Get creationDate
    * @return creationDate
    **/
    @JsonProperty("creationDate")
          @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
    public OffsetDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * Set creationDate
     **/
    public void setCreationDate(OffsetDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public ImageInfo creationDate(OffsetDateTime creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    /**
    * Get creationUser
    * @return creationUser
    **/
    @JsonProperty("creationUser")
          @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
    public String getCreationUser() {
        return creationUser;
    }

    /**
     * Set creationUser
     **/
    public void setCreationUser(String creationUser) {
        this.creationUser = creationUser;
    }

    public ImageInfo creationUser(String creationUser) {
        this.creationUser = creationUser;
        return this;
    }

    /**
    * Get modificationDate
    * @return modificationDate
    **/
    @JsonProperty("modificationDate")
          @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
    public OffsetDateTime getModificationDate() {
        return modificationDate;
    }

    /**
     * Set modificationDate
     **/
    public void setModificationDate(OffsetDateTime modificationDate) {
        this.modificationDate = modificationDate;
    }

    public ImageInfo modificationDate(OffsetDateTime modificationDate) {
        this.modificationDate = modificationDate;
        return this;
    }

    /**
    * Get modificationUser
    * @return modificationUser
    **/
    @JsonProperty("modificationUser")
          @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
    public String getModificationUser() {
        return modificationUser;
    }

    /**
     * Set modificationUser
     **/
    public void setModificationUser(String modificationUser) {
        this.modificationUser = modificationUser;
    }

    public ImageInfo modificationUser(String modificationUser) {
        this.modificationUser = modificationUser;
        return this;
    }

    /**
     * Create a string representation of this pojo.
     **/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ImageInfo {\n");

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
    private static String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ImageInfoQueryParam  {

        @jakarta.ws.rs.QueryParam("position")
        private String position;
        @jakarta.ws.rs.QueryParam("visible")
        private Boolean visible;
        @jakarta.ws.rs.QueryParam("url")
        private String url;
        @jakarta.ws.rs.QueryParam("imageId")
        private String imageId;
        @jakarta.ws.rs.QueryParam("id")
        private String id;
        @jakarta.ws.rs.QueryParam("modificationCount")
        private Integer modificationCount;
        @jakarta.ws.rs.QueryParam("creationDate")
        private OffsetDateTime creationDate;
        @jakarta.ws.rs.QueryParam("creationUser")
        private String creationUser;
        @jakarta.ws.rs.QueryParam("modificationDate")
        private OffsetDateTime modificationDate;
        @jakarta.ws.rs.QueryParam("modificationUser")
        private String modificationUser;

        /**
        * Get position
        * @return position
        **/
        @JsonProperty("position")
        public String getPosition() {
            return position;
        }

        /**
         * Set position
         **/
        public void setPosition(String position) {
            this.position = position;
        }

        public ImageInfoQueryParam position(String position) {
            this.position = position;
            return this;
        }

        /**
        * Get visible
        * @return visible
        **/
        @JsonProperty("visible")
        public Boolean getVisible() {
            return visible;
        }

        /**
         * Set visible
         **/
        public void setVisible(Boolean visible) {
            this.visible = visible;
        }

        public ImageInfoQueryParam visible(Boolean visible) {
            this.visible = visible;
            return this;
        }

        /**
        * Get url
        * @return url
        **/
        @JsonProperty("url")
        public String getUrl() {
            return url;
        }

        /**
         * Set url
         **/
        public void setUrl(String url) {
            this.url = url;
        }

        public ImageInfoQueryParam url(String url) {
            this.url = url;
            return this;
        }

        /**
        * Get imageId
        * @return imageId
        **/
        @JsonProperty("imageId")
        public String getImageId() {
            return imageId;
        }

        /**
         * Set imageId
         **/
        public void setImageId(String imageId) {
            this.imageId = imageId;
        }

        public ImageInfoQueryParam imageId(String imageId) {
            this.imageId = imageId;
            return this;
        }

        /**
        * Get id
        * @return id
        **/
        @JsonProperty("id")
        public String getId() {
            return id;
        }

        /**
         * Set id
         **/
        public void setId(String id) {
            this.id = id;
        }

        public ImageInfoQueryParam id(String id) {
            this.id = id;
            return this;
        }

        /**
        * Get modificationCount
        * @return modificationCount
        **/
        @JsonProperty("modificationCount")
        public Integer getModificationCount() {
            return modificationCount;
        }

        /**
         * Set modificationCount
         **/
        public void setModificationCount(Integer modificationCount) {
            this.modificationCount = modificationCount;
        }

        public ImageInfoQueryParam modificationCount(Integer modificationCount) {
            this.modificationCount = modificationCount;
            return this;
        }

        /**
        * Get creationDate
        * @return creationDate
        **/
        @JsonProperty("creationDate")
        public OffsetDateTime getCreationDate() {
            return creationDate;
        }

        /**
         * Set creationDate
         **/
        public void setCreationDate(OffsetDateTime creationDate) {
            this.creationDate = creationDate;
        }

        public ImageInfoQueryParam creationDate(OffsetDateTime creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        /**
        * Get creationUser
        * @return creationUser
        **/
        @JsonProperty("creationUser")
        public String getCreationUser() {
            return creationUser;
        }

        /**
         * Set creationUser
         **/
        public void setCreationUser(String creationUser) {
            this.creationUser = creationUser;
        }

        public ImageInfoQueryParam creationUser(String creationUser) {
            this.creationUser = creationUser;
            return this;
        }

        /**
        * Get modificationDate
        * @return modificationDate
        **/
        @JsonProperty("modificationDate")
        public OffsetDateTime getModificationDate() {
            return modificationDate;
        }

        /**
         * Set modificationDate
         **/
        public void setModificationDate(OffsetDateTime modificationDate) {
            this.modificationDate = modificationDate;
        }

        public ImageInfoQueryParam modificationDate(OffsetDateTime modificationDate) {
            this.modificationDate = modificationDate;
            return this;
        }

        /**
        * Get modificationUser
        * @return modificationUser
        **/
        @JsonProperty("modificationUser")
        public String getModificationUser() {
            return modificationUser;
        }

        /**
         * Set modificationUser
         **/
        public void setModificationUser(String modificationUser) {
            this.modificationUser = modificationUser;
        }

        public ImageInfoQueryParam modificationUser(String modificationUser) {
            this.modificationUser = modificationUser;
            return this;
        }

        /**
         * Create a string representation of this pojo.
         **/
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("class ImageInfoQueryParam {\n");

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
        private static String toIndentedString(Object o) {
            if (o == null) {
                return "null";
            }
            return o.toString().replace("\n", "\n    ");
        }
    }
}