package Control.Commands;

import java.io.IOException;

import Exception.CommandExecuteException;
import Exception.CommandParseException;
import Logic.Game;

public abstract class Command {

	  protected final String name;
	  protected final String shortcut;
	  private final String details; 
	  private final String help;

	  protected static final String incorrectNumberOfArgsMsg = "Incorrect number of arguments";
	  protected static final String incorrectArgsMsg = "Incorrect arguments format";
	  
	  public Command(String name,  String shortcut, String details, String help){    
	    this.name = name;
	    this.shortcut = shortcut;
	    this.details = details;
	    this.help = help;
	  }
	  
	  public abstract boolean execute(Game game)throws CommandExecuteException;
	  
	  public abstract Command parse(String[] commandWords)throws CommandParseException;
	  
	  protected boolean matchCommandName(String name)throws CommandParseException {
		    return this.shortcut.equalsIgnoreCase(name) || 
		        this.name.equalsIgnoreCase(name);
	  }
	  
	  protected Command parseNoParamsCommand(String[] words)throws CommandParseException {
	
			if (matchCommandName(words[0])) {
				if (words.length != 1) throw new CommandParseException("[ERROR] : Command "+name+" :"+incorrectArgsMsg );

				return this;
			}
			
			return null;
	  }
	  protected Command parseNoParamsCommandtres(String[] words)throws CommandParseException {
			
			if (matchCommandName(words[0])) {
				if (words.length != 3) throw new CommandParseException("[ERROR] : Command "+name+" :"+incorrectArgsMsg );

				return this;
			}
			
			return null;
	  }
	  protected Command parseNoParamsCommandcuatro(String[] words)throws CommandParseException {
			
			if (matchCommandName(words[0])) {
				if (words.length != 4) throw new CommandParseException("[ERROR] : Command "+name+" :"+incorrectArgsMsg );

				return this;
			}
			
			return null;
	  }
	  protected Command parseNoParamsCommanddos(String[] words)throws CommandParseException {
			
			if (matchCommandName(words[0])) {
				if (words.length != 2) throw new CommandParseException("[ERROR : Command ]"+name+" :"+incorrectArgsMsg );

				return this;
			}
			
			return null;
	  }
	  
	  public String helpText(){
	    return  details + ": " + help + "\n";
	  }
	  public String messagepos(int x, int y) {
			 return "position (" + x + ", " + y + ") ";
	  }
	  
	  protected boolean validaLetra(String cad) {
		return cad.matches("[a-zA-Z]*");
	  }
}
