package Logic.GameObjects;

import Logic.Game;

public abstract class GameObject implements IAttack{
	
	protected int x;
	protected int y;
	protected Game g;
	
	
	
	public GameObject(int x, int y, Game game) {
		this.g=game;
		this.x=x;
		this.y=y;
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
	
	public abstract String toString();
	public abstract String getWinnerMessage();
	
	
	
	


	
	
}
