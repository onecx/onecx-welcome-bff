package gen.org.tkit.onecx.welcome.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.File;
import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.Type;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageDataResponse  {

    private String imageId;
    private byte[] imageData;
    private Integer dataLength;
    private String mimeType;
    private Integer modificationCount;
    private OffsetDateTime creationDate;
    private String creationUser;
    private OffsetDateTime modificationDate;
    private String modificationUser;

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

    public ImageDataResponse imageId(String imageId) {
        this.imageId = imageId;
        return this;
    }

    /**
    * Get imageData
    * @return imageData
    **/
    @JsonProperty("imageData")
          @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
    public byte[] getImageData() {
        return imageData;
    }

    /**
     * Set imageData
     **/
    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public ImageDataResponse imageData(byte[] imageData) {
        this.imageData = imageData;
        return this;
    }

    /**
    * Get dataLength
    * @return dataLength
    **/
    @JsonProperty("dataLength")
          @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
    public Integer getDataLength() {
        return dataLength;
    }

    /**
     * Set dataLength
     **/
    public void setDataLength(Integer dataLength) {
        this.dataLength = dataLength;
    }

    public ImageDataResponse dataLength(Integer dataLength) {
        this.dataLength = dataLength;
        return this;
    }

    /**
    * Get mimeType
    * @return mimeType
    **/
    @JsonProperty("mimeType")
          @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
    public String getMimeType() {
        return mimeType;
    }

    /**
     * Set mimeType
     **/
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public ImageDataResponse mimeType(String mimeType) {
        this.mimeType = mimeType;
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

    public ImageDataResponse modificationCount(Integer modificationCount) {
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

    public ImageDataResponse creationDate(OffsetDateTime creationDate) {
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

    public ImageDataResponse creationUser(String creationUser) {
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

    public ImageDataResponse modificationDate(OffsetDateTime modificationDate) {
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

    public ImageDataResponse modificationUser(String modificationUser) {
        this.modificationUser = modificationUser;
        return this;
    }

    /**
     * Create a string representation of this pojo.
     **/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ImageDataResponse {\n");

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
    private static String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ImageDataResponseQueryParam  {

        @jakarta.ws.rs.QueryParam("imageId")
        private String imageId;
        @jakarta.ws.rs.QueryParam("imageData")
        private byte[] imageData;
        @jakarta.ws.rs.QueryParam("dataLength")
        private Integer dataLength;
        @jakarta.ws.rs.QueryParam("mimeType")
        private String mimeType;
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

        public ImageDataResponseQueryParam imageId(String imageId) {
            this.imageId = imageId;
            return this;
        }

        /**
        * Get imageData
        * @return imageData
        **/
        @JsonProperty("imageData")
        public byte[] getImageData() {
            return imageData;
        }

        /**
         * Set imageData
         **/
        public void setImageData(byte[] imageData) {
            this.imageData = imageData;
        }

        public ImageDataResponseQueryParam imageData(byte[] imageData) {
            this.imageData = imageData;
            return this;
        }

        /**
        * Get dataLength
        * @return dataLength
        **/
        @JsonProperty("dataLength")
        public Integer getDataLength() {
            return dataLength;
        }

        /**
         * Set dataLength
         **/
        public void setDataLength(Integer dataLength) {
            this.dataLength = dataLength;
        }

        public ImageDataResponseQueryParam dataLength(Integer dataLength) {
            this.dataLength = dataLength;
            return this;
        }

        /**
        * Get mimeType
        * @return mimeType
        **/
        @JsonProperty("mimeType")
        public String getMimeType() {
            return mimeType;
        }

        /**
         * Set mimeType
         **/
        public void setMimeType(String mimeType) {
            this.mimeType = mimeType;
        }

        public ImageDataResponseQueryParam mimeType(String mimeType) {
            this.mimeType = mimeType;
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

        public ImageDataResponseQueryParam modificationCount(Integer modificationCount) {
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

        public ImageDataResponseQueryParam creationDate(OffsetDateTime creationDate) {
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

        public ImageDataResponseQueryParam creationUser(String creationUser) {
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

        public ImageDataResponseQueryParam modificationDate(OffsetDateTime modificationDate) {
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

        public ImageDataResponseQueryParam modificationUser(String modificationUser) {
            this.modificationUser = modificationUser;
            return this;
        }

        /**
         * Create a string representation of this pojo.
         **/
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("class ImageDataResponseQueryParam {\n");

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
        private static String toIndentedString(Object o) {
            if (o == null) {
                return "null";
            }
            return o.toString().replace("\n", "\n    ");
        }
    }
}