package gen.org.tkit.onecx.welcome.bff.rs.internal;

import java.io.File;
import gen.org.tkit.onecx.welcome.bff.rs.internal.model.ImageDataResponseDTO;
import gen.org.tkit.onecx.welcome.bff.rs.internal.model.ImageInfoDTO;
import gen.org.tkit.onecx.welcome.bff.rs.internal.model.ProblemDetailResponseDTO;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;




import java.io.InputStream;
import java.util.Map;
import java.util.List;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

@org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition(
   info = @org.eclipse.microprofile.openapi.annotations.info.Info(
        title = "", version="1.0.0", description="",
        license = @org.eclipse.microprofile.openapi.annotations.info.License(name = "Apache 2.0", url = "http://www.apache.org/licenses/LICENSE-2.0.html"),
        contact = @org.eclipse.microprofile.openapi.annotations.info.Contact(name = "", email = "tkit_dev@1000kit.org")
   ),
   tags = @org.eclipse.microprofile.openapi.annotations.tags.Tag(name="", description="")
)
@Path("/images")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2024-03-01T16:06:42.594475014+01:00[Europe/Berlin]")
public interface ImagesInternalApiService {


    
    @io.quarkus.security.PermissionsAllowed({ "onecx:welcome#write" })
    
    @POST
    @Consumes({ "image/*" })
    @Produces({ "application/json" })
    
    @org.eclipse.microprofile.openapi.annotations.Operation(operationId = "createImage", summary = "", description = "create image")
    @org.eclipse.microprofile.openapi.annotations.tags.Tag(name="imagesInternal")
    @org.eclipse.microprofile.openapi.annotations.responses.APIResponses(value = { 
        @org.eclipse.microprofile.openapi.annotations.responses.APIResponse(responseCode = "201", description = "CREATED",  content = { 
               @org.eclipse.microprofile.openapi.annotations.media.Content(mediaType = "application/json", schema = @org.eclipse.microprofile.openapi.annotations.media.Schema(implementation = ImageDataResponseDTO.class))
        }),
        @org.eclipse.microprofile.openapi.annotations.responses.APIResponse(responseCode = "400", description = "BAD REQUEST",  content = { 
               @org.eclipse.microprofile.openapi.annotations.media.Content(mediaType = "application/json", schema = @org.eclipse.microprofile.openapi.annotations.media.Schema(implementation = ProblemDetailResponseDTO.class))
        })
    })
    Response createImage(@HeaderParam("Content-Length") @NotNull @Min(1) @Max(110000)   Integer contentLength,@Valid byte[] body);





    
    @io.quarkus.security.PermissionsAllowed({ "onecx:welcome#write" })
    
    @POST
    @Path("/info")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    
    @org.eclipse.microprofile.openapi.annotations.Operation(operationId = "createImageInfo", summary = "", description = "create image info")
    @org.eclipse.microprofile.openapi.annotations.tags.Tag(name="imagesInternal")
    @org.eclipse.microprofile.openapi.annotations.responses.APIResponses(value = { 
        @org.eclipse.microprofile.openapi.annotations.responses.APIResponse(responseCode = "201", description = "CREATED",  content = { 
               @org.eclipse.microprofile.openapi.annotations.media.Content(mediaType = "application/json")
        }),
        @org.eclipse.microprofile.openapi.annotations.responses.APIResponse(responseCode = "400", description = "BAD REQUEST",  content = { 
               @org.eclipse.microprofile.openapi.annotations.media.Content(mediaType = "application/json", schema = @org.eclipse.microprofile.openapi.annotations.media.Schema(implementation = ProblemDetailResponseDTO.class))
        })
    })
    Response createImageInfo(@Valid @NotNull ImageInfoDTO imageInfoDTO);





    
    @io.quarkus.security.PermissionsAllowed({ "onecx:welcome#delete" })
    
    @DELETE
    @Path("/info/{id}")
    
    @org.eclipse.microprofile.openapi.annotations.Operation(operationId = "deleteImageInfoById", summary = "", description = "delete image information")
    @org.eclipse.microprofile.openapi.annotations.tags.Tag(name="imagesInternal")
    @org.eclipse.microprofile.openapi.annotations.responses.APIResponses(value = { 
        @org.eclipse.microprofile.openapi.annotations.responses.APIResponse(responseCode = "204", description = "DELETED",  content = {
            
        }),
        @org.eclipse.microprofile.openapi.annotations.responses.APIResponse(responseCode = "404", description = "NOT FOUND",  content = {
            
        })
    })
    Response deleteImageInfoById(@PathParam("id") String id);





    
    @io.quarkus.security.PermissionsAllowed({ "onecx:welcome#read" })
    
    @GET
    @Path("/info")
    @Produces({ "application/json" })
    
    @org.eclipse.microprofile.openapi.annotations.Operation(operationId = "getAllImageInfos", summary = "", description = "get all existing image-infos")
    @org.eclipse.microprofile.openapi.annotations.tags.Tag(name="imagesInternal")
    @org.eclipse.microprofile.openapi.annotations.responses.APIResponses(value = { 
        @org.eclipse.microprofile.openapi.annotations.responses.APIResponse(responseCode = "200", description = "OK",  content = { 
               @org.eclipse.microprofile.openapi.annotations.media.Content(mediaType = "application/json", schema = @org.eclipse.microprofile.openapi.annotations.media.Schema(implementation = ImageInfoDTO.class, type = org.eclipse.microprofile.openapi.annotations.enums.SchemaType.ARRAY ))
        })
    })
    Response getAllImageInfos();





    
    @io.quarkus.security.PermissionsAllowed({ "onecx:welcome#read" })
    
