package error;

/**
 * Created by sangeet on 4/5/2017.
 */
public class CustomFieldError{
  private final String field;
  private final String message;

  public CustomFieldError(final String field, final String message) {
    this.field = field;
    this.message = message;
  }

  public String getField() {
    return field;
  }

  public String getMessage() {
    return message;
  }
}
