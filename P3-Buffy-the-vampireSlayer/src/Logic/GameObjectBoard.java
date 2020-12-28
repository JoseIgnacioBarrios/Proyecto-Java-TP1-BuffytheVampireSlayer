package Logic;

import Exception.DraculalsAliveException;
import Exception.NoMoreVampiresException;
import Exception.UnvalidPsotionException;
//import java.util.ArrayList;
import Logic.GameObjects.GameObject;
import Logic.GameObjects.IAttack;
import Logic.GameObjects.Vampire;
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
	public void addVampire2() {//throws UnvalidPsotionException, NoMoreVampiresException {
		if(generatevampire() == true && podravampire()) {//Vampire.getVampiretablero()<this.game.getnumVampire()){//this.game.getcontVampire() < this.game.getnumVampire()) {
			this.game.addVampire2(this.game.getDimX()-1 , this.game.getRand().nextInt(this.game.getDimY()) );
		}
		
	}
	public void addDracula2() {//throws DraculalsAliveException, UnvalidPsotionException {
		if(generatevampire() == true && podravampire()) {//Vampire.getVampiretablero() < this.game.getnumVampire()) {
			this.game.addDracula2(this.game.getDimX()-1 , this.game.getRand().nextInt(this.game.getDimY()) );
		}
	}
	public void addExpVamvire2() {//throws UnvalidPsotionException, NoMoreVampiresException {
		if(generatevampire() == true && podravampire()) {//Vampire.getVampiretablero() < this.game.getnumVampire()) {
			this.game.addExplosiveVampire2(this.game.getDimX()-1 , this.game.getRand().nextInt(this.game.getDimY()) );
		}
		
	}
	
	public boolean podravampire() {
		boolean ok=false;
				if(Vampire.getVampiretablero()<this.game.getnumVampire()) {
					ok=true;
				}
				return ok;
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
//	public int limitevampire() {
//			return this.game.getVanporaparecer()- this.game.getcontVampire();
//	}
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
	public void clear() {
		this.objectLista.clear();
		
	}
	public boolean limiteBlood(int x, int y) {
		if(this.game.getDimX()-1>x&&x>=0&&y>=0&&this.game.getDimY()>y) {
			return true;
		}
		return false;
	}
	public boolean limitedracula(int x, int y) {
		if(this.game.getDimX()-1>=x&&x>=0&&y>=0&&this.game.getDimY()>=y) {
			return true;
		}
		return false;
	}
	public void garlicPush() {
		this.objectLista.garlicPussh();
		
	}
	public void lightFlash() {
		this.objectLista.lightFlash();		
	}
	public String serialize() {
		 return this.objectLista.serialize();
		// TODO Auto-generated method stub
		
	}
	
	
	


	

}
	
