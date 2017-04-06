package error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.Locale;

/**
 * Created by sangeet on 4/5/2017.
 */
@Service()
public class ValidationErrorProcessor {

  private MessageSource messageSource;

  public MessageSource getMessageSource() {
    return messageSource;
  }

  @Autowired() public void setMessageSource(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  public ValidationErrorInfo processFieldErrors(final List<FieldError> fieldErrors) {
    final ValidationErrorInfo validationErrorInfo = new ValidationErrorInfo();

    for (FieldError fieldError : fieldErrors) {
      String localizedErrorMessage = resolveLocalizedErrorMessage(fieldError);
      validationErrorInfo.addFieldError(fieldError.getField(), localizedErrorMessage);
    }
    return validationErrorInfo;
  }

  public String resolveLocalizedErrorMessage(final FieldError fieldError) {
    final Locale currentLocale = LocaleContextHolder.getLocale();
    final String[] fieldErrorCodes = fieldError.getCodes();
    //strip all other until first dot
    final String code = fieldErrorCodes[fieldErrorCodes.length - 1];
    String localizedErrorMessage = messageSource
        .getMessage(code, null, currentLocale);

    // if message is not found, return the field error code instead
    if (localizedErrorMessage.equals(fieldError.getDefaultMessage())) {
      localizedErrorMessage = code;
    }
    return localizedErrorMessage;
  }
}
