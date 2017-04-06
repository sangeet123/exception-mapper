package exception.mapper;

import error.ValidationErrorInfo;
import error.ValidationErrorProcessor;
import exceptions.ConflictException;
import exceptions.NotFoundException;
import exceptions.ServiceUnavailableException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sangeet on 4/4/2017.
 */
@ControllerAdvice()
@RestController()
public class GlobalExceptionHandler{
  private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @Autowired()
  private ValidationErrorProcessor errorProcessor;

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(value = NotFoundException.class)
  public void handleBaseException(final NotFoundException e){
    LOGGER.error("Request resource not found{}",e.getRootCause());
  }

  @ResponseStatus(HttpStatus.CONFLICT)
  @ExceptionHandler(value = ConflictException.class)
  public String handleException(final ConflictException e){
    LOGGER.error("Request resource exist{}",e.getRootCause());
    return e.getRootCause().getMessage();
  }

  @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
  @ExceptionHandler(value = ServiceUnavailableException.class)
  public void handleException(final ServiceUnavailableException e){
    LOGGER.error("{}",e.getRootCause());
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(value = Exception.class)
  public void handleException(final Exception e){
    LOGGER.error("{}",e);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(value=HttpStatus.BAD_REQUEST)
  @ResponseBody()
  public ValidationErrorInfo handleMethodArgumentNotValid(final MethodArgumentNotValidException e) {
    LOGGER.error("{}",e);
    final BindingResult result = e.getBindingResult();
    return errorProcessor.processFieldErrors(result.getFieldErrors());
  }

}
