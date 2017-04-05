package exceptions;

/**
 * Created by sangeet on 4/5/2017.
 */
public class ServiceUnavailableException extends RuntimeException {
  public ServiceUnavailableException(){
    super();
  }
  public ServiceUnavailableException(final String mesg){
    super(mesg);
  }
}
