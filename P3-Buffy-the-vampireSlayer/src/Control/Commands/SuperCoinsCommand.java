package Control.Commands;

import Exception.CommandParseException;
import Logic.Game;

public class SuperCoinsCommand extends Command{

	public SuperCoinsCommand() {
		super("c", "coins", "[c]oins", "add 1000 coins");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		game.superCoins();
		return true;
	}

	@Override
	public Command parse(String[] commandWords)throws CommandParseException {
		if(commandWords.length==1) {
			if(matchCommandName(commandWords[0])) {
				return this;
			}
		}
		return null;
	}

}
