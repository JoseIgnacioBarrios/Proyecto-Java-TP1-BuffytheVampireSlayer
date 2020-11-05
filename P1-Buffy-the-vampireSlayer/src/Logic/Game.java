package Logic;

//import Logic.Lists.SlayerList;
//import Logic.Lists.VampireList;
import Logic.GameObjects.Slayer;
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
	private Slayer slayer;
	
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
				this.gameObjectboard.addVampire((nivel.getdim_x()), aleatorio);
			}
		}
		//si puede crear un vampire sw if 0.1
		
		
		
		public boolean generatevampire() {
			boolean ok=false;
			int aleatorio = (int)(Math.random()*10+1); //aleatorio
			String c=nivel.getname();
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
//		public int getxsalyergame() {
//			return this.slayer.getXsalyer();
//		}
		
		public void attack() 
		{
			for(int i=1; i<=this.gameObjectboard.getListavampire().getContadorvampire();i++) {
				for(int k=1; k<=this.gameObjectboard.getListaslayer().getContadorslayer();k++) {
					
					if(		((this.gameObjectboard.getListaslayer().getSlayer(k).getXsalyer()+1)==
							this.gameObjectboard.getListavampire().getVampire(i).getXvampire()) &&
							(this.gameObjectboard.getListaslayer().getSlayer(k).getYslayer()==
							this.gameObjectboard.getListavampire().getVampire(i).getYvampire())
						
						)
						{
						muerdeaSlayer(k);
						}
					if(this.gameObjectboard.getListaslayer().getSlayer(k).getYslayer()==this.gameObjectboard.getListavampire().getVampire(i).getYvampire()) 
						{
							if(this.gameObjectboard.tieneVidaslayer(k)==true) 
							{
								if(this.gameObjectboard.tieneVidaVampire(i)==true) {
									if(this.gameObjectboard.tieneBala(k)==true) {
										disparaaVampire(i);
										this.gameObjectboard.restaBala(k);
									}
									
								}
								
							}
						}
				}
				
			}
			////////////////recarga bala
			for (int j=1;j<=this.gameObjectboard.getListaslayer().getContadorslayer();j++) {
				this.gameObjectboard.recargaBala(j);
			}
			
		}
		
		public void disparaaVampire(int i) {
			this.gameObjectboard.getListavampire().getVampire(i).recibedannoVampire();
		}
		
		public void muerdeaSlayer(int k) {
			this.gameObjectboard.getListaslayer().getSlayer(k).recibedanno();
		}
		
		///////////////movimiento ////////////////////////////
		public void movimiento() {
			
		}
		/////////////////////////////////////////////////////////////
		
		public String toString() {//////////////////////TABLERO//////////////////////////////////////////////////////
			Gameprinter str = new Gameprinter(this,nivel.getdim_x(),nivel.getdim_y());
			
			String estado;
			estado = "Number of cycles: "  +"\n"  + 
			"Coins: "  +"\n"  + 
			"Remainig vampires: "+this.gameObjectboard.getvampireporAparecer() +"\n" +
			"Vampire on the board: "+"\n"+
			str.toString();
			return estado;
		}
	
		
		
	
}
