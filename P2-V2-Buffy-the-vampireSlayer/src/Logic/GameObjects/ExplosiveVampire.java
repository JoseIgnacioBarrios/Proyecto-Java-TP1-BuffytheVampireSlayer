package Logic.GameObjects;

import Logic.Game;

public class ExplosiveVampire extends Vampire{
	private int HARM;

	public ExplosiveVampire(int x, int y, Game game) {
		super(x, y, game);
		HARM=1;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {	
		String	 cadena = "EV"+" "+"["+this.vida+"]";
		return cadena;
	}
	
	@Override
	public void attack() {
		if (isAlive () ) {
			IAttack other = this.g.getAttackableInPosition(this.x, this.y);
			if (other != null ) {
				other.receiveSlayerAttack(HARM);
			}
		}
	}


}
