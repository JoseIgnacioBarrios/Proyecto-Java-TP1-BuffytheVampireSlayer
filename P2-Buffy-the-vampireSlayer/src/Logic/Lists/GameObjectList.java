package Logic.Lists;

import java.util.ArrayList;

//import Logic.GameObjectBoard;
import Logic.GameObjects.GameObject;

public class GameObjectList {
	private ArrayList<GameObject> gameobjects;

	public GameObjectList () {
		gameobjects=new ArrayList<GameObject>();
		
	}
	
	
	public boolean celdaVacia(int x, int y) {
		boolean ok = true;
		for (GameObject e : gameobjects) {
			if(e.getX()==x && e.getY()==y) {
				return false;
			}
		}
		return ok;
	}
	
	public String objetoEnPosicion(int x, int y) {
		
		if(gameobjects!=null) {
			for (GameObject e : gameobjects) {
				if(e.getX()==x && e.getY()==y) {
					return e.toString();
				}
			}
		
		}
		return " ";
	}
	public GameObject obje(int x,int y) {
		
		if(gameobjects!=null) {
			for (GameObject e : gameobjects) {
					if(e.getX()==x&&e.getY()==y && e.isAlive()) {
						return e;
					}
				}
			}
		return null;
	}
	public void attacklis() {
		if(gameobjects!=null) {
			for (GameObject e : gameobjects) {
				e.attack();
			}
		}
	}
	public void add(GameObject object) {
		this.gameobjects.add(object);
	}
	
	public String getWinnerMessage() {
		return null;
	}


	public void move() {
		
	}
	
	
	

}
