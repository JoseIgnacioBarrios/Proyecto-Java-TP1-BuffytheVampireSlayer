package Control.Commands;

import Exception.CommandExecuteException;
import Exception.CommandParseException;
import Logic.Game;

public class UpdateCommand extends Command{
	public UpdateCommand() {
		super("N","","[n]one | []","update");
	}

	@Override
	public boolean execute(Game game)throws CommandExecuteException {
		// TODO Auto-generated method stub
		game.update();
		return true;
	}

	@Override
	public Command parse(String[] commandWords)throws CommandParseException {
		// TODO Auto-generated method stub
		if(commandWords.length==1) {
			if(matchCommandName(commandWords[0])) {
				return this;
			}
		}
		return null;
	}
	

}
