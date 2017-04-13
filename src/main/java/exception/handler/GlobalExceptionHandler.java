package exception.handler;

import error.ValidationErrorInfo;
import error.ValidationErrorProcessor;
import exception.mapper.DataIntegrityViolationMapper;
import exceptions.NotFoundException;
import exceptions.ServiceUnavailableException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sangeet on 4/4/2017.
 */
@ControllerAdvice() @RestController() public class GlobalExceptionHandler {
  private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @Autowired() private ValidationErrorProcessor errorProcessor;

  @Autowired() private DataIntegrityViolationMapper dataIntegrityViolationMapper;

  @ResponseStatus(HttpStatus.NOT_FOUND) @ExceptionHandler(value = NotFoundException.class) public void handleBaseException(
      final NotFoundException e) {
    LOGGER.error("Request resource not found{}", e);
  }

  @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE) @ExceptionHandler(value = ServiceUnavailableException.class) public void handleException(
      final ServiceUnavailableException e) {
    LOGGER.error("{}", e);
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) @ExceptionHandler(value = Exception.class) public void handleException(
      final Exception e) {
    LOGGER.error("{}", e);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class) @ResponseStatus(value = HttpStatus.BAD_REQUEST) @ResponseBody() public ValidationErrorInfo handleException(
      final MethodArgumentNotValidException e) {
    LOGGER.error("{}", e);
    final BindingResult result = e.getBindingResult();
    return errorProcessor.processFieldErrors(result.getFieldErrors());
  }

  @ExceptionHandler(DataIntegrityViolationException.class) @ResponseStatus(value = HttpStatus.CONFLICT) @ResponseBody() public ValidationErrorInfo handleException(
      final DataIntegrityViolationException e) {
    LOGGER.error("{}", e);
    ValidationErrorInfo validationErrorInfo = dataIntegrityViolationMapper.mapException(e);
    return validationErrorInfo;
  }
}
