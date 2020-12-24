package Control.Commands;

import Exception.CommandExecuteException;
import Exception.CommandParseException;
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
		catch (CommandExecuteException e) {
			System.out.println(e.getMessage());
			throw new CommandExecuteException("[ERROR]: Failed to add slayer");
		}
		
			
		
		
		
//		switch (game.getErrorAdd()) {		
//		case 0:
//			//System.out.println("[DEBUG] Executing: "+this.arg+" "+x+" "+y+"0");
//			System.out.println("[ERROR]: Invalid position");
//			 return ok=false;
//		case 1:
//			//System.out.println("[DEBUG] Executing: "+this.arg+" "+x+" "+y+"1");
//			System.out.println("[ERROR]: Not enough coins");
//			 return ok=false;
//		default: return ok;
//		}

		//return ok;
	}

	@Override
	public Command parse(String[] commandWords)throws CommandParseException {
		// TODO Auto-generated method stub
		try {
			if(commandWords.length==3 ) {
				this.arg1=commandWords[1];
				this.arg2=commandWords[2];
				//if(commandWords.length<4) {
					if(matchCommandName(commandWords[0])&&validaNUmeros(this.arg1)&&validaNUmeros(this.arg2)) {
	//					if((Integer.parseInt(commandWords[1])>= 0) && (Integer.parseInt(commandWords[2])>=0) 
	//	//	    			(Integer.parseInt(commandWords[1])< game.getDimx()-1) && 
	//	//	    			(Integer.parseInt(commandWords[2])<=game.getDimy()-1)
	//		    			) {
							this.x=Integer.parseInt(commandWords[1]);
							this.y=Integer.parseInt(commandWords[2]);
							//this.arg=commandWords[0];
							return this;
						//}
					}
				//}
			}
			return null;
		}
		catch (CommandParseException ue) {
			throw new CommandParseException("[ERROR]:  Unvalid argument for Add slayer command, number expected: [a]dd <x> <y>"); 
		}
	}
	public boolean validaNUmeros(String arg) {
		return arg.matches("[0-9]");
	}

}
