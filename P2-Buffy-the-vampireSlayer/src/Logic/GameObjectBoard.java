package Logic;

//import java.util.ArrayList;
import Logic.GameObjects.GameObject;
import Logic.GameObjects.IAttack;
import Logic.Lists.GameObjectList;
//import Logic.Game;


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
	
	public String objetoImagenTablero(int x, int y) {
		
		return objectLista.objetoImagenTablero(x, y);
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
			return this.game.getVanporaparecer()- this.game.getcontVampire();
	}
	public void move() {
		this.objectLista.move();
	}
	public  IAttack getAttackableInPosition(int x, int y) {
		// TODO Auto-generated method stub
		return (IAttack)this.objectLista.obje(x,y);
	}
	public void attack() {
		// TODO Auto-generated method stub
		this.objectLista.attacklis();
	}
	public IAttack getPositiondelante(int x, int y) {
		// TODO Auto-generated method stub
		return (IAttack)this.objectLista.getPositiondelante(x,y);
	}
	public void remove() {
		this.objectLista.remove();		
	}
	/////////////////////
	public boolean llegometa() {
		return this.objectLista.llegometa();
	}
	public int vampireporaparecerSum() {
		return this.objectLista.getvampireporaparecerSum();
	}


	

}
	
