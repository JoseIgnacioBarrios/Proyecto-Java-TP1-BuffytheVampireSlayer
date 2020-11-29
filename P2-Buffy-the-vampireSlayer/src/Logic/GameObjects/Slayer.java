package Logic.GameObjects;

import Logic.Game;

public class Slayer extends GameObject{
	private int HARM;
	public Slayer( int x, int y, Game game) {
		super(x,y,3,game);
		this.HARM=1;
		
	}

	@Override
	public void attack() {
		if (isAlive () ) {
			for (int i = x+1; i < this.g.getDimX(); i++) {
				IAttack other = this.g.getAttackableInPosition(i, this.y);
				if (other != null && other.receiveSlayerAttack(HARM)) {
					
					break;
				}//.receiveVampireAttack(HARM);
			}
		}
		
	}
	public boolean receiveVampireAttack(int HARM) {
		this.vida-=HARM;
		return true;
		
	}

	@Override
	public String toString() {
		String cadena = "S"+"["+this.vida+"]";
		return cadena;
	}



	@Override
	public void mov() {
		// TODO Auto-generated method stub
	}

	@Override
	public void vampireporaparecerSum() {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getVampireporaparecer() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	



}
