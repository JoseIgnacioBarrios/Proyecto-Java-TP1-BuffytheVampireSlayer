package Control.Commands;

import Logic.Game;

public class AddVampireCommand extends Command{
	private String type;
	private int x;
	private int y;
	private String arg2;
	private String arg3;
	public AddVampireCommand() {
		super("V", "v", "[v]ampire","[<type>] <x> <y>. Type = {\"\"|\"D\"|\"E\"}: add a vampire in position x, y");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		boolean ok=false;
		if(this.type.equalsIgnoreCase("v")) {
			 game.addVampire(x, y);
			 ok=true;
		}
		else if(this.type.equalsIgnoreCase("D")) {
			game.addDracula(x, y);
			ok=true;
		}
		else if(this.type.equalsIgnoreCase("E")) {
			game.addExplosiveVampire(x, y);
			ok=true;
		}
		else System.out.println("[ERROR]: Invalid type");
		switch (game.getErrorAddVampire()) {		
		case 0:
//			//System.out.println("[DEBUG] Executing: "+this.arg+" "+x+" "+y+"0");
			System.out.println("[ERROR]: Invalid position");
			 return ok=false;
		case 1:
			System.out.println("[ERROR]: Not enough coins");
			return ok=false;
		case 2:
			//System.out.println("[DEBUG] Executing: "+this.arg+" "+x+" "+y+"1");
			System.out.println("[ERROR]: Dracula is already alive");
			 return ok=false;
		default: return ok;
		}
	}

	@Override
	public Command parse(String[] commandWords) {
		
		if(commandWords.length==4) {
			this.type=commandWords[1];
			if(matchCommandName(commandWords[0])) {//||this.type.equalsIgnoreCase("D")||this.type.equalsIgnoreCase("E")) {
				if(commandWords[1].equalsIgnoreCase("D")||commandWords[1].equalsIgnoreCase("E")||commandWords[1].equalsIgnoreCase("")) {
					this.arg2=commandWords[2];
					this.arg3=commandWords[3];
					if(validaNUmeros(this.arg2)&&validaNUmeros(this.arg3))
					this.type=commandWords[1];
					this.x=Integer.parseInt(commandWords[2]);
					this.y=Integer.parseInt(commandWords[3]);
					return this;
				}
			}
		}
		else if (commandWords.length==3) {
			if(matchCommandName(commandWords[0])){
				this.arg2=commandWords[1];
				this.arg3=commandWords[2];
				if(validaNUmeros(this.arg2)&&validaNUmeros(this.arg3)) {
					this.type=commandWords[0];
					this.x=Integer.parseInt(commandWords[1]);
					this.y=Integer.parseInt(commandWords[2]);
					return this;
				}
			}
		}
		return null;
	}
	
	public boolean validaNUmeros(String arg) {
		return arg.matches("[0-9]");
	}

}
