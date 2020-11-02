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

		public boolean addVampire(int x , int y) {
			Vampire auxVampire=new Vampire(x, y,game);
			this.listavampire.add(auxVampire);
			return true;
		}
		
		
		



}
