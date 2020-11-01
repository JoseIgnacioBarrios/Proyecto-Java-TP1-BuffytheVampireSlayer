package Logic.Lists;
import Logic.GameObjects.Slayer;
import Logic.GameObjects.Vampire;

public class VampireList {
	
	private int contador=0;
	private int numvampire;
	private Vampire[] vampireList;
	
	
	public void numvampires(int numvampire){
		this.numvampire=numvampire;
		vampireList =new Vampire[numvampire];
	}
	
	public void add(Vampire vampire) {
		if(contador<numvampire) {
			vampireList[contador] = vampire;
			contador++;
		}
		
	}
	

}
