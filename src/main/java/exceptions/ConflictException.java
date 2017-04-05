package exceptions;

/**
 * Created by sangeet on 4/5/2017.
 */
public class ConflictException extends RuntimeException {
  public ConflictException(){
    super();
  }
  public ConflictException(final String mesg){
    super(mesg);
  }
}
