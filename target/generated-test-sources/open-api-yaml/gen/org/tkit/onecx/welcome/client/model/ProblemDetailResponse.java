package gen.org.tkit.onecx.welcome.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import gen.org.tkit.onecx.welcome.client.model.ProblemDetailInvalidParam;
import gen.org.tkit.onecx.welcome.client.model.ProblemDetailParam;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.Type;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProblemDetailResponse  {

    private String errorCode;
    private String detail;
    private List<ProblemDetailParam> params;
    private List<ProblemDetailInvalidParam> invalidParams;

    /**
    * Get errorCode
    * @return errorCode
    **/
    @JsonProperty("errorCode")
          @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Set errorCode
     **/
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public ProblemDetailResponse errorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    /**
    * Get detail
    * @return detail
    **/
    @JsonProperty("detail")
          @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
    public String getDetail() {
        return detail;
    }

    /**
     * Set detail
     **/
    public void setDetail(String detail) {
        this.detail = detail;
    }

    public ProblemDetailResponse detail(String detail) {
        this.detail = detail;
        return this;
    }

    /**
    * Get params
    * @return params
    **/
    @JsonProperty("params")
          @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
    public List<ProblemDetailParam> getParams() {
        return params;
    }

    /**
     * Set params
     **/
    public void setParams(List<ProblemDetailParam> params) {
        this.params = params;
    }

    public ProblemDetailResponse params(List<ProblemDetailParam> params) {
        this.params = params;
        return this;
    }
    public ProblemDetailResponse addParamsItem(ProblemDetailParam paramsItem) {
        if (this.params == null){
            params = new ArrayList<>();
        }
        this.params.add(paramsItem);
        return this;
    }

    /**
    * Get invalidParams
    * @return invalidParams
    **/
    @JsonProperty("invalidParams")
          @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
    public List<ProblemDetailInvalidParam> getInvalidParams() {
        return invalidParams;
    }

    /**
     * Set invalidParams
     **/
    public void setInvalidParams(List<ProblemDetailInvalidParam> invalidParams) {
        this.invalidParams = invalidParams;
    }

    public ProblemDetailResponse invalidParams(List<ProblemDetailInvalidParam> invalidParams) {
        this.invalidParams = invalidParams;
        return this;
    }
    public ProblemDetailResponse addInvalidParamsItem(ProblemDetailInvalidParam invalidParamsItem) {
        if (this.invalidParams == null){
            invalidParams = new ArrayList<>();
        }
        this.invalidParams.add(invalidParamsItem);
        return this;
    }

    /**
     * Create a string representation of this pojo.
     **/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProblemDetailResponse {\n");

        sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
        sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
        sb.append("    params: ").append(toIndentedString(params)).append("\n");
        sb.append("    invalidParams: ").append(toIndentedString(invalidParams)).append("\n");
        
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
    public static class ProblemDetailResponseQueryParam  {

        @jakarta.ws.rs.QueryParam("errorCode")
        private String errorCode;
        @jakarta.ws.rs.QueryParam("detail")
        private String detail;
        @jakarta.ws.rs.QueryParam("params")
        private List<ProblemDetailParam> params = null;
        @jakarta.ws.rs.QueryParam("invalidParams")
        private List<ProblemDetailInvalidParam> invalidParams = null;

        /**
        * Get errorCode
        * @return errorCode
        **/
        @JsonProperty("errorCode")
        public String getErrorCode() {
            return errorCode;
        }

        /**
         * Set errorCode
         **/
        public void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }

        public ProblemDetailResponseQueryParam errorCode(String errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        /**
        * Get detail
        * @return detail
        **/
        @JsonProperty("detail")
        public String getDetail() {
            return detail;
        }

        /**
         * Set detail
         **/
        public void setDetail(String detail) {
            this.detail = detail;
        }

        public ProblemDetailResponseQueryParam detail(String detail) {
            this.detail = detail;
            return this;
        }

        /**
        * Get params
        * @return params
        **/
        @JsonProperty("params")
        public List<ProblemDetailParam> getParams() {
            return params;
        }

        /**
         * Set params
         **/
        public void setParams(List<ProblemDetailParam> params) {
            this.params = params;
        }

        public ProblemDetailResponseQueryParam params(List<ProblemDetailParam> params) {
            this.params = params;
            return this;
        }
        public ProblemDetailResponseQueryParam addParamsItem(ProblemDetailParam paramsItem) {
            this.params.add(paramsItem);
            return this;
        }

        /**
        * Get invalidParams
        * @return invalidParams
        **/
        @JsonProperty("invalidParams")
        public List<ProblemDetailInvalidParam> getInvalidParams() {
            return invalidParams;
        }

        /**
         * Set invalidParams
         **/
        public void setInvalidParams(List<ProblemDetailInvalidParam> invalidParams) {
            this.invalidParams = invalidParams;
        }

        public ProblemDetailResponseQueryParam invalidParams(List<ProblemDetailInvalidParam> invalidParams) {
            this.invalidParams = invalidParams;
            return this;
        }
        public ProblemDetailResponseQueryParam addInvalidParamsItem(ProblemDetailInvalidParam invalidParamsItem) {
            this.invalidParams.add(invalidParamsItem);
            return this;
        }

        /**
         * Create a string representation of this pojo.
         **/
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("class ProblemDetailResponseQueryParam {\n");

            sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
            sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
            sb.append("    params: ").append(toIndentedString(params)).append("\n");
            sb.append("    invalidParams: ").append(toIndentedString(invalidParams)).append("\n");
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