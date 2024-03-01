package gen.org.tkit.onecx.welcome.bff.rs.internal.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import gen.org.tkit.onecx.welcome.bff.rs.internal.model.ProblemDetailInvalidParamDTO;
import gen.org.tkit.onecx.welcome.bff.rs.internal.model.ProblemDetailParamDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.Serializable;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@org.eclipse.microprofile.openapi.annotations.media.Schema(description="")
@JsonTypeName("ProblemDetailResponse")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2024-03-01T16:06:42.594475014+01:00[Europe/Berlin]")
public class ProblemDetailResponseDTO  implements Serializable {
  private @Valid String errorCode;
  private @Valid String detail;
  private @Valid List<@Valid ProblemDetailParamDTO> params;
  private @Valid List<@Valid ProblemDetailInvalidParamDTO> invalidParams;

  /**
   **/
  public ProblemDetailResponseDTO errorCode(String errorCode) {
    this.errorCode = errorCode;
    return this;
  }

  
  @org.eclipse.microprofile.openapi.annotations.media.Schema(description = "")
  @JsonProperty("errorCode")
  public String getErrorCode() {
    return errorCode;
  }

  @JsonProperty("errorCode")
  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  /**
   **/
  public ProblemDetailResponseDTO detail(String detail) {
    this.detail = detail;
    return this;
  }

  
  @org.eclipse.microprofile.openapi.annotations.media.Schema(description = "")
  @JsonProperty("detail")
  public String getDetail() {
    return detail;
  }

  @JsonProperty("detail")
  public void setDetail(String detail) {
    this.detail = detail;
  }

  /**
   **/
  public ProblemDetailResponseDTO params(List<@Valid ProblemDetailParamDTO> params) {
    this.params = params;
    return this;
  }

  
  @org.eclipse.microprofile.openapi.annotations.media.Schema(description = "")
  @JsonProperty("params")
  public List<ProblemDetailParamDTO> getParams() {
    return params;
  }

  @JsonProperty("params")
  public void setParams(List<@Valid ProblemDetailParamDTO> params) {
    this.params = params;
  }

  public ProblemDetailResponseDTO addParamsItem(ProblemDetailParamDTO paramsItem) {
    if (this.params == null) {
      this.params = new ArrayList<>();
    }

    this.params.add(paramsItem);
    return this;
  }

  public ProblemDetailResponseDTO removeParamsItem(ProblemDetailParamDTO paramsItem) {
    if (paramsItem != null && this.params != null) {
      this.params.remove(paramsItem);
    }

    return this;
  }
  /**
   **/
  public ProblemDetailResponseDTO invalidParams(List<@Valid ProblemDetailInvalidParamDTO> invalidParams) {
    this.invalidParams = invalidParams;
    return this;
  }

  
  @org.eclipse.microprofile.openapi.annotations.media.Schema(description = "")
  @JsonProperty("invalidParams")
  public List<ProblemDetailInvalidParamDTO> getInvalidParams() {
    return invalidParams;
  }

  @JsonProperty("invalidParams")
  public void setInvalidParams(List<@Valid ProblemDetailInvalidParamDTO> invalidParams) {
    this.invalidParams = invalidParams;
  }

  public ProblemDetailResponseDTO addInvalidParamsItem(ProblemDetailInvalidParamDTO invalidParamsItem) {
    if (this.invalidParams == null) {
      this.invalidParams = new ArrayList<>();
    }

    this.invalidParams.add(invalidParamsItem);
    return this;
  }

  public ProblemDetailResponseDTO removeInvalidParamsItem(ProblemDetailInvalidParamDTO invalidParamsItem) {
    if (invalidParamsItem != null && this.invalidParams != null) {
      this.invalidParams.remove(invalidParamsItem);
    }

    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProblemDetailResponseDTO problemDetailResponse = (ProblemDetailResponseDTO) o;
    return Objects.equals(this.errorCode, problemDetailResponse.errorCode) &&
        Objects.equals(this.detail, problemDetailResponse.detail) &&
        Objects.equals(this.params, problemDetailResponse.params) &&
        Objects.equals(this.invalidParams, problemDetailResponse.invalidParams);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errorCode, detail, params, invalidParams);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProblemDetailResponseDTO {\n");
    
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


}

