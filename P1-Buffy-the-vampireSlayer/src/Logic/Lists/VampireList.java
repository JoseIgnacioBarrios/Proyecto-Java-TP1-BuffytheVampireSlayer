package Logic.Lists;
import Logic.GameObjects.Vampire;

public class VampireList {
	
	private int contador;
	private int numvampire;
	private Vampire[] vampireList;
	
	public VampireList(int numvampire) {
		vampireList = new Vampire[numvampire];
		this.contador=0;
	}
//	public void numvampires(int numvampire){
//		//this.numvampire=numvampire;
//		vampireList =new Vampire[numvampire];
//	}
	
	public void add(Vampire vampire) {
		if(contador<numvampire) {
			vampireList[contador] = vampire;
			contador++;
		}
	}

	public Vampire[] getVampireList() {
		return vampireList;
	}

	public void setVampireList(Vampire[] vampireList) {
		this.vampireList = vampireList;
	}
	
	public Vampire getVampire(int x) {//devuelve vampire de la pos X
		if (x>=this.contador) {
			return null;
		}
		return this.vampireList[x];
		
		
	}
	

}
