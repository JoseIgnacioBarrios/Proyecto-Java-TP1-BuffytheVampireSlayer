package Logic.GameObjects;

import Logic.Game;

public class Slayer extends GameObject{
	
	private int vida=3;
	public Slayer( int x, int y, Game game) {
		super(x,y,game);
		
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		//INPOSICION
		
	}

	@Override
	public String toString() {
		String cadena = "S"+"["+this.vida+"]";
		return cadena;
	}

	@Override
	public String getWinnerMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	



}
