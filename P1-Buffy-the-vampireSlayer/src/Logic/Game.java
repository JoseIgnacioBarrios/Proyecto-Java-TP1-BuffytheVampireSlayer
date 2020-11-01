package Logic;
import Logic.Lists.SlayerList;
import Logic.Lists.VampireList;
import Logic.GameObjects.Slayer;


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
	
	////////////////////////////////////////
	
		public Game(Long seed, Level level) {
			this.nivel=level;
			this.semilla=seed;
			
		}
		public Game() {
			gameObjectboard= new GameObjectBoard(listaslayer,this);
			listavampiro.numvampires(numvampires());
		}
		public boolean addSlayer(int x , int y) {
			this.gameObjectboard.addSlayer(x, y);
			return true;
		}
		public void addVampire() {
			this.gameObjectboard.addVamire(this.nivelcad, this.numvampire, this.dimxvamp, this.dimyvamp);
		}
		
		
		public void inicializaclassvampire() {
			this.nivelcad=nivel.getname();
			this.numvampire=nivel.getnumberOfVampires();
			this.dimxvamp=nivel.getdim_x();
			this.dimyvamp=nivel.getdim_y();
		}
		public int numvampires() {
			if (this.nivel==Level.EASY) {
				
				 n= Level.EASY.getnumberOfVampires();
			}
			if(this.nivel==Level.HARD) {
				  n=Level.HARD.getnumberOfVampires();
			}
			if(this.nivel==Level.HARD){
				  n=Level.INSANE.getnumberOfVampires();
			}
			return n;
		}
		
		
		
		
		///gett
		
//		public boolean isFinished() {
//			
//		}
}
