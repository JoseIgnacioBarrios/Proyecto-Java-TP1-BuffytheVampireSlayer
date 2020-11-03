package Logic;

//import Logic.Lists.SlayerList;
//import Logic.Lists.VampireList;
//import Logic.GameObjects.Slayer;
import View.Gameprinter;
import Logic.GameObjects.Player;

public class Game {
	
	private GameObjectBoard gameObjectboard;
	//private SlayerList listaslayer;
//	private VampireList listavampiro;
	/////////////////////////////////////////////
	private int n=0;
	private Level nivel;
	private Long semilla;
//	private int numX;
//	private String nivelcad;
	private int numvampire;
	private int dimx;
	private int dimy;
//	private double frecuencia;
	
////////////////////////////////////////
	private int ciclo;
	private Player player;
	
		public Game(Long seed, Level level) {
			this.nivel=level;
			this.semilla=seed;
			inicializaclassvampire();
			gameObjectboard= new GameObjectBoard(this);
			//listavampiro=new VampireList(this.numvampire);//
			ciclo=0;
			player =new Player();
		}
		public Game() {
			
		}
		public boolean addSlayer(int x , int y) {
			this.gameObjectboard.addSlayer(x, y);
			return true;
		}
		public void addVampire() {
			int aleatorio = (int)(Math.random()*nivel.getdim_y()+1);//calcular aleatorio
			
			if(generatevampire() == true) {
				this.gameObjectboard.addVampire((nivel.getdim_x()-1), aleatorio);
			}
		}
		//si puede crear un vampire sw if 0.1
		
		
		
		public boolean generatevampire() {
			boolean ok=false;
			int aleatorio = (int)(Math.random()*10+1); //aleatorio
			switch(nivel.getname()) {
				case "EASY":{
					if (aleatorio == 1) {
						ok=true;			
					}
					break;
				}
				case "HARD":{
					if (aleatorio == 5 || aleatorio==2) {
						ok=true;			
					}
					break;
				}
				case "INSANE":{
					if (aleatorio == 5 || aleatorio==2 || aleatorio==8) {
						ok=true;			
					}
					break;
				}
			}
			return ok;
		}
		
		public void inicializaclassvampire() {///solo se ejecute una vez 
			//this.nivelcad=nivel.getname();
			this.numvampire=nivel.getnumberOfVampires();
//			this.frecuencia=nivel.getvampireFrequency();
			this.dimx=nivel.getdim_x();
			this.dimy=nivel.getdim_y();
		}
		
		public int getNumvampire() {
			return numvampire;
		}
		public int getDimx() {
			return this.dimx;
		}
		public int getDimy() {
			return this.dimy;
		}
		
		public boolean finalizo() {// comprueba si hay vampiros en la lista o si estan en la columna 0
			return this.gameObjectboard.finalizo();	
		}
		
		////////////////comandos arr[1]
		public void reset() 
		{
			this.ciclo=0;
		}
		public void update() 
		{
			addVampire();
			this.ciclo++;
		}
		public void exit() {
			System.exit(0);
		}
		////////////////////////////////////////
		public boolean getWinner(){
			return this.gameObjectboard.getWinner();
		}
		
		public String toString() {
			Gameprinter str = new Gameprinter(this,nivel.getdim_x(),nivel.getdim_y());
			
			String estado;
			estado = "Number of cycles: "  +"\n"  + 
			"Coins: "  +"\n"  + 
			"Remainig vampires: "+this.nivel.getnumberOfVampires() +"\n" + str.toString();
			return estado;
		}
		public boolean coinsSuficiente() 
		{
			boolean ok=false;
			if (player.getCoins()>=player.getUsacoins()) {
				player.usarCoins();
				ok=true;
				return ok;
			}
			else return ok;
		}
		
		
	
}
