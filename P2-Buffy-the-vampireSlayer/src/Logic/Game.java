package Logic;
import java.util.Random;

import Logic.GameObjects.IAttack;
//import Logic.GameObjects.GameObject;
import Logic.GameObjects.Player;
import Logic.GameObjects.Slayer;
import Logic.GameObjects.Vampire;
import View.GamePrinter;
import View.IPrintable;

public class Game implements IPrintable {
	private Random rand;
	private GameObjectBoard gameObjectboard;
	private GamePrinter str;
	private Level level;
	private int ciclo;
	private Player player;
	private int cont;
	private int vanporaparecer;
	private int errorAdd;
	private boolean quien;
	
	public Game(Long seed, Level level) {
		this.rand=new Random(seed);
		this.level=level;
		gameObjectboard= new GameObjectBoard(this);
		str = new GamePrinter(this, this.getDimX(),this.getDimY());//??Printeable?
		this.ciclo=0;
		this.player=new Player(rand);
		this.cont=0;
		this.vanporaparecer=this.level.getNumberOfVampires();
		this.errorAdd=2;
		
	}
	
	public boolean isFinished() {
		boolean ok=false;
		if(this.gameObjectboard.llegometa()) {
			ok= true;
			this.quien=true;
		}
		else if (Vampire.getVampiretablero()-Vampire.getvampireEliminado()==0&&this.level.getNumberOfVampires()-Vampire.getVampiretablero()==0) {
			ok= true;
			this.quien=false;
		}
		return ok;
	}
	public void add(int x,int y) {
		if (this.player.getCoins()>=this.player.getPrecio()){
		this.gameObjectboard.add(new Slayer(x,y,this));
		this.player.usarCoins();
		update();
		this.errorAdd=2;
		}
		else this.errorAdd=1;
	}

	public void addVampire(int x,int y) {
		if(celdaVacia(x, y)) {
				this.gameObjectboard.add(new Vampire(x,y,this));
				this.cont++;
		}
		
	}
	public void exit() {
		System.exit(0);
	}

	public void reset() {
		this.gameObjectboard.clear();
		Vampire.setVampireEliminado(0);
		Vampire.setVampiretablero(0);
		this.ciclo=0;
		this.player.reset();
	}

	public void update() {
		generaCoins();
		this.gameObjectboard.move();
		this.gameObjectboard.attack();
		this.gameObjectboard.addVampire();
		this.gameObjectboard.remove();
		if(!isFinished()){this.ciclo++;}
	}

	public String getWinnerMessage() {
		if(this.quien) {
			String cad="Vampires win!";
			return cad;
		}
		else {String cad="Slayer win!";
			return cad;}
	}
	public void initGame() {
		
	}
	//////////////////////////////////////////////
	public int getDimX() {
		return this.level.getDimX();
	}
	public int getDimY() {
		return this.level.getDimY();
	}
//	public int getCoins() {
//		return this.player.getCoins();
//	}
//	public int getPrecio() {
//		return this.player.getPrecio();
//	}
	public IAttack getAttackableInPosition(int x, int y) {
		
		return this.gameObjectboard.getAttackableInPosition(x,y);
	}
	public IAttack getPositiondelante(int x, int y) {
		
		return this.gameObjectboard.getPositiondelante(x,y);
	}
	public Random getRand() {
		return rand;
	}
	public int getcontVampire() {
		return this.cont;
	}
	public int limitevampire() {
		return gameObjectboard.limitevampire();
	}
	public double  getfrecuencia() {
		return this.level.getVampireFrequency();
	}
	public int getnumVampire() {
		return this.level.getNumberOfVampires();
	}
	public boolean rangomaxdelSlayer(int x, int y) {
		return x>=0 && x<this.level.getDimX() && y>=0 && y<this.level.getDimY();
	}
	public boolean celdaVacia(int x, int y) {
		return gameObjectboard.celdaVacia(x,y);
	}
	public int getErrorAdd() {
		return errorAdd;
	}

	public void setErrorAdd(int errorAdd) {
		this.errorAdd = errorAdd;
	}
	public void generaCoins() {
		if(this.rand.nextFloat()>0.5) {
			this.player.setcoins();
		}
	}
	public int getVanporaparecer() {
		return vanporaparecer;
	}

	public String toString() {
		return str.toString();
	}
	
	@Override
	public String getPositionToString(int x, int y) {
		String cad=this.gameObjectboard.objetoImagenTablero(x, y);
		return cad;
		
	}

	@Override
	public String getInfo() {
		String estado;
		estado = "Number of cycles: "  +this.ciclo+"\n"  + 
		"Coins: "  +this.player.getCoins()+"\n"  + 
		"Remaining vampires: "+(this.level.getNumberOfVampires()-Vampire.getVampiretablero())+"\n" +
		"Vampires on the board: "+ (Vampire.getVampiretablero()-Vampire.getvampireEliminado())+"\n";
		return estado;
	}

	public boolean getceldaVacia(int x, int y) {
		
		return this.gameObjectboard.celdaVacia(x, y);
	}

	



}
