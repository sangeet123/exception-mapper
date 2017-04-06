package error;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sangeet on 4/5/2017.
 */
public class ValidationErrorInfo {
  public ValidationErrorInfo() {}

  private final List<CustomFieldError> fieldErrors = new ArrayList<>();

  public List<CustomFieldError> getFieldErrors() {
    return fieldErrors;
  }

  public void addFieldError(final String path, final String message) {
    CustomFieldError error = new CustomFieldError(path, message);
    fieldErrors.add(error);
  }
}
