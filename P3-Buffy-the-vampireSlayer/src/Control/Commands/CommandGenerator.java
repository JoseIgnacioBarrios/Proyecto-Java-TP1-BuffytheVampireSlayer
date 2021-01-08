package Control.Commands;

import Exception.CommandParseException;

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
			new AddVampireCommand(),
			new SerializeCommand(),
			new SaveCommand()
	};
	public static Command parseCommand(String[ ] commandWords) throws CommandParseException {
		
//		for (int i = 0; i < availableCommands.length; i++) {
//			if(availableCommands[i].parse(commandWords)!= null) {
//				return availableCommands[i];
//			}
//		}
		Command otro=null;
		for (Command e : availableCommands) {
			if(e.parse(commandWords)!= null) {
				otro=e;
				return e;
			}
		}
		if(otro==null) {throw new CommandParseException("[ERROR]: Unknown Command \n");}
		return otro;
		
	}
	public static String commandHelp() {
		String cad="Available commands:"+"\n";
		for (Command command : availableCommands) {
			cad=cad + command.helpText();//+ '\n';
		}
		return cad;
	}

}
