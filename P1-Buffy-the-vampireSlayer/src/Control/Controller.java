package Control;
import java.util.Scanner;
import Logic.Game;

public class Controller {

	
	public final String prompt = "Command > ";
	
	
	public final String winner="[Game over] Player wins";
	public final String lost="[Game over] Vampires win!";
	public final String help="help";
	public final String reset="reset";
	public final String none="none";
	public final String exit="exit";
	private boolean ok=true;
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
    
    public void  printGame() {
      	 System.out.println(game.toString());//
      }
    
    public void run() {
    	while(!this.game.finalizo()){
    		if(ok) {
    			printGame();
    		}
			System.out.println(prompt);
			String scaner = scanner.nextLine();
			//String auxscaner = scaner.toLowerCase();
			String scaner1 = scaner.trim();
			String[] arg = scaner1.split(" ");
	    	if (arg.length==1)
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
						this.game.update();
						//this.game.generarcoins();
						ok=true;
					}
					else if(arg[0].equalsIgnoreCase(help) || arg[0].equalsIgnoreCase("h")){
						System.out.println("[DEBUG] Executing: "+arg[0]);
						System.out.println(helpMsg);
						ok=false;
					}
					else if(arg[0].equalsIgnoreCase(exit) || arg[0].equalsIgnoreCase("e")){
						System.out.println("[DEBUG] Executing: "+arg[0]);
						System.out.println(nobodywins);
						this.game.exit();
					}
				}
	    		else {
	    			System.out.println("[DEBUG] Executing: "+arg[0]);
	    			System.out.println(unknownCommandMsg);
	    			ok=false;
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
	    				this.conError= this.game.addSlayer(Integer.parseInt(arg[1]), Integer.parseInt(arg[2]));
	    				switch (this.conError) {
						case 0:
							System.out.println("[DEBUG] Executing: "+arg[0]+" "+arg[1]+" "+arg[2]);
							this.game.update();
							//this.game.generarcoins();
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
