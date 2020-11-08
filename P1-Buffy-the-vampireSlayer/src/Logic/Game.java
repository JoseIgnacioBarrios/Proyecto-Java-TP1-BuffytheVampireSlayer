package Logic;

//import Logic.Lists.SlayerList;
//import Logic.Lists.VampireList;
//import Logic.GameObjects.Slayer;
import View.Gameprinter;
import Logic.GameObjects.Player;
import java.util.Random;

public class Game {
	
	private GameObjectBoard gameObjectboard;
	//private SlayerList listaslayer;
//	private VampireList listavampiro;
	/////////////////////////////////////////////
	//private int n=0;
	private Level nivel;
	private Long semilla;
//	private int numX;
//	private String nivelcad;
	private int numvampire;
	private int dimx;
	private int dimy;
//	private double frecuencia;
	//private Slayer slayer;
	//rand = new Random(seed);
////////////////////////////////////////
	private int ciclo;
	private Player player;
	private Random random ;
	
		public Game(Long seed, Level level) {
			this.nivel=level;
			//this.semilla=seed;
			inicializaclassvampire();
			gameObjectboard= new GameObjectBoard(this);
			//listavampiro=new VampireList(this.numvampire);//
			ciclo=0;
			player =new Player();
			random = new Random(seed);
		}
		public Game() {
			
		}
		////////////////////////////////////////
		public int addSlayer(int x , int y) {
			int conError=0;
			if(coinsSuficiente()) 
			{
				conError=this.gameObjectboard.addSlayer(x, y);
				usarCoins();
			}
			else conError=2;
			return conError;
			 
			
		}
		///////////////////////////////////////////////////////////////////
		public void addVampire() {
			//int aleatorio = (int)(Math.random()*nivel.getdim_y());//calcular aleatorio
			int n = random.nextInt(this.dimy);
			
			//if(generatevampire() == true) {
				this.gameObjectboard.addVampire((nivel.getdim_x()-1), n);
			//}
		}
		//si puede crear un vampire sw if 0.1
		//Random random=new Random();
		
		
		
//		public boolean generatevampire() {
//			boolean ok=false;
//			int aleatorio = (int)(Math.random()*10+1); //aleatorio
//			//String c=nivel.getname();
//			switch(nivel.getname()) {
//				case "easy":{
//					if (aleatorio == 1) {
//						ok=true;			
//					}
//					break;
//				}
//				case "hard":{
//					if (aleatorio == 5 || aleatorio==2) {
//						ok=true;			
//					}
//					break;
//				}
//				case "insane":{
//					if (aleatorio == 5 || aleatorio==2 || aleatorio==8) {
//						ok=true;			
//					}
//					break;
//				}
//			}
//			return ok;
//		}
		
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
			initObjects();
		}
		public void initObjects() {
			this.gameObjectboard.borrarArraySlayer();
			this.gameObjectboard.borrarArrayVampire();
			this.ciclo=0;
			this.player.reset();
			//this
		}
		public void update() 
		{
			
			this.gameObjectboard.movVampire();
			attack();
			addVampire();
			//this.gameObjectboard.removeDead();
			
			this.ciclo++;
		}
		public void exit() {
			System.exit(0);
		}
		public int getCiclo() {
			return this.ciclo;
		}
		////////////////////////////////////////
		public boolean getWinner(){
			return this.gameObjectboard.getWinner();
		}
		
		
		public boolean coinsSuficiente() 
		{
			boolean ok=false;
			if (player.getCoins()>=player.getUsacoins()) {
				//player.usarCoins();
				ok=true;
			}
			return ok;
		}
		public void usarCoins() {
			player.usarCoins();
		}
