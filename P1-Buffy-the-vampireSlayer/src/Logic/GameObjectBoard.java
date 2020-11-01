package Logic;

import Logic.GameObjects.Slayer;
import Logic.GameObjects.Vampire;
import Logic.Lists.SlayerList;
import Logic.Lists.VampireList;

	public class GameObjectBoard {
		
		private SlayerList listaslayer;
		private VampireList listavampire;
		private Game game;
		
		public GameObjectBoard (SlayerList listaslayer,Game game) {
			this.listaslayer = listaslayer;//+
			this.game=game;
		}
		
		public boolean addSlayer(int x , int y) {
			Slayer auxslayer=new Slayer( x, y,game);
			this.listaslayer.add(auxslayer );
			return true;
		}
		public boolean addVamire(String nivel,int numVampire,int x , int y) {
			Vampire auxVampire=new Vampire( nivel,numVampire,x, y,game);
			this.listavampire.add(auxVampire);
			return true;
		}
//		public boolean isFinished(){
//			if(this.listavampire.getContador() == 0 ){
//				this.setWinner(true); // Gana jugador
//				return true;
//			}
//			
//			for(int i = 0; i < this.listaZombie.getContador(); i++){
//				if(this.getListaZombie().getPosicion(i).getY() == 0){
//					System.out.println("i: " + i);
//					this.setWinner(false); // Gana zombie
//					return true;
//				}
//			}
//			return false;
//		}


}
