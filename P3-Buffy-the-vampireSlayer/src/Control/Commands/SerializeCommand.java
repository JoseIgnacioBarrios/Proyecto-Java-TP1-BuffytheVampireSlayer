package Control.Commands;

import Exception.CommandExecuteException;
import Exception.CommandParseException;
import Logic.Game;

public class SerializeCommand extends Command {

	public SerializeCommand() {
		super("Z", "z", "[z]erialize", "serializa tablero");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		// TODO Auto-generated method stub
		try {
		System.out.println(game.serialize());
		}
		catch (CommandExecuteException e) {
			// TODO: handle exception
			throw new CommandExecuteException("[ERROR]: Failed to add bank");
		}
		return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		try {
			return parseNoParamsCommand(commandWords);
			
		}
		catch (CommandParseException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