//		public int getxsalyergame() {
//			return this.slayer.getXsalyer();
//		}
		
		public void attack() 
		{			
			boolean disparaSlayer;
			//ATACA SLAYER SI EXISTEN
			if (this.gameObjectboard.getContadorslayer()!=0) { 
			//IF HAYA VAMPIROS
				if (this.gameObjectboard.getContadorvampire()!=0) {					
					for(int i = 0; i < this.gameObjectboard.getContadorslayer(); i++)
					{	
						disparaSlayer = true;
						int j = 0;
						//IF TENGA BALAS CADA SLAYER
						while (j < this.gameObjectboard.getContadorvampire() && disparaSlayer)
						{							
							//IF VAMPIRE ESTE EN LA MISMA FILA						
							if(this.gameObjectboard.getYsalyer(i) == this.gameObjectboard.getVampireY(j))
							{
								//IF VAMPIRE TENGA VIDA
								if(this.gameObjectboard.tieneVidaVampire(j) == true)
								{
									disparaaVampire(j);
									//this.gameObjectboard.restaBala(i);
									disparaSlayer = false;									
								}
							}
							j++;
						}
					}
				}	
			}
			
			//ATACA VAMPIROS SI EXISTEN
			if (this.gameObjectboard.getContadorvampire()!=0) { 
				//IF SI HAY SLAYERS
					if (this.gameObjectboard.getContadorslayer()!=0) {					
						for(int i = 0; i < this.gameObjectboard.getContadorvampire(); i++)
						{	
							for(int j = 0; j < this.gameObjectboard.getContadorslayer(); j++)	
							{							
								//IF SLAYER ESTA DELANTE DEL VAMPIRO						
								if(((this.gameObjectboard.getXsalyer(j)+1) == this.gameObjectboard.getVampireX(i)) &&
									(this.gameObjectboard.getYsalyer(j) == this.gameObjectboard.getVampireY(i)))
								{

									muerdeaSlayer(j);
								}
								j++;
							}
						}
					}	
				}
			
			//ATACA VAMPIRE			
//			for(int i=1; i<=this.gameObjectboard.getContadorvampire();i++) {
//				for(int k=1; k<=this.gameObjectboard.getContadorslayer();k++) {
//					
//					if(		((this.gameObjectboard.getXsalyer(k)+1)==
//							this.gameObjectboard.getVampireX(i)) &&
//							(this.gameObjectboard.getYsalyer(k)==
//							this.gameObjectboard.getVampireY(i))
//						
//						)
//						{
//						muerdeaSlayer(k);
//						}
//					if(this.gameObjectboard.getYsalyer(k)==this.gameObjectboard.getVampireY(i)) 
//						{
//							if(this.gameObjectboard.tieneVidaslayer(k)==true) 
//							{
//								if(this.gameObjectboard.tieneVidaVampire(i)==true) {
//									if(this.gameObjectboard.tieneBala(k)==true) {
//										disparaaVampire(i);
//										this.gameObjectboard.restaBala(k);
//									}
//									
//								}
//								
//							}
//						}
//				}
//				
//			}
//			////////////////recarga bala
//			for (int j=0;j<=this.gameObjectboard.getContadorslayer();j++) {
//				this.gameObjectboard.recargaBala(j);
//			}
			
		}
		
		public void disparaaVampire(int i) {
			this.gameObjectboard.recibedannoVampire(i);
		}
		
		public void muerdeaSlayer(int k) {
			this.gameObjectboard.recibedannoSlayer(k);
		}
		
		public String getBuscarAvatar(int x , int y) {
			if(this.gameObjectboard.buscarVampireXY(x,y)) {
				return this.gameObjectboard.iconoVampire();
			}
			else if(this.gameObjectboard.buscarSlayer(x,y)) {
				return this.gameObjectboard.iconoSlayer();
			}
			
			return "";
			
		}
		
		public String toString() {//////////////////////TABLERO//////////////////////////////////////////////////////
			Gameprinter str = new Gameprinter(this,nivel.getdim_x(),nivel.getdim_y());
			
			String estado;
			estado = "Number of cycles: "  +this.ciclo+"\n"  + 
			"Coins: "  +this.player.getCoins()+"\n"  + 
			"Remainig vampires: "+this.gameObjectboard.getvampireporAparecer() +"\n" +
			"Vampire on the board: "+this.gameObjectboard.getContadorvampire()+"\n"+
			str.toString();
			return estado;
		}
	
		
		
	
}
