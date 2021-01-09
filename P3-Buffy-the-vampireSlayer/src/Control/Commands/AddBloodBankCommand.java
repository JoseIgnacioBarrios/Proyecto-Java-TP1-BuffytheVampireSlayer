package Control.Commands;

import Exception.CommandExecuteException;
import Exception.CommandParseException;
import Exception.NotEnoughCoinsException;
import Exception.UnvalidPsotionException;
import Logic.Game;

public class AddBloodBankCommand extends Command{
	private int x;
	private int y;
	private int z;
	public AddBloodBankCommand() {
		super("B", "b", "[b]ank <x> <y> <z>", "add a blood bank with cost z in position x, y.");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game)throws CommandExecuteException {
		
		try {
		if(game.addBloodBank(x,y,z))
		{return true;}
		else return false;
		}
		catch ( UnvalidPsotionException ue) {
			System.out.println(ue.getMessage());
			throw new CommandExecuteException("[ERROR]: Failed to add bank");
		}
		catch ( NotEnoughCoinsException ue) {
			System.out.println(ue.getMessage());
			throw new CommandExecuteException("[ERROR]: Failed to add bank");
		}

		
	}

	@Override
	public Command parse(String[] commandWords)throws CommandParseException {
		//try {
			if(matchCommandName(commandWords[0])) {
				if(commandWords.length==4) {
					try {
						this.x=Integer.parseInt(commandWords[1]);
						this.y=Integer.parseInt(commandWords[2]);
						this.z=Integer.parseInt(commandWords[3]);
					}catch (NumberFormatException e) {
						throw new CommandParseException("[ERROR]: Command "+this.name+" :"+" incorrecto digitos");
					}
						return this;
						
				}else throw new CommandParseException("[ERROR]: Command "+this.name+" :"+incorrectNumberOfArgsMsg);
			}
	
		return null;
	}

}
