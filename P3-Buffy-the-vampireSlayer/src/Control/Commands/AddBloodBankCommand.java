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
	private String arg1;
	private String arg2;
	private String arg3;
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
		try {
		//if(commandWords.length==4) {
			//if(matchCommandName(commandWords[0])) {
			Command otros= parseNoParamsCommandcuatro(commandWords);
			if(otros != null) {
				this.arg1=commandWords[1];
				this.arg2=commandWords[2];
				this.arg3=commandWords[3];
				if(validaNUmeros(this.arg1)&&validaNUmeros(this.arg2)&&validaNUmerosdosDigitos(this.arg3)) {
					this.x=Integer.parseInt(commandWords[1]);
					this.y=Integer.parseInt(commandWords[2]);
					this.z=Integer.parseInt(commandWords[3]);
					return otros;
					
				}
				else throw new NumberFormatException("[ERROR]: Introdusca digito X,Y,Z son Numeros");
			}
			return otros;

		}
		catch (CommandParseException e) {
			//throw new CommandParseException("[ERROR]: Command "+this.name+" :"+incorrectNumberOfArgsMsg); 
			System.out.println(e.getMessage());
		}
		catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}

	public boolean validaNUmeros(String arg) {
		return arg.matches("[0-9]");
	}
	public boolean validaNUmerosdosDigitos(String arg) {
		return arg.matches("[0-9]*");
	}
}
