package Logic;
import java.util.Random;

import Exception.CommandExecuteException;
import Exception.CommandParseException;
import Exception.DraculalsAliveException;
import Exception.NoMoreVampiresException;
import Exception.NotEnoughCoinsException;
import Exception.UnvalidPsotionException;
import Logic.GameObjects.BloodBank;
import Logic.GameObjects.Dracula;
import Logic.GameObjects.ExplosiveVampire;
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
	//private int cont;
	private int vanporaparecer;
	private int errorAdd;
	private int errorAddVampire;
	private boolean quien;
	private int o=0;
	
	public Game(Long seed, Level level) {
		this.rand=new Random(seed);
		this.level=level;
		gameObjectboard= new GameObjectBoard(this);
		str = new GamePrinter(this, this.getDimX(),this.getDimY());//??Printeable?
		this.ciclo=0;
		this.player=new Player(rand);
		//this.cont=0;
		this.vanporaparecer=this.level.getNumberOfVampires();
		this.errorAdd=2;
		this.errorAddVampire=0;
		
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
	public void add(int x,int y) throws NotEnoughCoinsException, UnvalidPsotionException{//, NoMoreVampiresException, DraculalsAliveException{
		if (this.player.getCoins()>=this.player.getPrecio()){
			if(this.gameObjectboard.limiteBlood(x, y)) {
				this.gameObjectboard.add(new Slayer(x,y,this));
				this.player.usarCoins();
				update();
				this.errorAdd=2;
			}
			else throw new UnvalidPsotionException("[ERROR] : "+"("+x+","+y+"): "+"Unvalid position");
		}
		else {throw  new NotEnoughCoinsException("[ERROR]: Defender cost is 50: Not enough coins");}
	}

	public void addVampire(int x,int y)throws UnvalidPsotionException ,NoMoreVampiresException{
		if(celdaVacia(x, y)) {
			if(this.gameObjectboard.limitedracula(x, y)) {
				if(this.gameObjectboard.podravampire()) {
					this.gameObjectboard.add(new Vampire(x,y,this));
					this.errorAddVampire=4;
					//this.cont++;
				}
				else {
					throw new NoMoreVampiresException("[ERROR]: No more remaining vampires left");
					} 
			}
			else {
				throw new UnvalidPsotionException("[ERROR] : "+"("+x+","+y+"): "+"Unvalid position");
				}
		}
		else {
			throw new UnvalidPsotionException("[ERROR] : "+"("+x+","+y+"): "+"Unvalid position");
			}
	}
	public void addDracula(int x, int y)throws DraculalsAliveException,UnvalidPsotionException {
		if(celdaVacia(x, y)) {
			if (this.gameObjectboard.limitedracula(x, y)) {
				if(!Dracula.getVivodracula()) {
					if(this.gameObjectboard.podravampire()) {
						this.gameObjectboard.add(new Dracula(x,y,this));
						Dracula.setVivodraculaCambio();
						this.errorAddVampire=4;
					}
					else this.errorAddVampire=0;
					
				}
				else throw new DraculalsAliveException("[ERROR] : Dracula is already on board"); 
			}
			else throw new UnvalidPsotionException("[ERROR] : "+"("+x+","+y+"): "+"Unvalid position");
		}
		else throw new UnvalidPsotionException("[ERROR] : "+"("+x+","+y+"): "+"Unvalid position");
	}
	public void addExplosiveVampire(int x, int y)throws UnvalidPsotionException,NoMoreVampiresException {
		if(this.gameObjectboard.podravampire()) {	
			if(celdaVacia(x, y)) {
				if(this.gameObjectboard.limitedracula(x, y)) {
					this.gameObjectboard.add(new ExplosiveVampire(x,y,this));
					//Dracula.setVivodraculaCambio();
					this.errorAddVampire=4;
				}
				else throw new UnvalidPsotionException("[ERROR] : "+"("+x+","+y+"): "+"Unvalid position");
			}
			else throw new UnvalidPsotionException("[ERROR] : "+"("+x+","+y+"): "+"Unvalid position");
		}
		else  throw new NoMoreVampiresException("[ERROR]: No more remaining vampires left");
		
		
	}
	public boolean addBloodBank(int x, int y, int z)throws UnvalidPsotionException, NotEnoughCoinsException {
		boolean ok=false;
		if(celdaVacia(x, y)) {
			if(this.player.getCoins()>=z) {
				if(gameObjectboard.limiteBlood(x,y)) {
				this.player.usarCoinsBlood(z);
				this.gameObjectboard.add(new BloodBank(x,y,z,this));
				update();
				this.errorAddVampire=4;
				ok= true;
				}
				else {throw new UnvalidPsotionException("[ERROR]: position "+"("+x+","+y+"): "+"Unvalid position");}
			}
			else { //this.errorAddVampire=1;
				throw new NotEnoughCoinsException ("[ERROR]: Defender cost is "+z+": Not enough coins");
			}
		}
		else {//this.errorAddVampire=0;
			throw new UnvalidPsotionException("[ERROR]: position "+"("+x+","+y+"): "+"Unvalid position");
			
			}
		return ok;
		
		
		
	}
	public int getErrorAddVampire() {
		return errorAddVampire;
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

	public void update() {//throws UnvalidPsotionException, NoMoreVampiresException, DraculalsAliveException   {
		generaCoins();
		this.gameObjectboard.move();
		this.gameObjectboard.attack();
		this.gameObjectboard.addVampire2();
		this.gameObjectboard.addDracula2();
		this.gameObjectboard.addExpVamvire2();
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
	public IAttack getAttackableInPosition(int x, int y) {
		
		return this.gameObjectboard.getAttackableInPosition(x,y);
	}
	public IAttack getPositiondelante(int x, int y) {
		
		return this.gameObjectboard.getPositiondelante(x,y);
	}
	public Random getRand() {
		return rand;
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
	public void generaCoinsZ(int z) {
		this.player.sumarcoinsBlook(z);
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
		"Vampires on the board: "+ tablero()+"\n"+
		draculavive();
		return estado;
	}
	public int tablero() {
		return o=Vampire.getVampiretablero()-Vampire.getvampireEliminado();
	}
	public boolean getceldaVacia(int x, int y) {
		
		return this.gameObjectboard.celdaVacia(x, y);
	}

	public void garlicPush() throws NotEnoughCoinsException{
		if(this.player.getCoins()>=10) {
			this.gameObjectboard.garlicPush();
			this.player.usargarlicpush();
			update();
			
		}
		
		else throw new NotEnoughCoinsException("[ERROR]: Defender cost : Not enough coins");
	}

	public void lightFlash() throws NotEnoughCoinsException{
		
		if(this.player.getCoins()>=this.player.getPrecio()) {
			this.gameObjectboard.lightFlash();
			update();
		}
		else throw new NotEnoughCoinsException("[ERROR]: Light Flash cost is 50 : Not enough coins");
		
	}

	public void superCoins() {
		this.player.superCoins();
		
	}
	public String draculavive() {
		String cad="";
		if(Dracula.getVivodracula()) {
			return cad="Dracula is alive";
		}
		return cad;
	}
	//////////////////////////////////////////
	public void addVampire2(int x,int y) {
		if(celdaVacia(x, y)) {
			if(this.gameObjectboard.limitedracula(x, y)) {
				if(this.gameObjectboard.podravampire()) {
					this.gameObjectboard.add(new Vampire(x,y,this));
					//this.errorAddVampire=4;
					//this.cont++;
				}
			}
			//else this.errorAddVampire=0;
		}
	}
	public void addDracula2(int x, int y) {
		if(celdaVacia(x, y)) {
			if (this.gameObjectboard.limitedracula(x, y)) {
				if(!Dracula.getVivodracula()) {
					if(this.gameObjectboard.podravampire()) {
						this.gameObjectboard.add(new Dracula(x,y,this));
						Dracula.setVivodraculaCambio();
						//this.errorAddVampire=4;
					}
					//else this.errorAddVampire=0;
					
				}
				//else this.errorAddVampire=2; 
			}
			//else this.errorAddVampire=0;
		}
		//else this.errorAddVampire=0;
	}
	public void addExplosiveVampire2(int x, int y) {
		if(celdaVacia(x, y)) {
			if(this.gameObjectboard.limitedracula(x, y)) {
				this.gameObjectboard.add(new ExplosiveVampire(x,y,this));
				//Dracula.setVivodraculaCambio();
				//this.errorAddVampire=4;
			}
			//else this.errorAddVampire=0;
		}
		//else this.errorAddVampire=0;
		
	}

	public String serialize()throws CommandExecuteException {
		// TODO Auto-generated method stub
		String cad;
		cad= "\n"+"Cicles: "+this.ciclo+"\n"+
			"Coins: "+this.player.getCoins()+"\n"+
			"Level: "+this.level.getName()+"\n"+
			"Remaining Vampires: "+(this.level.getNumberOfVampires()-Vampire.getVampiretablero())+"\n"+
			"Vampires on the board: "+ tablero()+"\n"+
			"\n"+
			"Game Object List: "+
			this.gameObjectboard.serialize();
		
		return cad;
	}

	

	

	

	

	



}
