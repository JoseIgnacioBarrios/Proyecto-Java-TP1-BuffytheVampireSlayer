package Logic;

import Logic.GameObjects.Slayer;
import Logic.GameObjects.Vampire;
import Logic.Lists.SlayerList;
import Logic.Lists.VampireList;


	public class GameObjectBoard {
		
		private SlayerList listaslayer;
		private VampireList listavampire;
		private Game game;
		////////////////////////////////////
//		private String nivelcad;
//		private int numvampire;
//		private int dimxvamp;
//		private int dimyvamp;
//		private double frecuencia;
		
		//////////////////////////////////////
		//private Level nivel;
		private boolean ganaBM;	
		private int ent=4;
		
		
		public GameObjectBoard (Game game) {//SlayerList listaslayer,Game game) {
			//this.//listaslayer = listaslayer;//
			this.game=game;
			listavampire=new VampireList(game.getNumvampire());//
			listaslayer = new SlayerList(ent);
		}
		
		public boolean addSlayer(int x , int y) {
			Slayer auxslayer=new Slayer( x, y,game);
			this.listaslayer.add(auxslayer);
			return true;
		}

		public boolean addVampire(int x , int y) {
			Vampire auxVampire=new Vampire(x, y,game);
			this.listavampire.add(auxVampire);
			return true;
		}
//		public void inicializaclassvampire() {///solo se ejecute una vez 
//			this.nivelcad=nivel.getname();
//			this.numvampire=nivel.getnumberOfVampires();
//			this.frecuencia=nivel.getvampireFrequency();
//			this.dimxvamp=nivel.getdim_x();
//			this.dimyvamp=nivel.getdim_y();
//		}
		public boolean finalizo() 
		{
			boolean ok=false;
			if(listavampire.getContador()==0 && this.listavampire.getnumvampire()==0 ){
				ok=true;
				this.setWinner(ok);
				return ok;
			}
			for (int i=0; i < this.listavampire.getContador(); i++) {
				if (this.listavampire.getVampire(i).getX()==0) {
					ok=false;
					this.setWinner(ok);
					return ok;
				}
			}
			return ok;
		}
		public boolean getWinner(){
			return this.ganaBM;
		}
		
		public void setWinner(boolean ganaBM){
			this.ganaBM = ganaBM;
		}
		
		
		



}
