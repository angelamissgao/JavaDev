package exception;

public class invalidinputException extends Exception {
	String message = "";
    public invalidinputException (String message){
        super(message);
        this.message = message;
    }
}
