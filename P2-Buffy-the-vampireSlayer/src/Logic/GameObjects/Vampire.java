package Logic.GameObjects;

import Logic.Game;

public class Vampire extends GameObject{
	
	private int vida;
	private static int vampiretablero;
	//private static int vampireporaparecer;
	public Vampire( int x, int y,Game game) {
		super(x,y,game);
		this.vida=5;
		this.vampiretablero+=1;
		//this.vampireporaparecer=this.vampiretablero-1;
	}

	public static int getVampiretablero() {
		return vampiretablero;
	}	

//	public static int getVampireporaparecer() {
//		return vampireporaparecer;
//	}


	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		String cadena = "V"+"["+this.vida+"]";
		return cadena;
	}

	@Override
	public String getWinnerMessage() {
		// TODO Auto-generated method stub
		return null;
	}





}
