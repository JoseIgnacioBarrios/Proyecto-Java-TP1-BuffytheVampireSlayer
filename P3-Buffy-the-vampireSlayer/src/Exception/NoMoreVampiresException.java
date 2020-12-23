package Exception;

public class NoMoreVampiresException extends CommandExecuteException {
	public NoMoreVampiresException() {
		super();
	}
	public NoMoreVampiresException (String message) {
		super(message);
	}
}
