package Control.Commands;

import Logic.Game;

public class ResetCommand extends Command{
	public ResetCommand() {
		super("","","","");
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		game.reset();
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
