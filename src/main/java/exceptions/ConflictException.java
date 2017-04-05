package exceptions;

/**
 * Created by sangeet on 4/5/2017.
 */
public class ConflictException extends RuntimeException {
  private Throwable rootCause;
  public ConflictException(){
    super();
  }
  public ConflictException(final String mesg){
    super(mesg);
  }
  public ConflictException(final Throwable ex){
    this.rootCause = ex;
  }
  public Throwable getRootCause() {
    return rootCause;
  }
}
