package Control;
import java.util.Scanner;
import Logic.Game;
import Logic.GameObjects.*;

public class Controller {

	
	public final String prompt = "Command > ";
	
	
	public final String winner="Slayer Gana!!!";
	public final String lost="Vampire Gana!!!";
	public final String help="help";
	public final String reset="reset";
	public final String none="none";
	public final String exit="exit";
	////add
	public final String add="add";

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
    	while(!this.game.finalizo()){
    		
    		System.out.println("Vamos a pintar el tablero");
    		//System.out.println(this.printGame());
    		printGame();
			System.out.print(prompt);
			String scaner = scanner.nextLine();
			String auxscaner = scaner.toLowerCase();
			String scaner1 = auxscaner.trim();
			String[] arg = scaner1.split(" ");
	    	
	    	if (arg.length==1)
	    	{
	    		if(arg[0].equalsIgnoreCase(reset) || arg[0].equalsIgnoreCase(none) || arg[0].equalsIgnoreCase(help) || arg[0].equalsIgnoreCase(exit)){
					if(arg[0].equals(reset)){
						this.game.reset();
					}
					else if(arg[0].equalsIgnoreCase(none)){
						game.update();
					}
					else if(arg[0].equalsIgnoreCase(help)){
						System.out.println(helpMsg);
					}
					else{
						System.out.println(" GAME OVER ");
						//System.exit(0);
						this.game.exit();
					}
				}
	    		else System.out.println(unknownCommandMsg);
	    	}
	    	else if(arg.length==3)
	    	{
	    		if(arg[0].equalsIgnoreCase(add))
	    		{
	    			if( (Integer.parseInt(arg[1])>= 0) && (Integer.parseInt(arg[2])>=0) && 
	    				(Integer.parseInt(arg[1])<= game.getDimx()) && (Integer.parseInt(arg[2])<=game.getDimy())
    					)
	    			{
	    				if (game.coinsSuficiente()==true)///si tiene suficiente monedas
	    				{
	    					//System.out.println("estoy dentro de add");
		    				this.game.addSlayer(Integer.parseInt(arg[1]), Integer.parseInt(arg[2]));
	    				}
	    				else 
	    				{
	    					System.out.println(" coins insuficiente "+"\n");
	    					game.update();
	    				}
	    				
	    			}
	    		}
	    	}
			
//			this.game.addVampire();
    	}
    	if(this.game.finalizo()){
			System.out.println(game.toString());
			if(this.game.getWinner()) System.out.println(winner);
			else System.out.println(lost);
		}
	}


    
}
