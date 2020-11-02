package Logic;

import Logic.Lists.SlayerList;
import Logic.Lists.VampireList;
//import Logic.GameObjects.Slayer;
import View.Gameprinter;

public class Game {
	
	private GameObjectBoard gameObjectboard;
	private SlayerList listaslayer;
	private VampireList listavampiro;
	/////////////////////////////////////////////
	private int n=0;
	private Level nivel;
	private Long semilla;
	private int numX;
	private String nivelcad;
	private int numvampire;
	private int dimxvamp;
	private int dimyvamp;
	private double frecuencia;
	
	
	////////////////////////////////////////
	
		public Game(Long seed, Level level) {
			this.nivel=level;
			this.semilla=seed;
			inicializaclassvampire();
			gameObjectboard= new GameObjectBoard(listaslayer,this);
			listavampiro=new VampireList(this.numvampire);//
		}
		public Game() {
			
		}
		public boolean addSlayer(int x , int y) {
			this.gameObjectboard.addSlayer(x, y);
			return true;
		}
		public void addVampire() {
			int aleatorio = (int)(Math.random()*4+1);//calcular aleatorio
			
			if(generatevampire() == true) {
				this.gameObjectboard.addVampire((this.dimxvamp-1), aleatorio);
			}
		}
		//si puede crear un vampire sw if 0.1
		
		
		
		public boolean generatevampire() {
			boolean ok=false;
			int aleatorio = (int)(Math.random()*10+1); //aleatorio
			switch(nivelcad) {
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
			this.nivelcad=nivel.getname();
			this.numvampire=nivel.getnumberOfVampires();
			this.frecuencia=nivel.getvampireFrequency();
			this.dimxvamp=nivel.getdim_x();
			this.dimyvamp=nivel.getdim_y();
		}
		
//		public int numvampires() {//devuele el numero de vampiros segun el nivel
//			if (this.nivel==Level.EASY) {
//				
//				 n= Level.EASY.getnumberOfVampires();
//			}
//			else if(this.nivel==Level.HARD) {
//				  n=Level.HARD.getnumberOfVampires();
//			}
//			else if(this.nivel==Level.INSANE){
//				  n=Level.INSANE.getnumberOfVampires();
//			}
//			return n;
//		}
		
		
		public String toString() {
			Gameprinter str = new Gameprinter(this,this.dimxvamp,this.dimyvamp);
			
			String estado;
			estado = "Number of cycles: "  +"\n"  + 
			"Coins: "  +"\n"  + 
			"Remainig vampires: "+this.nivel.getnumberOfVampires() +"\n" + str.toString();
			return estado;
		}
		
		
	
}
