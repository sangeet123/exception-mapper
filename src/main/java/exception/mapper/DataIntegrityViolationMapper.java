package exception.mapper;

import error.ValidationErrorInfo;
import org.springframework.dao.DataIntegrityViolationException;

/**
 * Created by sangeet on 4/6/2017.
 */
public interface DataIntegrityViolationMapper {
  public ValidationErrorInfo mapException(final DataIntegrityViolationException ex);
}
