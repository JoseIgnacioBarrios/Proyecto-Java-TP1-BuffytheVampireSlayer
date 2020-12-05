package Logic.GameObjects;

import Logic.Game;

public class BloodBank extends GameObject{
	private int z;
	public BloodBank(int x, int y, int z, Game game) {
		super(x, y,1, game);
		this.z=z;
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mov() {
		if(isAlive()) {
			this.g.generaCoinsZ(this.z); 
		}
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
