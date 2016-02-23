package exception;

public class InvalidInputException extends Exception {
	// Custom exception handler;
	private static final long serialVersionUID = 363520190986067729L;
	String message = "";

	public InvalidInputException(String message) {
		super(message);
		this.message = message;
	}
}
