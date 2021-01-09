package Control.Commands;

import Exception.CommandExecuteException;
import Exception.CommandParseException;
import Exception.NotEnoughCoinsException;
import Exception.UnvalidPsotionException;
import Logic.Game;



public class AddCommand extends Command {
	private int x;
	private int y;
	//private String arg;
	private String arg1;
	private String arg2;
	public AddCommand() {
		super("Add","a","[a]dd <x> <y>","add a slayer in position x, y");
	}

	@Override
	public boolean execute(Game game)throws CommandExecuteException {
		boolean ok=false;
		// TODO Auto-generated method stub
		try {
		if(game.rangomaxdelSlayer(this.x,this.y)) {
			if(game.celdaVacia(this.x,this.y)) {
				game.add(this.x,this.y);
				ok=true;
			}
			else throw new UnvalidPsotionException("[ERROR]: Invalid position");
		}
		else throw new UnvalidPsotionException("[ERROR]: Invalid position");
		
		return ok;
		}
		catch (UnvalidPsotionException e) {
			System.out.println(e.getMessage());
			throw new CommandExecuteException("[ERROR]: Failed to add slayer");
		}
		catch (NotEnoughCoinsException e) {
			System.out.println(e.getMessage());
			throw new CommandExecuteException("[ERROR]: Failed to add slayer");
		}

	}

	@Override
	public Command parse(String[] commandWords)throws CommandParseException {
		Command command = null;
		if(matchCommandName(commandWords[0])) {
			if(commandWords.length==3 ) {
				try {
				this.x=Integer.parseInt(commandWords[1]);
				this.y=Integer.parseInt(commandWords[2]);
				//command = this;
				} catch(NumberFormatException e) {
					throw new CommandParseException("[ERROR]: Command "+this.name+" :"+" incorrecto digitos");
				}
			
				return parseNoParamsCommandtres(commandWords);
				
			}
		}
			return command;

			
	
	}
}
