package exception.mapper.mapperimpl;

import error.ValidationErrorInfo;
import exception.mapper.DataIntegrityViolationMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.dao.DataIntegrityViolationException;

/**
 * Created by sangeet on 4/6/2017.
 */
@ConditionalOnMissingBean({ DataIntegrityViolationMapper.class})
public class DataIntegrityViolationMapperImpl implements DataIntegrityViolationMapper {
  @Override public ValidationErrorInfo mapExceptoin(DataIntegrityViolationException ex) {
    return null;
  }
}
