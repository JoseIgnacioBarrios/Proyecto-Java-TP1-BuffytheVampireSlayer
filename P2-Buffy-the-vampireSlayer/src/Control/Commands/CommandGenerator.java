package Control.Commands;

public class CommandGenerator {
	
	private static Command[] availableCommands= {
			new AddCommand(),
			new HelpCommand(),
			new ResetCommand(),
			new ExitCommand(),
			new UpdateCommand()
	};
	public static Command parseCommand(String[ ] commandWords) {
		
		for (int i = 0; i < availableCommands.length; i++) {
			if(availableCommands[i].parse(commandWords)!= null) {
				return availableCommands[i];
			}
		}
		return null;
	}
	public static String commandHelp() {
		for (int i = 0; i < availableCommands.length; i++) {
			return availableCommands[i].helpText();
		}
		return null;
	}

}
