package Control.Commands;

import Logic.Game;

public class AddBloodBankCommand extends Command{
	private int x;
	private int y;
	private int z;
	private String arg1;
	private String arg2;
	private String arg3;
	public AddBloodBankCommand() {
		super("B", "b", "[b]ank <x><y><z>", "add a blood bank with cost z in position x, y.");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		
		if(game.addBloodBank(x,y,z))
		{return true;}
		else return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		if(commandWords.length==4) {
			if(matchCommandName(commandWords[0])) {
				this.arg1=commandWords[1];
				this.arg2=commandWords[2];
				this.arg3=commandWords[3];
				if(validaNUmeros(this.arg1)&&validaNUmeros(this.arg2)&&validaNUmerosdosDigitos(this.arg3)) {
					this.x=Integer.parseInt(commandWords[1]);
					this.y=Integer.parseInt(commandWords[2]);
					this.z=Integer.parseInt(commandWords[3]);
					return this;
					
				}
			}
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
