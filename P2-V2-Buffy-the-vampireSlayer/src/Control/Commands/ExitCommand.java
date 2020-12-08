package Control.Commands;

import Logic.Game;

public class ExitCommand extends Command{
	public ExitCommand() {
		super("Exit","E","[e]xit","exit game");
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		game.exit();
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		// TODO Auto-generated method stub
		if(commandWords.length==1 ) {
			if(matchCommandName(commandWords[0])) {
				return this;
			}
		}
		return null;
	}
			
		
	

}
