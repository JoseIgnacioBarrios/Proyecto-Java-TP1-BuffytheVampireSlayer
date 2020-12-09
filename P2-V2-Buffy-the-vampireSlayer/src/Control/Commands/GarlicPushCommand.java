package Control.Commands;

import Logic.Game;

public class GarlicPushCommand extends Command{

	public GarlicPushCommand() {
		super("g", "garlic", "[g]arlic ", "pushes back vampires");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		game.garlicPush();
		//game.update();
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
