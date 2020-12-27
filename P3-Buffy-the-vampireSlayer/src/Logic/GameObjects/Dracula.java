package Logic.GameObjects;

import Logic.Game;

public class Dracula extends Vampire{
	private static boolean vivodracula=false;
	//private int HARM;
	public Dracula(int x, int y, Game game) {
		super(x, y, game);
		//HARM =3;
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public void attack() {
		if (isAlive () ) {
			IAttack other = this.g.getAttackableInPosition(this.x-1, this.y);
			if (other != null ) {
			other.receiveDraculaAttack();
			}
		}
	}
	@Override
	public String toString() {	
		String	 cadena = "D"+" "+"["+this.vida+"]";
		return cadena;
	}

	public boolean receiveSlayerAttack(int HARM) {
		if(isAlive()) {
		this.vida-=HARM;
		}
		if(this.vida==0) {
			setVivodraculaCambio();
		}
		return true;
		
	}
	
	public static boolean getVivodracula() {
		return vivodracula;
	}
	public static void setVivodraculaCambio() {
		if(vivodracula)vivodracula=false;
		else vivodracula=true;
	}
	public boolean receiveLightFlash() {
		return false;
	}
	public String serialize() {
		String	 cadena = "D;"+this.x+";"+this.y+";"+this.vida+";"+getmovint();
		return cadena;
	}


}
