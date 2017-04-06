package error;

import java.io.Serializable;

/**
 * Created by sangeet on 4/5/2017.
 */
public class CustomFieldError implements Serializable{
  private String field;
  private String message;

  public CustomFieldError(){

  }

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
