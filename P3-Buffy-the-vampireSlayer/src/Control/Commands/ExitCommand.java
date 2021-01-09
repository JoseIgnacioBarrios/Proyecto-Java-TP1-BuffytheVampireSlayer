package Control.Commands;

import Exception.CommandParseException;
import Logic.Game;

public class ExitCommand extends Command{
	public ExitCommand() {
		super("Exit","E","[e]xit","exit game");
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		System.out.println("[GAME OVER] Nobody wins...");
		game.exit();
		return false;
	}

	@Override
	public Command parse(String[] commandWords)throws CommandParseException {
				return parseNoParamsCommand(commandWords);
		
	}
			
		
	

}
