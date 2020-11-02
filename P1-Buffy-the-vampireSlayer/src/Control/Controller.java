package Control;
import java.util.Scanner;
import Logic.Game;
import Logic.GameObjects.*;

public class Controller {

	
	public final String prompt = "Command > ";
	public static final String helpMsg = String.format(
			"Available commands:%n" +
			"[a]dd <x> <y>: add a slayer in position x, y%n" +
			"[h]elp: show this help%n" + 
			"[r]eset: reset game%n" + 
			"[e]xit: exit game%n"+ 
			"[n]one | []: update%n");
	
	public static final String unknownCommandMsg = String.format("Unknown command");
	public static final String invalidCommandMsg = String.format("Invalid command");
	public static final String invalidPositionMsg = String.format("Invalid position");

    private Game game;
    private Scanner scanner;
    
    public Controller(Game game, Scanner scanner) {
	    this.game = game;
	    this.scanner = scanner;
    }
    
//    public String printGame() {
//    	return this.game.toString();
//		
//    }
    public void  printGame() {
      	 System.out.println(game.toString());//
      }
    
    public void run() {
		// TODO fill your code
    	
    		
    		System.out.println("Vamos a pintar el tablero");
    		//System.out.println(this.printGame());
    		printGame();
			System.out.print(prompt);
			String scaner = scanner.nextLine();
			String auxscaner = scaner.toLowerCase();
			String scaner1 = auxscaner.trim();
			String[] arg = scaner1.split(" ");
	    	
	    	
			this.game.addSlayer(Integer.parseInt(arg[2]), Integer.parseInt(arg[3]));
			this.game.addVampire();
    	}


    
}
