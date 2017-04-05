package exceptions;

/**
 * Created by sangeet on 4/5/2017.
 */
public class ServiceUnavailableException extends RuntimeException {
  private Throwable rootCause;
  public ServiceUnavailableException(){
    super();
  }
  public ServiceUnavailableException(final String mesg){
    super(mesg);
  }
  public ServiceUnavailableException(final Throwable ex){
    this.rootCause = ex;
  }
  public Throwable getRootCause() {
    return rootCause;
  }
}
