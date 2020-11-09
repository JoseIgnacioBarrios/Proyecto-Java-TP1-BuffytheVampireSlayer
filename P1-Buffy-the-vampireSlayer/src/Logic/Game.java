package Logic;

import View.Gameprinter;
import Logic.GameObjects.Player;
import java.util.Random;

public class Game {
	
	private GameObjectBoard gameObjectboard;
	private Level nivel;
	private int numvampire;
	private int dimx;
	private int dimy;
	private int ciclo;
	private Player player;
	private Random rand ;
	private double frecuencia;
	private int contVampiros;
	
		public Game(Long seed, Level level) {
			this.nivel=level;
			this.contVampiros = 0;
			inicializaclassvampire();
			gameObjectboard= new GameObjectBoard(this);
			ciclo=0;
			player =new Player();
			this.rand=new Random(seed);
		}
		public Game() {
			
		}

		public int addSlayer(int x , int y) {
			int conError=0;
			if(coinsSuficiente()) 
			{
				conError=this.gameObjectboard.addSlayer(x, y);
			}
			else conError=2;
			return conError;
			 
			
		}
		public void addVampire() {			
			if(generatevampire() == true && this.contVampiros < this.nivel.getnumberOfVampires()) {
				this.gameObjectboard.addVampire((nivel.getdim_x()-1),rand.nextInt(this.dimy));
				this.contVampiros++;
			}
		}
		private boolean  generatevampire() {
			Random rand=this.getRand();
			boolean ok=false;
			if ((rand.nextDouble() < this.frecuencia)) {
				ok=true;
			}
			return ok;
		}
		
		public void inicializaclassvampire() {///solo se ejecute una vez 
			this.numvampire=nivel.getnumberOfVampires();
			this.dimx=nivel.getdim_x();
			this.dimy=nivel.getdim_y();
			this.frecuencia=nivel.getvampireFrequency();
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
			boolean fin=false;
			boolean ok = false;
			if(this.gameObjectboard.ganaVampiro()) {
				ok = true;
				this.gameObjectboard.setWinner(ok);
				fin=true;
			}
			else if(this.gameObjectboard.ganaJugador() && (this.nivel.getnumberOfVampires() - this.contVampiros == 0))	
			{	ok = false;
				this.gameObjectboard.setWinner(ok);
				fin=true;
			}
			return fin;
		}
		
		public void reset() 
		{
			initObjects();
		}
		public void initObjects() {
			this.gameObjectboard.borrarArraySlayer();
			this.gameObjectboard.borrarArrayVampire();
			this.ciclo=0;
			this.player.reset();
		}
		public void update() 
		{
			generarcoins();
			this.gameObjectboard.movVampire();
			attack();
			addVampire();
			this.gameObjectboard.removeDead();
			if(!finalizo()) ciclo++;
			
		}
		
		public void generarcoins() {
			Random rand=this.getRand();
			
			if(rand.nextFloat() > 0.5) {
				this.player.setcoins();
			}
		}
		public Random getRand() {
			return this.rand;
		}
		
		public boolean coinsSuficiente() 
		{
			boolean ok=false;
			if (player.getCoins()>=player.getUsacoins()) {
				ok=true;
			}
			return ok;
		}
		public void usarCoins() {
			player.usarCoins();
		}
		public void exit() {
			System.exit(0);
		}

		public boolean getWinner(){
			return this.gameObjectboard.getWinner();
		}
		
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
						if(this.gameObjectboard.tieneVidaslayer(i)) {
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
			}
			
			//ATACA VAMPIROS SI EXISTEN
			if (this.gameObjectboard.getContadorvampire()!=0 ) { 
				//IF SI HAY SLAYERS
				if (this.gameObjectboard.getContadorslayer()!=0) {					
					for(int i = 0; i < this.gameObjectboard.getContadorvampire(); i++)
					{	
						if(this.gameObjectboard.tieneVidaVampire(i)) {
						for(int j = 0; j < this.gameObjectboard.getContadorslayer(); j++)	
							{							
								//IF SLAYER ESTA DELANTE DEL VAMPIRO						
								if(((this.gameObjectboard.getXsalyer(j)+1) == this.gameObjectboard.getVampireX(i)) &&
									(this.gameObjectboard.getYsalyer(j) == this.gameObjectboard.getVampireY(i)))
								{
									if(this.gameObjectboard.tieneVidaslayer(j)) 
									{
										muerdeaSlayer(j);
									}	
								}
								//j++;
							}
						}
					}
				}	
			}
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
			"Remaining vampires: "+(this.nivel.getnumberOfVampires() - this.gameObjectboard.cont() )+"\n" +
			"Vampires on the board: "+this.gameObjectboard.getContadorvampire()+"\n"+
			str.toString();
			return estado;
		}
	
		
		
	
}
