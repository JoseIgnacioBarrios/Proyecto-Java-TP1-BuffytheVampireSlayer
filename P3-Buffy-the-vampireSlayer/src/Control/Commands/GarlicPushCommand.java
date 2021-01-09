package Control.Commands;

import Exception.CommandExecuteException;
import Exception.CommandParseException;
import Exception.NotEnoughCoinsException;

import Logic.Game;

public class GarlicPushCommand extends Command{

	public GarlicPushCommand() {
		super("g", "garlic", "[g]arlic ", "pushes back vampires");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		try {
		game.garlicPush();
		return true;
		}
		catch (NotEnoughCoinsException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			throw new CommandExecuteException("[ERROR]: Failed to Garlic");
		}
		
	}

	@Override
	public Command parse(String[] commandWords)throws CommandParseException {
				return parseNoParamsCommand(commandWords);

	}

}
