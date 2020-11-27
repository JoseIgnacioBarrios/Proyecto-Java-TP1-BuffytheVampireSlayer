package Logic;
import java.util.Random;

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
		return false;
	}
	public void add(int x,int y) {
		if (this.player.getCoins()>=this.player.getPrecio()){
		this.gameObjectboard.add(new Slayer(x,y,this));
		this.player.usarCoins();
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
		
	}

	public void reset() {
				
	}

	public void update() {
		generaCoins();
		this.gameObjectboard.addVampire();
	}

	public String getWinnerMessage() {
		String cad=this.gameObjectboard.getWinnerMessage();
		return cad;
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
		String cad=this.gameObjectboard.objetoEnPosicion(x, y);
		return cad;
		
	}

	@Override
	public String getInfo() {
		String estado;
		estado = "Number of cycles: "  +this.ciclo+"\n"  + 
		"Coins: "  +this.player.getCoins()+"\n"  + 
		"Remaining vampires: "+ limitevampire()+"\n" +
		"Vampires on the board: "+ Vampire.getVampiretablero()+"\n";
		return estado;
	}



}
