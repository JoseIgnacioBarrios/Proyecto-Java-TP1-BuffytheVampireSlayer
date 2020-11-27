package Logic.GameObjects;

import Logic.Game;

public class Vampire extends GameObject{
	private int HARM ;
	
	private static int vampiretablero;
	//private static int vampireporaparecer;
	public Vampire( int x, int y,Game game) {
		super(x,y,5,game);
		this.vampiretablero+=1;
		this.HARM=1;
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
		if (isAlive () ) {
			IAttack other = this.g.getAttackableInPosition(this.x-1, this.y);
			if (other != null )
			other.receiveVampireAttack(HARM);//.receiveVampireAttack(HARM);
		}
		
	}
	public boolean receiveSlayerAttack(int HARM) {
		this.vida-=HARM;
		return true;
		
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

	@Override
	public void mov() {
		// TODO Auto-generated method stub
		this.x=this.x-1;
	}





}
