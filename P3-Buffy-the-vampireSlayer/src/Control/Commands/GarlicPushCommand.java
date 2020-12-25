package Control.Commands;

import Exception.CommandExecuteException;
import Exception.CommandParseException;
import Exception.UnvalidPsotionException;
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
		//game.update();
		return true;
		}
		catch (UnvalidPsotionException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			throw new CommandExecuteException("[ERROR]: Failed to Garlic");
		}
		
	}

	@Override
	public Command parse(String[] commandWords)throws CommandParseException {
		try {
				return parseNoParamsCommand(commandWords);
		}
		catch (CommandParseException e) {
			// TODO: handle exception
			//throw new CommandParseException("[ERROR]: Command "+this.name+" :"+incorrectNumberOfArgsMsg);
			System.out.println(e.getMessage());
		}
		return null;
	}

}
