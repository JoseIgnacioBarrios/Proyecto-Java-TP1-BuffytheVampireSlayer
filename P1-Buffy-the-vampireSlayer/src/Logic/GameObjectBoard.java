package Logic;

import Logic.GameObjects.Slayer;
import Logic.GameObjects.Vampire;
import Logic.Lists.SlayerList;
import Logic.Lists.VampireList;


	public class GameObjectBoard {
		
		private SlayerList listaslayer;
		private VampireList listavampire;
		private Game game;
		//private boolean si;
		////////////////////////////////////
//		private String nivelcad;
//		private int numvampire;
//		private int dimxvamp;
//		private int dimyvamp;
//		private double frecuencia;
		
		//////////////////////////////////////
		//private Level nivel;
		private boolean ganaBM;	
		private int ent;
		
		
		public GameObjectBoard (Game game) {//SlayerList listaslayer,Game game) {
			//this.//listaslayer = listaslayer;//
			this.game=game;
			listavampire=new VampireList(game.getNumvampire());//
			listaslayer = new SlayerList(espacioparaSlayer());
		}
		public int espacioparaSlayer() {
			return this.ent=(this.game.getDimx()*game.getDimy())-game.getDimy();
		}
		public int addSlayer(int x , int y) {
			//boolean ok=false;
			int conError=0;
			if(celdaLibre(x,y)) {
				Slayer auxslayer=new Slayer( x, y,game);
				this.listaslayer.add(auxslayer);
				this.game.usarCoins();
			}
			else conError=1;
			return conError;
			
		}
		public boolean celdaLibre(int x,int y) {
			boolean encontrado=true;
			if(x<game.getDimx() && x>=0 && y<game.getDimy() && y>=0) {
				int i=0;
				if (this.listaslayer.getContadorslayer()!=0)
				{
					while(i< this.listaslayer.getContadorslayer() && encontrado) {
						if(x==this.listaslayer.getXsalyer(i) && y==this.listaslayer.getYsalyer(i)) {
							encontrado = false;
						}
						i++;
					}
				}
			}
			else {
				encontrado =false;
			}
			return encontrado;
		}

		public boolean addVampire(int x , int y) {///agregar if para ver si existe un vampire en esa misma x , y
			boolean ok=false;
			if(celdaLibreVmapire(x,y)) {
				//System.out.println("celdaVampire");
				Vampire auxVampire=new Vampire(x, y,game);
				this.listavampire.add(auxVampire);
				ok=true;
			}
			return ok;
		}
		public boolean celdaLibreVmapire(int x,int y) {
			boolean encontrado=true;
			if(x<game.getDimx() && x>=0 && y<game.getDimy() && y>=0) {
				int i=0;
				while(i< this.listavampire.getContadorvampire() && encontrado) {
					if(x==this.listavampire.getVampireX(i) && y==this.listavampire.getVampireY(i)) {
						encontrado = false;
					}
					i++;
				}
			}
			else {
				encontrado =false;
			}
			return encontrado;
		}

		public boolean finalizo() ///??????????????
		{
			
			boolean ok=false;
			if(listavampire.getContadorvampire()<=0 && this.listavampire.getvampireporAparecer()==0 ){
				ok=true;
				this.setWinner(ok);
				return ok;
			}
			if(this.listavampire.getContadorvampire()!=0) {
				for (int i=0; i < this.listavampire.getContadorvampire(); i++) {
					if (this.listavampire.getVampireX(i)==0 ){//x?????
						ok=true;
						this.setWinner(ok);
						return ok;
					}
				}
			}
			if(this.listavampire.ganoSlayer())
			{
				
				this.setWinner(false);
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

//		public VampireList getListavampire() {
//			return this.listavampire;
//		}
		public int getContadorvampire() {
			return this.listavampire.getContadorvampire();
		}
		public int getVampireX(int x) {
			return this.listavampire.getVampireX(x);
		}
		public int getVampireY(int y) {
			return this.listavampire.getVampireY(y);
		}
		public void recibedannoVampire(int i) {
			this.listavampire.recibedannoVampire(i);
		}

//		public SlayerList getListaslayer() {
//			return this.listaslayer;
//		}
		public int getContadorslayer() {
			return this.listaslayer.getContadorslayer();
		}
		public int getXsalyer(int k) {
			return this.listaslayer.getXsalyer(k);
		}
		public void recibedannoSlayer(int k) {
			this.listaslayer.recibedannoSlayer(k);
		}
		public int getYsalyer(int k) {
			return this.listaslayer.getYsalyer(k);
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
		
		////////////////mov/////////////////////////
//		public void update() {
//			
//		}

		public void movVampire() {
			
			if(this.listavampire.getContadorvampire()!=0) 
			{
				for (int i = 0; i < this.listavampire.getContadorvampire(); i++) 
				{
					muevecambioVampire(i);
					if (this.listavampire.getmueve(i)) 
					{
						if (this.listaslayer.getContadorslayer()!=0)
						{
							for (int j = 0; j < this.listaslayer.getContadorslayer(); j++) 
							{
								if(this.listaslayer.getXsalyer(j)+1==this.listavampire.getVampireX(i) &&
										this.listaslayer.getYsalyer(j)==this.listavampire.getVampireY(i))
								{
									
								}
								else {this.listavampire.mueve(i);}
							}
						}
						else {this.listavampire.mueve(i);}
					}
				}
			}
//				if(this.listavampire.getContadorvampire()!=0) {
//					for (int i = 0; i < this.listavampire.getContadorvampire(); i++) {
//						if(this.listavampire.mueveVampire(i)) {
//							if(this.listaslayer.getContadorslayer()!=0) {
//								for (int j = 0; j < this.listaslayer.getContadorslayer(); j++) {
//								
//									if ((this.listavampire.getVampireX(i)-1==this.listaslayer.getXsalyer(j)&&
//										this.listavampire.getVampireY(i)==this.listaslayer.getYsalyer(j) ))
//									{	
//										//this.listavampire.mueve(i);	
//									}
//								else {
//									this.listavampire.mueve(i);
//									//muevecambioVampire(i);
//								}
//							}
//						}
//						else this.listavampire.mueve(i);
//						
//							//this.listavampire.mueve(i);
//			//				if(this.listaslayer.getContadorslayer()<=0) {
//			//					this.listavampire.mueve(i);
//			//				}
//						muevecambioVampire(i);
//						}
//						else {
//							muevecambioVampire(i);
//						}
//					}
//				}
			}
		public void muevecambioVampire(int x) {
			
			this.listavampire.mueveCambio(x);
		}	
		
		public void removeDead() {
//			for (int i = 0; i < this.listavampire.getContadorvampire(); i++) {
//				for (int j = 0; j < this.listaslayer.getContadorslayer(); j++) {
					this.listavampire.remove();
					this.listaslayer.removeSlayer();
				//}
			//}
		}
		public void borrarArraySlayer() {
			this.listaslayer.borrarArraySlayer();
		}
		public void borrarArrayVampire() {
			//this.listavampire.se
			this.listavampire.borrarArrayVampire();
		}
		//////////////////////////////////////////////
		public boolean buscarVampireXY(int x,int y) {
			return this.listavampire.buscarVampireXY(x,y);
		}
		public String iconoVampire() {
			return this.listavampire.iconoVampire();
		}
		
		public boolean buscarSlayer(int x,int y) {
			return this.listaslayer.buscarSlayer(x,y);
		}
		public String iconoSlayer() {
			return this.listaslayer.iconoSlayer();
		}



}
