package exception.mapper;

import exceptions.ConflictException;
import exceptions.NotFoundException;
import exceptions.ServiceUnavailableException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by sangeet on 4/4/2017.
 */
@ControllerAdvice()
@RestController()
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(value = NotFoundException.class)
  public String handleBaseException(final NotFoundException e){
    return "";
  }

  @ResponseStatus(HttpStatus.CONFLICT)
  @ExceptionHandler(value = ConflictException.class)
  public String handleException(final ConflictException e){
    return "";
  }

  @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
  @ExceptionHandler(value = ServiceUnavailableException.class)
  public String handleException(final ServiceUnavailableException e){
    return "";
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(value = Exception.class)
  public String handleException(final Exception e){
    return "";
  }
}
