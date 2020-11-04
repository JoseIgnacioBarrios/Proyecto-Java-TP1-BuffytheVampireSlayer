package Logic;

import Logic.GameObjects.Slayer;
import Logic.GameObjects.Vampire;
import Logic.Lists.SlayerList;
import Logic.Lists.VampireList;


	public class GameObjectBoard {
		
		private SlayerList listaslayer;
		private VampireList listavampire;
		private Game game;
		private boolean si;
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

		public boolean finalizo() ///??????????????
		{
			boolean ok=false;
			if(listavampire.getContadorvampire()==0 && this.listavampire.getvampireporAparecer()==0 ){
				ok=true;
				this.setWinner(ok);
				return ok;
			}
			for (int i=1; i <= this.listavampire.getContadorvampire(); i++) {
				if (this.listavampire.getVampire(i).getXvampire()-1<=0) {//x?????
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
		public int getvampireporAparecer() {
			return this.listavampire.getvampireporAparecer();
		}
//		public int getContadorvampire() {
//			return this.listavampire.getContador();
//		}
//		public void muevevampire() {
//			for (int i=1;i<=this.listavampire.getContadorvampire() ;i++) {
//				if(this.si) {
//					
//				}
//			}
//		}
//		public void hayDelanteSlayer(int j) {
//			for(int i=1; i<=this.listavampire.getContadorvampire();i++) {
//				for(int k=1; k<=this.listaslayer.getContadorslayer();k++) {
//					this.listaslayer.getSlayer(i)
//				}
//				
//			}
//		}

		public VampireList getListavampire() {
			return this.listavampire;
		}

		public SlayerList getListaslayer() {
			return this.listaslayer;
		}
		public boolean tieneVidaslayer(int k) {
			return this.listaslayer.tieneVidaslayer(k);
		}
		public boolean tieneVidaVampire(int i) {
			return this.listavampire.tieneVidaVampire(i);
		}
		public boolean tieneBala(int k) {
			return this.listaslayer.tieneBala(k);
		}
		public void restaBala(int k) {
			 this.listaslayer.restaBala(k);
		}
		public void recargaBala(int j) {
			this.listaslayer.recargaBala(j);
		}
		



}
