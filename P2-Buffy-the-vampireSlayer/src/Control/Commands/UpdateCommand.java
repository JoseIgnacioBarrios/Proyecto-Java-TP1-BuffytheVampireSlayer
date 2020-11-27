package Control.Commands;

import Logic.Game;

public class UpdateCommand extends Command{
	public UpdateCommand() {
		super("N","","[N]one | []","update%n");
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		game.update();
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		// TODO Auto-generated method stub
		if(commandWords.length==1) {
			if(matchCommandName(commandWords[0])) {
				return this;
			}
		}
		return null;
	}
	

}
