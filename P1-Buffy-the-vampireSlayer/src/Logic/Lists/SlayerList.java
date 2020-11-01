package Logic.Lists;
import Logic.GameObjects.Slayer;


public class SlayerList {
	
	private int contador=0;
	private int numslayer=36;
	
	private  Slayer[] slayerList;
	
	public SlayerList() {
		slayerList = new Slayer[numslayer];//max posile de slayer
	}
	///////////////////////////////
	public void add(Slayer slayer) {
		if(contador<numslayer) {
			slayerList[contador] = slayer;
			contador++;
		}
		
	}
}
