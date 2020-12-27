package Logic.GameObjects;

import Logic.Game;

public abstract class GameObject implements IAttack{
	
	protected int x;
	protected int y;
	protected Game g;
	protected int vida;
	
	
	
	public GameObject(int x, int y,int vida,Game game) {
		this.g=game;
		this.x=x;
		this.y=y;
		this.vida=vida;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public abstract void attack();
	public abstract String toString();
	public abstract void mov();
	public abstract void vampireporaparecerSum();
	public abstract int getVampireporaparecer();
	public boolean isAlive() {
		if(this.vida>0)
		{
			return true;
		}
		else return false;
	}
	public abstract String serialize();
	
	
	


	
	
}
