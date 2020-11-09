package Control;
import java.util.Scanner;
import Logic.Game;
//import Logic.GameObjects.*;

public class Controller {

	
	public final String prompt = "Command > ";
	
	
	public final String winner="Slayer Gana!!!";
	public final String lost="Vampire Gana!!!";
	public final String help="help";
	public final String reset="reset";
	public final String none="none";
	public final String exit="exit";
	private boolean ok=true;
	////add
	public final String add="Add";

	public static final String helpMsg = String.format(
			"Available commands:%n" +
			"[a]dd <x> <y>: add a slayer in position x, y%n" +
			"[h]elp: show this help%n" + 
			"[r]eset: reset game%n" + 
			"[e]xit: exit game%n"+ 
			"[n]one | []: update%n");
	
	public static final String unknownCommandMsg = String.format("[ERROR]: Unknown command");
	public static final String invalidCommandMsg = String.format("Invalid command");
	public static final String invalidPositionMsg = String.format("Invalid position");
	public static final String nobodywins	=	String.format("[Game over] Nobody wins...");

    private Game game;
    private Scanner scanner;
    private int conError;
    public Controller(Game game, Scanner scanner) {
	    this.game = game;
	    this.scanner = scanner;
	    conError=0;
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
    		
    		//System.out.println("Vamos a pintar el tablero");
    		//System.out.println(this.printGame());
    		if(ok) {
    			printGame();
    			//game.update();
    		}
    		//game.update();
			System.out.println(prompt);
			String scaner = scanner.nextLine();
			String auxscaner = scaner.toLowerCase();
			String scaner1 = auxscaner.trim();
			String[] arg = scaner1.split(" ");
			//game.update();
	    	if (arg.length==1||arg[0]=="")
	    	{
	    		if(arg[0].equalsIgnoreCase(reset) || arg[0].equalsIgnoreCase(none) || arg[0].equalsIgnoreCase(help) || arg[0].equalsIgnoreCase(exit)||
	    				arg[0].equalsIgnoreCase("R") || arg[0].equalsIgnoreCase("N") || arg[0].equalsIgnoreCase("H") || arg[0].equalsIgnoreCase("E")||
	    				arg[0].equalsIgnoreCase("")){
					if(arg[0].equalsIgnoreCase(reset)|| arg[0].equalsIgnoreCase("r")){
						System.out.println("[DEBUG] Executing: "+arg[0]);
						this.game.reset();
						ok=true;
					}
					else if(arg[0].equalsIgnoreCase(none)|| arg[0].equalsIgnoreCase("N")||arg[0].equalsIgnoreCase("")){
						System.out.println("[DEBUG] Executing: "+arg[0]);
						game.update();
						ok=true;
					}
					else if(arg[0].equalsIgnoreCase(help) || arg[0].equalsIgnoreCase("h")){
						System.out.println("[DEBUG] Executing: "+arg[0]);
						System.out.println(helpMsg);
						//game.update();
						ok=false;
					}
					else if(arg[0].equalsIgnoreCase(exit) || arg[0].equalsIgnoreCase("e")){
						System.out.println("[DEBUG] Executing: "+arg[0]);
						System.out.println(nobodywins);
						this.game.exit();
					}
//					else if(arg[0].equalsIgnoreCase(reset) || arg[0].equalsIgnoreCase("r")){
//						System.out.println("[DEBUG] Executing: "+arg[0]);
//						this.game.reset();
//						ok=true;
//						System.out.println(" GAME OVER ");
//						//System.exit(0);
//						this.game.exit();
					//}
				}
	    		else {
	    			System.out.println("[DEBUG] Executing: "+arg[0]);
	    			System.out.println(unknownCommandMsg);
	    			ok=false;
	    			//game.update();
	    		}
	    	}
	    	else if(arg.length==3)
	    	{
	    		if(arg[0].equalsIgnoreCase(add)||arg[0].equalsIgnoreCase("a"))
	    		{
	    			if( (Integer.parseInt(arg[1])>= 0) && (Integer.parseInt(arg[2])>=0) && 
	    				(Integer.parseInt(arg[1])< game.getDimx()-1) && (Integer.parseInt(arg[2])<=game.getDimy()-1)
    					)
	    			{
////	    				if (game.coinsSuficiente()==true)///si tiene suficiente monedas
////	    				{
//	    					//System.out.println("estoy dentro de add");
//		    				if(this.game.addSlayer(Integer.parseInt(arg[1]), Integer.parseInt(arg[2]))){
//		    					
//		    					System.out.println("[DEBUG] Executing: "+arg[0]+" "+arg[1]+" "+arg[2]);
//		    					game.usarCoins();
//		    					ok=true;
//		    				}
//		    				else {
//		    					System.out.println("[DEBUG] Executing: "+arg[0]+" "+arg[1]+" "+arg[2]);
//		    					System.out.println("[ERROR]: Invalid position");
//		    				}
//	    				}
//	    				else 
//	    				{
//	    					System.out.println(" coins insuficiente "+"\n");
//	    					game.update();
//	    				}
	    				this.conError= this.game.addSlayer(Integer.parseInt(arg[1]), Integer.parseInt(arg[2]));
	    				//System.out.println(this.conError);
	    				switch (this.conError) {
						case 0:
							System.out.println("[DEBUG] Executing: "+arg[0]+" "+arg[1]+" "+arg[2]);
							game.update();
	    					ok=true;
							break;
							
						case 1:
							System.out.println("[DEBUG] Executing: "+arg[0]+" "+arg[1]+" "+arg[2]);
	    					System.out.println("[ERROR]: Invalid position");
	    					ok=false;
							break;
						case 2:
							System.out.println("[DEBUG] Executing: "+arg[0]+" "+arg[1]+" "+arg[2]);
							System.out.println("[ERROR]: Not enough coins");
							ok=false;
							break;
						}
	    				
	    			}
	    			else {
						System.out.println("[DEBUG] Executing: "+arg[0]+" "+arg[1]+" "+arg[2]);
    					System.out.println("[ERROR]: Invalid position");
    					ok=false;
	    			}
	    		}
	    	}
			

    	}
    	if(this.game.finalizo()){
			System.out.println(game.toString());
			if(this.game.getWinner()) System.out.println(lost);
			else System.out.println(winner);
		}
	}


    
}
