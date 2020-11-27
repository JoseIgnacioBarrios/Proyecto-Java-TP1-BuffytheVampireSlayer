package Control.Commands;

import Logic.Game;

public class HelpCommand extends Command{

	public HelpCommand() {
		// TODO Auto-generated constructor stub
		super("Help", "H", "[H]elp", "show this help");
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		System.out.println(CommandGenerator.commandHelp());
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		// TODO Auto-generated method stub
		if(commandWords.length==1 ) {
			if(matchCommandName(commandWords[0])) {
				return this;
			}
		}
		return null;
	}

}
