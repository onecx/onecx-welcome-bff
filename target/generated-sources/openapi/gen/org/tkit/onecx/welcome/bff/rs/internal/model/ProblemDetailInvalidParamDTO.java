package gen.org.tkit.onecx.welcome.bff.rs.internal.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.Serializable;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@org.eclipse.microprofile.openapi.annotations.media.Schema(description="")
@JsonTypeName("ProblemDetailInvalidParam")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2024-03-01T16:06:42.594475014+01:00[Europe/Berlin]")
public class ProblemDetailInvalidParamDTO  implements Serializable {
  private @Valid String name;
  private @Valid String message;

  /**
   **/
  public ProblemDetailInvalidParamDTO name(String name) {
    this.name = name;
    return this;
  }

  
  @org.eclipse.microprofile.openapi.annotations.media.Schema(description = "")
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  /**
   **/
  public ProblemDetailInvalidParamDTO message(String message) {
    this.message = message;
    return this;
  }

  
  @org.eclipse.microprofile.openapi.annotations.media.Schema(description = "")
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  @JsonProperty("message")
  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProblemDetailInvalidParamDTO problemDetailInvalidParam = (ProblemDetailInvalidParamDTO) o;
    return Objects.equals(this.name, problemDetailInvalidParam.name) &&
        Objects.equals(this.message, problemDetailInvalidParam.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProblemDetailInvalidParamDTO {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

