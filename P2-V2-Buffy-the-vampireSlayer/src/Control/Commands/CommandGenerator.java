package Control.Commands;

public class CommandGenerator {
	
	private static Command[] availableCommands= {
			new AddCommand(),
			new AddVampireCommand(),
			new AddBloodBankCommand(),
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
		String cad="";
		for (Command command : availableCommands) {
			cad=cad + command.helpText();//+ '\n';
		}
		return cad;
	}

}
