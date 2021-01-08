package Control.Commands;

import Exception.CommandExecuteException;
import Exception.CommandParseException;
import Exception.DraculalsAliveException;
import Exception.NoMoreVampiresException;
import Exception.UnvalidPsotionException;
import Logic.Game;

public class UpdateCommand extends Command{
	public UpdateCommand() {
		super("N","","[n]one | []","update");
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		// TODO Auto-generated method stub
		game.update();
		return true;
	}

	@Override
	public Command parse(String[] commandWords)throws CommandParseException {
		// TODO Auto-generated method stub
		//try {
				return parseNoParamsCommand(commandWords);
//		}
//		catch (CommandParseException e) {
//			// TODO: handle exception
//			//throw new CommandParseException("[ERROR]: Command "+this.name+" :"+incorrectNumberOfArgsMsg);
//			System.out.println(e.getMessage());
//		}
//		return null;
	}
	

}
