package Logic.GameObjects;
//import Logic.Game;

public class Player {
	private int coins;
	private final int coinsreset;
	private final int usacoins;
	private final int sumacoins;
	//private Game game;
	public Player() {//No podemos tener referencia a game
		this.coins = 50;
		this.coinsreset = 50;
		this.usacoins = 50;
		this.sumacoins=10;
		//this.game=game;
		
	}
	public void usarCoins() 
	{
		
		this.coins=this.coins-this.usacoins;
	}
	
	public void reset() {
		this.coins=this.coinsreset;
	}
	
	public int getUsacoins() {
		return usacoins;
	}
	
	public int getCoins() {
		return coins;
	}
	public void setcoins() {
		this.coins=this.coins+this.sumacoins;
	}
	
	
	

}
