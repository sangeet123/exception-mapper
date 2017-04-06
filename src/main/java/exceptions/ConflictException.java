package exceptions;

import error.ValidationErrorInfo;

/**
 * Created by sangeet on 4/5/2017.
 */
public class ConflictException extends RuntimeException {
  private ValidationErrorInfo validationErrorInfo;

  public ConflictException(final ValidationErrorInfo validationErrorInfo) {
    this.validationErrorInfo = validationErrorInfo;
  }

  public ConflictException() {
    super();
  }

  public ConflictException(final String mesg) {
    super(mesg);
  }

  public ValidationErrorInfo getValidationErrorInfo() {
    return validationErrorInfo;
  }

  public void setValidationErrorInfo(ValidationErrorInfo validationErrorInfo) {
    this.validationErrorInfo = validationErrorInfo;
  }
}
