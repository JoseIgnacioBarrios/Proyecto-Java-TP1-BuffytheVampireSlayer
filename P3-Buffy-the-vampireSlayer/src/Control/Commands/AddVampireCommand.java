package Control.Commands;

import Exception.CommandExecuteException;
import Exception.CommandParseException;
import Logic.Game;

public class AddVampireCommand extends Command{
	private String type;
	private int x;
	private int y;
	public AddVampireCommand() {
		super("V", "v", "[v]ampire","[<type>] <x> <y>. Type = {\"\"|\"D\"|\"E\"}: add a vampire in position x, y");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game)throws CommandExecuteException {
		boolean ok=false;
		try {
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
			return ok;
		
		}
		catch (CommandExecuteException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			throw new CommandExecuteException ("[ERROR]: Failed to add Vampire" );
		}

	}

	@Override
	public Command parse(String[] commandWords)throws CommandParseException {
		
		if(matchCommandName(commandWords[0])) {
			if(commandWords.length==4) {
				this.type=commandWords[1];
				if(commandWords[1].equalsIgnoreCase("D")||commandWords[1].equalsIgnoreCase("E")) {
					
					this.type=commandWords[1];
					try {
					this.x=Integer.parseInt(commandWords[2]);
					this.y=Integer.parseInt(commandWords[3]);
					}
					catch (NumberFormatException e) {
						throw new CommandParseException("[ERROR]: Command "+this.name+" :"+" incorrecto digitos");
					}
					return this;
				}
				else throw new CommandParseException("[ERROR]: Unvalid type: [v]ampire [<type>] <x> <y>. Type = {\"\"|\"D\"|\"E\"}");
			}
		}
		if (matchCommandName(commandWords[0])) {
			if(commandWords.length==3){
				
					this.type=commandWords[0];
					try {
					this.x=Integer.parseInt(commandWords[1]);
					this.y=Integer.parseInt(commandWords[2]);
					}catch (NumberFormatException e) {
						throw new CommandParseException("[ERROR]: Command "+this.name+" :"+" incorrecto digitos");
					}
					return this;
				
			}
			else throw new CommandParseException("[Error]: [<type>] <x> <y>. Type = {\" \"|\"D\"|\"E\"}: add a vampire in position x, y");
		}
		return null;
	}
		
	
	
	public boolean validaNUmeros(String arg) {
		return arg.matches("[0-9]");
	}

}