    @GET
    @Path("/{id}")
    @Produces({ "application/json" })
    
    @org.eclipse.microprofile.openapi.annotations.Operation(operationId = "getImageById", summary = "", description = "get Image by id")
    @org.eclipse.microprofile.openapi.annotations.tags.Tag(name="imagesInternal")
    @org.eclipse.microprofile.openapi.annotations.responses.APIResponses(value = { 
        @org.eclipse.microprofile.openapi.annotations.responses.APIResponse(responseCode = "200", description = "OK",  content = { 
               @org.eclipse.microprofile.openapi.annotations.media.Content(mediaType = "application/json", schema = @org.eclipse.microprofile.openapi.annotations.media.Schema(implementation = ImageDataResponseDTO.class))
        }),
        @org.eclipse.microprofile.openapi.annotations.responses.APIResponse(responseCode = "404", description = "NOT FOUND",  content = { 
               @org.eclipse.microprofile.openapi.annotations.media.Content(mediaType = "application/json")
        })
    })
    Response getImageById(@PathParam("id") String id);





    
    @io.quarkus.security.PermissionsAllowed({ "onecx:welcome#read" })
    
    @GET
    @Path("/info/{id}")
    @Produces({ "application/json" })
    
    @org.eclipse.microprofile.openapi.annotations.Operation(operationId = "getImageInfoById", summary = "", description = "get Image information by id")
    @org.eclipse.microprofile.openapi.annotations.tags.Tag(name="imagesInternal")
    @org.eclipse.microprofile.openapi.annotations.responses.APIResponses(value = { 
        @org.eclipse.microprofile.openapi.annotations.responses.APIResponse(responseCode = "200", description = "OK",  content = { 
               @org.eclipse.microprofile.openapi.annotations.media.Content(mediaType = "application/json", schema = @org.eclipse.microprofile.openapi.annotations.media.Schema(implementation = ImageInfoDTO.class))
        }),
        @org.eclipse.microprofile.openapi.annotations.responses.APIResponse(responseCode = "404", description = "NOT FOUND",  content = { 
               @org.eclipse.microprofile.openapi.annotations.media.Content(mediaType = "application/json")
        })
    })
    Response getImageInfoById(@PathParam("id") String id);





    
    @io.quarkus.security.PermissionsAllowed({ "onecx:welcome#write" })
    
    @PUT
    @Path("/{id}")
    @Consumes({ "image/*" })
    @Produces({ "application/json" })
    
    @org.eclipse.microprofile.openapi.annotations.Operation(operationId = "updateImageById", summary = "", description = "update Image by id")
    @org.eclipse.microprofile.openapi.annotations.tags.Tag(name="imagesInternal")
    @org.eclipse.microprofile.openapi.annotations.responses.APIResponses(value = { 
        @org.eclipse.microprofile.openapi.annotations.responses.APIResponse(responseCode = "200", description = "OK",  content = { 
               @org.eclipse.microprofile.openapi.annotations.media.Content(mediaType = "application/json", schema = @org.eclipse.microprofile.openapi.annotations.media.Schema(implementation = ImageDataResponseDTO.class))
        }),
        @org.eclipse.microprofile.openapi.annotations.responses.APIResponse(responseCode = "400", description = "BAD REQUEST",  content = { 
               @org.eclipse.microprofile.openapi.annotations.media.Content(mediaType = "application/json", schema = @org.eclipse.microprofile.openapi.annotations.media.Schema(implementation = ProblemDetailResponseDTO.class))
        })
    })
    Response updateImageById(@PathParam("id") String id,@HeaderParam("Content-Length") @NotNull @Min(1) @Max(110000)   Integer contentLength,@Valid byte[] body);





    
    @io.quarkus.security.PermissionsAllowed({ "onecx:welcome#write" })
    
    @PUT
    @Path("/info/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    
    @org.eclipse.microprofile.openapi.annotations.Operation(operationId = "updateImageInfo", summary = "", description = "update Image information")
    @org.eclipse.microprofile.openapi.annotations.tags.Tag(name="imagesInternal")
    @org.eclipse.microprofile.openapi.annotations.responses.APIResponses(value = { 
        @org.eclipse.microprofile.openapi.annotations.responses.APIResponse(responseCode = "200", description = "UPDATED",  content = { 
               @org.eclipse.microprofile.openapi.annotations.media.Content(mediaType = "application/json", schema = @org.eclipse.microprofile.openapi.annotations.media.Schema(implementation = ImageInfoDTO.class))
        }),
        @org.eclipse.microprofile.openapi.annotations.responses.APIResponse(responseCode = "400", description = "BAD REQUEST",  content = { 
               @org.eclipse.microprofile.openapi.annotations.media.Content(mediaType = "application/json", schema = @org.eclipse.microprofile.openapi.annotations.media.Schema(implementation = ProblemDetailResponseDTO.class))
        })
    })
    Response updateImageInfo(@PathParam("id") String id,@Valid @NotNull ImageInfoDTO imageInfoDTO);



}
