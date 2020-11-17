package Control.Commands;

import Logic.Game;

public class AddCommand extends Command {
	private int x;
	private int y;
	public AddCommand() {
		super("Add","a","[a]dd <x> <y>","add a slayer in position x, y");
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		game.addSlayer(x,y);
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		// TODO Auto-generated method stub
		if(commandWords.length==3 ) {
			if(matchCommandName(commandWords[0])) {
				if((Integer.parseInt(commandWords[1])>= 0) && (Integer.parseInt(commandWords[2])>=0) 
//	    			(Integer.parseInt(commandWords[1])< game.getDimx()-1) && 
//	    			(Integer.parseInt(commandWords[2])<=game.getDimy()-1)
	    			) {
					this.x=Integer.parseInt(commandWords[1]);
					this.y=Integer.parseInt(commandWords[2]);
					return this;
				}
			}
		}
		return null;
	}

}
