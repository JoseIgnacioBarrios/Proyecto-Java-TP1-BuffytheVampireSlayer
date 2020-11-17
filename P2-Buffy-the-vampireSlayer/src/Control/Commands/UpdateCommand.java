package Control.Commands;

import Logic.Game;

public class UpdateCommand extends Command{
	public UpdateCommand() {
		super("","","","");
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		game.update();
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
