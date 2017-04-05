package exceptions;

/**
 * Created by sangeet on 4/4/2017.
 */
public class NotFoundException extends RuntimeException {
  private Throwable rootCause;
  public NotFoundException(final String mesg){
    super(mesg);
  }
  public NotFoundException(){
  }
  public NotFoundException(final Throwable ex){
    this.rootCause = ex;
  }
  public Throwable getRootCause() {
    return rootCause;
  }
}
