package Logic.Lists;

import java.util.ArrayList;

//import Logic.GameObjectBoard;
import Logic.GameObjects.GameObject;
//import Logic.GameObjects.IAttack;

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
	
	public String objetoImagenTablero(int x, int y) {
		
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
		if(gameobjects!=null) {
			for (GameObject e : gameobjects) {
				e.mov();
			}
		}
		
	}
	public GameObject getPositiondelante(int x, int y) {
		if(gameobjects!= null) {
			for (GameObject e : gameobjects) {
					if(e.getX() == x && e.getY()==y && e.isAlive()) {
						return null;
					}
					else return e;
				}
			}
		return null;
	}
	public GameObject objetoS() {
		if(gameobjects!=null) {
			for (GameObject e : gameobjects) {
						return e;
				}
			}
		return null;
	}
	public void remove() {
		if(gameobjects!=null) {
//			for (GameObject e : gameobjects) {
//				if(e.isAlive()==false) {
//					gameobjects.remove(e);
//				}
//			}
			ArrayList<GameObject> shouldBeRemoved = new ArrayList<GameObject>();
			for (GameObject e : gameobjects) {
			    if (e.isAlive()) {
			       
			    }
			    else  {
			    	e.vampireporaparecerSum();
			    	shouldBeRemoved.add(e);}
			    	
			}
			gameobjects.removeAll(shouldBeRemoved);
		}
	}
	//////////////
	public boolean llegometa() {
		boolean ok=false;
		if(gameobjects!=null) {
			for (GameObject e : gameobjects) {
				if(e.getX()<0) {
					return ok= true;
				}
			}
			
		}
		return ok;
	}


	public int getvampireporaparecerSum() {
		if(gameobjects!=null) {
			for (GameObject e : gameobjects) {
				return e.getVampireporaparecer();
			}
		}
		return 0;
	}


	public void clear() {
		this.gameobjects.clear();
		
	}


	public void garlicPussh() {
		if(gameobjects!=null) {
			for (GameObject e : gameobjects) {
				e.receiveGarlicPush();
			}
		}
		
		
	}


	public void lightFlash() {
		if(gameobjects!=null) {
			for(GameObject e: gameobjects) {
				e.receiveLightFlash();
			}
		}
		
	}


	public String serialize() {
		if(gameobjects!=null) {
			for (GameObject e : gameobjects) {
					return e.serialize();
			}
		
		}
		return " ";
	}
	
	
	

}
