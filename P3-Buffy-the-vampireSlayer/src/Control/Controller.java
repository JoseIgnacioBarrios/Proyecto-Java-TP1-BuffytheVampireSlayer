package Control;

import java.util.Scanner;

import Control.Commands.Command;
import Control.Commands.CommandGenerator;
import Exception.GameException;
import Logic.Game;

public class Controller {
	
	public final String prompt = "Command > ";
	public static final String unknownCommandMsg ="Unknown command";

    private Game game;
    private Scanner scanner;
    
    public Controller(Game game, Scanner scanner) {
	    this.game = game;
	    this.scanner = scanner;
    }
    
    public void  printGame() {
   	 System.out.println(game);
   }
    
    public void run() {
	    	boolean refreshDisplay = true;

	    while (!game.isFinished()){
	    		
        		 if (refreshDisplay) printGame();
        		 refreshDisplay = false;
        		 
			  System.out.println(prompt);	
			  String s = scanner.nextLine();
			  String[] parameters = s.toLowerCase().trim().split(" ");
			  System.out.println("[DEBUG] Executing: " + s);
		      
		      try {
		    	  Command command = CommandGenerator.parseCommand(parameters);
		    	  refreshDisplay=command.execute(game);
		    	  }
		      catch(GameException ex) {
		    	  System.out.format(ex.getMessage() + "%n%n");
		      	}
		      catch(NullPointerException ex) {
		    	  System.out.println("[ERROR]: "+unknownCommandMsg);
		      }
	    }
	    
        	if (refreshDisplay) printGame();
    		System.out.println ("[Game over] " + game.getWinnerMessage());

    }

}

