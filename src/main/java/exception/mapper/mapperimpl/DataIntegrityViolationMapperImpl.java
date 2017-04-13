package exception.mapper.mapperimpl;

import error.ValidationErrorInfo;
import exception.mapper.DataIntegrityViolationMapper;
import org.springframework.dao.DataIntegrityViolationException;

/**
 * Created by sangeet on 4/6/2017.
 */
public class DataIntegrityViolationMapperImpl implements DataIntegrityViolationMapper {
  @Override public ValidationErrorInfo mapException(DataIntegrityViolationException ex) {
    return null;
  }
}
