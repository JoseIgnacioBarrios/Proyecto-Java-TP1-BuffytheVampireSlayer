package Logic.GameObjects;

import Logic.Game;

public class ExplosiveVampire extends Vampire{
	//private int HARM;

	public ExplosiveVampire(int x, int y, Game game) {
		super(x, y, game);
		//HARM=1;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {	
		String	 cadena = "EV"+" "+"["+this.vida+"]";
		return cadena;
	}
	public boolean receiveSlayerAttack(int HARM) {
		if(isAlive()) {
			this.vida=this.vida-HARM;
			}
		if (isAlive()==false ) {
			for (int i = this.y-1; i <= this.y+1; i++) {
				for (int j = this.x-1; j <= this.x+1; j++) {
					IAttack other = this.g.getAttackableInPosition(j,i);
					if (other != null ) {
						other.receiveSlayerAttack(1);
					}
				}
				
			}
			
		}
		return true;
	}
	public String serialize() {
		String	 cadena = "EV;"+this.x+";"+this.y+";"+this.vida+";"+getmovint();
		return cadena;
	}



}
