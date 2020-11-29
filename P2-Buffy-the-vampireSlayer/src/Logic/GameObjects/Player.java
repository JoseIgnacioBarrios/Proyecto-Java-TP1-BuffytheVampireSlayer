package Logic.GameObjects;

import java.util.Random;

public class Player {
	private int coins;
	private final int coinsreset = 50;
	private final int sumacoins= 10;
	private Random ran;
	public Player(Random ran) {//No podemos tener referencia a game
		this.coins = coinsreset;
		this.ran=ran;
	}
	public void usarCoins() 
	{
		this.coins=this.coins-coinsreset;
	}
	
	public void reset() {
		this.coins=this.coinsreset;
	}
	
	
	public int getPrecio() {
		return coinsreset;
	}
	public int getCoins() {
		return coins;
	}
	public void setcoins() {
		this.coins=this.coins+this.sumacoins;
	}

}
