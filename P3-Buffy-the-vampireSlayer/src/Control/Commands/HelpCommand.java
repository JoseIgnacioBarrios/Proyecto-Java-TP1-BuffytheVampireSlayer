package Control.Commands;

import Exception.CommandParseException;
import Logic.Game;

public class HelpCommand extends Command{

	public HelpCommand() {
		// TODO Auto-generated constructor stub
		super("Help", "H", "[h]elp", "show this help");
	}

	@Override
	public boolean execute(Game game) {
		System.out.println(CommandGenerator.commandHelp());
		return false;
	}

	@Override
	public Command parse(String[] commandWords)throws CommandParseException {
				return parseNoParamsCommand(commandWords);

	}

}
