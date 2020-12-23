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
		game.garlicPush();
		//game.update();
		return true;
	}

	@Override
	public Command parse(String[] commandWords)throws CommandParseException {
		if(commandWords.length==1) {
			if(matchCommandName(commandWords[0])) {
				return this;
				
			}
		}
		return null;
	}

}
