package Control.Commands;

public class CommandGenerator {
	
	private static Command[] availableCommands= {
			new AddCommand(),
			new HelpCommand(),
			new ResetCommand(),
			new ExitCommand(),
			new UpdateCommand(),
			new GarlicPushCommand(),
			new LightFlashCommand(),
			new AddBloodBankCommand(),
			new SuperCoinsCommand(),
			new AddVampireCommand()
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
		String cad="Available commands:"+"\n";
		for (Command command : availableCommands) {
			cad=cad + command.helpText();//+ '\n';
		}
		return cad;
	}

}
