package org.tkit.onecx.welcome.bff.rs.mappers;

import gen.org.tkit.onecx.welcome.bff.rs.internal.model.ProblemDetailInvalidParamDTO;
import gen.org.tkit.onecx.welcome.bff.rs.internal.model.ProblemDetailResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-01T16:06:51+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Azul Systems, Inc.)"
)
@ApplicationScoped
public class ExceptionMapperImpl implements ExceptionMapper {

    @Override
    public ProblemDetailResponseDTO exception(String errorCode, String detail) {
        if ( errorCode == null && detail == null ) {
            return null;
        }

        ProblemDetailResponseDTO problemDetailResponseDTO = new ProblemDetailResponseDTO();

        problemDetailResponseDTO.setErrorCode( errorCode );
        problemDetailResponseDTO.setDetail( detail );

        return problemDetailResponseDTO;
    }

    @Override
    public List<ProblemDetailInvalidParamDTO> createErrorValidationResponse(Set<ConstraintViolation<?>> constraintViolation) {
        if ( constraintViolation == null ) {
            return null;
        }

        List<ProblemDetailInvalidParamDTO> list = new ArrayList<ProblemDetailInvalidParamDTO>( constraintViolation.size() );
        for ( ConstraintViolation<?> constraintViolation1 : constraintViolation ) {
            list.add( createError( constraintViolation1 ) );
        }

        return list;
    }

    @Override
    public ProblemDetailInvalidParamDTO createError(ConstraintViolation<?> constraintViolation) {
        if ( constraintViolation == null ) {
            return null;
        }

        ProblemDetailInvalidParamDTO problemDetailInvalidParamDTO = new ProblemDetailInvalidParamDTO();

        problemDetailInvalidParamDTO.setName( mapPath( constraintViolation.getPropertyPath() ) );
        problemDetailInvalidParamDTO.setMessage( constraintViolation.getMessage() );

        return problemDetailInvalidParamDTO;
    }
}
