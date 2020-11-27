package Logic;

//import java.util.ArrayList;
import Logic.GameObjects.GameObject;
import Logic.Lists.GameObjectList;



public class GameObjectBoard {
	//private GameObject gameobjectsClass;
	private GameObjectList objectLista;
	private Game game;

	public GameObjectBoard(Game game) {
		this.objectLista = new GameObjectList(); 
		//this.gameobjectsClass= GameObject(this.game,game.getDimX(),game.getDimY())
		this.game=game;

		
		
	}
	public void add(GameObject Objeto) {
		
			this.objectLista.add(Objeto);
		
	}
	public void addVampire() {
		if(generatevampire() == true && this.game.getcontVampire() < this.game.getnumVampire()) {
			this.game.addVampire(this.game.getDimX()-1 , this.game.getRand().nextInt(this.game.getDimY()) );
		}
		
	}
	public boolean celdaVacia(int x, int y) {
		
		return objectLista.celdaVacia(x, y);
	}
	
	public String objetoEnPosicion(int x, int y) {
		
		return objectLista.objetoEnPosicion(x, y);
	}
	public String getWinnerMessage() {
		
		return objectLista.getWinnerMessage();
	}

	private boolean generatevampire() {
		boolean ok=false;
		if ((this.game.getRand().nextDouble() < this.game.getfrecuencia())) {
			ok=true;
		}
		return ok;
	}
	public int limitevampire() {
			return this.game.getVanporaparecer()-this.game.getcontVampire();
	}


	

}
	
