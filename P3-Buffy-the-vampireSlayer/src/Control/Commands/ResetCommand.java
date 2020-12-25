package Control.Commands;

import Exception.CommandParseException;
import Logic.Game;

public class ResetCommand extends Command{
	public ResetCommand() {
		super("R","reset","[r]eset","reset game");
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		game.reset();
		return true;
	}

	@Override
	public Command parse(String[] commandWords)throws CommandParseException {
		// TODO Auto-generated method stub
		try {
				return parseNoParamsCommand(commandWords);
		}
		catch (CommandParseException e) {
			// TODO: handle exception
			//throw new CommandParseException("[ERROR]: Command "+this.name+" :"+incorrectNumberOfArgsMsg);
			System.out.println(e.getMessage());
		}
		return null;
		
	}

}
