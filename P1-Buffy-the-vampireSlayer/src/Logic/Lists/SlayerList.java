package Logic.Lists;
import Logic.GameObjects.Slayer;



public class SlayerList {
	
	private int contadorslayer=0;
	private int numslayer;
	
	private  Slayer[] slayerList;
	
	public SlayerList(int numslayer) {
		this.numslayer=numslayer;
		slayerList = new Slayer[this.numslayer];//max posile de slayer
	}
	///////////////////////////////
	public void add(Slayer slayer) {
		if(this.contadorslayer<numslayer) {
			slayerList[this.contadorslayer] = slayer;
			this.contadorslayer++;
		}
	}
	public Slayer getSlayer(int x) {//devuelve vampire de la pos X
		if (x>=this.contadorslayer) {
			return null;
		}
		return this.slayerList[x];
	}
	public int getnumvampire() 
	{
		return this.numslayer;
	}
}
