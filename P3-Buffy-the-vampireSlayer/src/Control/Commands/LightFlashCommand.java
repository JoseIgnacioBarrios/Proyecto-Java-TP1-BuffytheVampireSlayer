package Control.Commands;

import Exception.CommandExecuteException;
import Exception.CommandParseException;
import Exception.NotEnoughCoinsException;
import Logic.Game;

public class LightFlashCommand extends Command{

	public LightFlashCommand() {
		super("l", "light", "[l]ight", "kills all the vampires");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		// TODO Auto-generated method stub
		try {
		game.lightFlash();
		return true;
		}
		catch (NotEnoughCoinsException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			throw new CommandExecuteException("[ERROR]: Failed to Light Flash");
		}
	}

	@Override
	public Command parse(String[] commandWords)throws CommandParseException {
				return parseNoParamsCommand(commandWords);

	}

}
