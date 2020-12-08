package Control.Commands;

import Logic.Game;

public class LightFlashCommand extends Command{

	public LightFlashCommand() {
		super("l", "light", "[l]ight", "kills all the vampires");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		game.lightFlash();
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		if(commandWords.length==1) {
			if(matchCommandName(commandWords[0])) {
				return this;
			}
		}
		return null;
	}

}
