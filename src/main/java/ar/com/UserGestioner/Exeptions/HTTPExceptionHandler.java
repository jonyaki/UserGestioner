package ar.com.UserGestioner.Exeptions;

import java.util.Arrays;
import java.util.Date;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ar.com.UserGestioner.model.DTO.ErrorsHTTP;
import ar.com.UserGestioner.model.DTO.TypeErrorHTTP;

@RestControllerAdvice
public class HTTPExceptionHandler {

	@ExceptionHandler(Exception.class)
    public   ResponseEntity<ErrorsHTTP> handleHTTPException(Exception ex) {
        
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        int codigo = HttpStatus.INTERNAL_SERVER_ERROR.value();

        if (ex instanceof BadRequestException || ex instanceof MethodArgumentNotValidException ) {
            status = HttpStatus.BAD_REQUEST;
            codigo = HttpStatus.BAD_REQUEST.value();
        } else if (ex instanceof NotFoundException) {
            status = HttpStatus.NOT_FOUND;
            codigo = HttpStatus.NOT_FOUND.value();
        } else if (ex instanceof UnauthorizedException) {
            status = HttpStatus.UNAUTHORIZED;
            codigo = HttpStatus.UNAUTHORIZED.value();
        } else if (ex instanceof ForbiddenException) {
            status = HttpStatus.FORBIDDEN;
            codigo = HttpStatus.FORBIDDEN.value();
        }
        ErrorsHTTP error= new ErrorsHTTP(Arrays.asList(
                new TypeErrorHTTP(new Date().getTime(),codigo, ex.getMessage())
                )	);
        
        return new ResponseEntity<>(error, status);
    }
	
	 @ExceptionHandler(value = ConstraintViolationException.class)
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public ResponseEntity<ErrorsHTTP> handleValidationException(ConstraintViolationException ex) {
	        return handleHTTPException( ex);
	    }
}
