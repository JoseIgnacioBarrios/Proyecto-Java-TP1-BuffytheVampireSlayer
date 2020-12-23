package Exception;

public class NotEnoughCoinsException extends CommandExecuteException{
	public NotEnoughCoinsException() {
		super();
	}
	public NotEnoughCoinsException (String message) {
		super(message);
	}
}
