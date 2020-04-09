
public class ErrorException extends Throwable{
    private String exception;

    public ErrorException(String e) {
        super();
        this.exception = e;
    }
    
    public String getMessage(){
        return this.exception;
    }
}
