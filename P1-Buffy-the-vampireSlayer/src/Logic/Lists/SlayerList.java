package Logic.Lists;
import Logic.GameObjects.Slayer;



public class SlayerList {
	
	private int contadorslayer=0;//el numero de slayer que se agregaron en la tabla
	private int numslayer;//el maximo de Slayer que puede haber
	
	private  Slayer[] slayerList;
	
	public SlayerList(int numslayer) {
		this.numslayer=numslayer;
		slayerList = new Slayer[this.numslayer+1];//max posile de slayer
	}
	///////////////////////////////
	public void add(Slayer slayer) {
		if(this.contadorslayer<=numslayer) {
			this.contadorslayer++;
			slayerList[this.contadorslayer] = slayer;
			//this.contadorslayer++;
		}
	}
	public Slayer getSlayer(int x) {//devuelve vampire de la pos X
		if (x>=this.contadorslayer) {
			return null;
		}
		return this.slayerList[x];
	}
	public int getContadorslayer() {
		return contadorslayer;
	}
	//	public int getnumvampire() //el numero maximo de slayer
//	{
//		return this.numslayer;
//	}
	public boolean tieneVidaslayer(int i) {//comprueba si tiene vida para quitarle desde GOB
		if(this.slayerList[i].get_vida()>0) {
			return true;
		}
		return false;
	}
	public boolean tieneBala(int i) {
		if(this.slayerList[i].getbala()>0) {
			return true;
		}
		return false;
	}
	public void restaBala(int k) {
		this.slayerList[k].restabala();
	}
	
	public void recibedanno(int i) {
		this.slayerList[i].recibedanno();
	}
	public void recargaBala(int j) {
		this.slayerList[j].recargaBala();
	}
//	public int recorrido() {//////preguntar cuando sea cero puedo poner in if para compara si es null en la pos 0 del array????
//		int x=0;
//		for (int i=0;i>this.contadorslayer;i++) {
//			return x=i;
//		}
//		return x;
//	}
}
