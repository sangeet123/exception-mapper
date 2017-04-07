package error;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sangeet on 4/5/2017.
 */
public class ValidationErrorInfo {
  private String context;

  public ValidationErrorInfo() {
    this.context = Config.appContext;
  }

  public String getContext(){
    return this.context;
  }

  private final List<CustomFieldError> fieldErrors = new ArrayList<>();

  public List<CustomFieldError> getFieldErrors() {
    return fieldErrors;
  }

  public void addFieldError(final String path, final String message) {
    CustomFieldError error = new CustomFieldError(path, message);
    fieldErrors.add(error);
  }
}
