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
		/*
		 * Command otro=null; for (Command e : availableCommands) {
		 * otro=e.parse(commandWords); if(otro!=null) break;{ otro=e; return e; } }
		 * if(otro==null) {throw new
		 * CommandParseException("[ERROR]: Unknown Command \n");} return otro;
		 */
		int i = 0;
		 Command command = null;
		 
		 for(Command c : availableCommands){
			 command = availableCommands[i].parse(commandWords);
			 if (command != null) break;
			 else i++;
		 }
		 
		 if(command == null) throw new CommandParseException("[ERROR]: Unknown command\n");
		 
		 return command;
		
	}
	public static String commandHelp() {
		String cad="Available commands:"+"\n";
		for (Command command : availableCommands) {
			cad=cad + command.helpText();//+ '\n';
		}
		return cad;
	}

}
