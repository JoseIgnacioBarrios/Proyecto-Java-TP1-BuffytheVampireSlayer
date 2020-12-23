package Control.Commands;

import Exception.CommandExecuteException;
import Exception.CommandParseException;
import Exception.UnvalidPsotionException;
import Logic.Game;

public class LightFlashCommand extends Command{

	public LightFlashCommand() {
		super("l", "light", "[l]ight", "kills all the vampires");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		// TODO Auto-generated method stub
		game.lightFlash();
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
