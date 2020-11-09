package Logic.Lists;
import Logic.GameObjects.Vampire;

public class VampireList {
	
	private int contador;
	private int numvampire;
	private Vampire[] vampireList;
	private int vampireporAparecer;
	private int x;
	private int y;
	private int v;
	private boolean ok;
	
	public VampireList(int numvampire) {
		this.numvampire=numvampire;
		vampireList = new Vampire[numvampire];
		this.contador=0;
		vampireporAparecer();
	}
//	public void numvampires(int numvampire){
//		//this.numvampire=numvampire;
//		vampireList =new Vampire[numvampire];
//	}
	
	public void add(Vampire vampire) {
		if(contador<numvampire) {
			//contador++;
			vampireList[contador] = vampire;
			contador++;
			vampireporAparecer();///////////???'
			//this.numvampire--;			
		}
	}
	public void vampireporAparecer() {
		this.vampireporAparecer=this.numvampire - this.contador;
	}
	

//	public Vampire[] getVampireList() {
//		return vampireList;
//	}

//	public void setVampireList(Vampire[] vampireList) {
//		this.vampireList = vampireList;
//	}
	
	public int getVampireX(int x) {//devuelve vampire de la pos X	
		return this.vampireList[x].getXvampire();
	}
	public int getVampireY(int y) {//devuelve vampire de la pos X	
		return this.vampireList[y].getYvampire();
	}
	public void recibedannoVampire(int i) {
		this.vampireList[i].recibedannoVampire();
	}
	
	//public boolean tieneVidaslayer(int i) {//comprueba si tiene vida para quitarle desde GOB
	//	if(this.slayerList[i].get_vida()>0) {
	//		return true;
	//	}
	//	return false;
	//}
	public boolean tieneVidaVampire(int k) {
		boolean ok=false;
		if (this.vampireList[k].getVida()>0) {
			ok=true;
		}
		return ok;
	}
//	private boolean tieneVidaVampire2(int k) {
//		boolean ok=false;
//		if (this.vampireList[k].getVida()>=0) {
//			ok=true;
//		}
//		return ok;
//	}
	public void remove() {
		this.ok=false;
		boolean recorrido=true;
		int j=0;
		int aux=0;
		while(j<this.contador && recorrido)
		{
				if(tieneVidaVampire(j)==false)
				{		
					this.vampireList[j]=null;
					for (int i = j; i < this.contador; i++) 
					{
						if((i+1)==this.contador) 
						{
							this.vampireList[i]=null;
							this.contador--;
							aux++;
						}
						else 
						{
							this.vampireList[i]=this.vampireList[i+1];
							aux++;
						}
					}
					recorrido=false;
				}
			j++;
		}
		if(aux==this.numvampire) {
			this.ok=true;
		}
	}
	public boolean ganoSlayer() {
		return this.ok;
	}
	public int getContadorvampire() {//gett
		return this.contador;
	}
	public int getnumvampire() 
	{
		return this.numvampire;
	}
	public int getvampireporAparecer() 
	{
		return this.vampireporAparecer;
	}
	
	public void mueve(int x) {
		this.vampireList[x].mueveXvampire();
	}
	public boolean buscarVampireXY(int x,int y) {
		this.x=x;
		this.y=y;
		boolean ok=false;
		if(this.contador!=0) {
			for (int i=0;i<this.contador;i++) {
				if(this.vampireList[i].getXvampire()==this.x && this.vampireList[i].getYvampire()==this.y) {
					this.v=i;
					ok=true;
				}
			}
		}
		return ok;
	}
	
	public void borrarArrayVampire() {
		for (int i = this.contador-1; i >=0; i--) {
			this.vampireList[i]=null;
		}
		this.contador=0;
		this.vampireporAparecer();
	}
	public boolean getmueve(int x) {
		return this.vampireList[x].getmueve();
	}
	public void mueveCambio(int x) {
		this.vampireList[x].mueveCambio();
	}
	
	public String iconoVampire(){
		return this.vampireList[this.v].toString();
		
	}
	

}
