package Logic.Lists;
import Logic.GameObjects.Slayer;



public class SlayerList {
	
	private int contadorslayer;//el numero de slayer que se agregaron en la tabla
	private int numslayer;//el maximo de Slayer que puede haber
	private int x;
	private int y;
	private int v;
	
	private  Slayer[] slayerList;
	
	public SlayerList(int numslayer) {
		this.numslayer=numslayer;
		slayerList = new Slayer[this.numslayer];//max posile de slayer
		this.contadorslayer=0;
	}
	///////////////////////////////
	public void add(Slayer slayer) {
		if(this.contadorslayer<numslayer) {
			//this.contadorslayer++;
			slayerList[this.contadorslayer] = slayer;
			this.contadorslayer++;
		
		}
	}
	public int getContadorslayer() {
		return contadorslayer;
	}
	public int getXsalyer(int x) {
		return this.slayerList[x].getXsalyer();
	}
	public int getYsalyer(int y) {
		return this.slayerList[y].getYslayer();
	}
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
	
	public void recibedannoSlayer(int i) {
		this.slayerList[i].recibedanno();
	}
	public void recargaBala(int j) {
		this.slayerList[j].recargaBala();
	}
	public boolean buscarSlayer(int x,int y) {
		this.x=x;
		this.y=y;
		boolean ok=false;
		if(this.contadorslayer!=0) {	
			for (int i=0;i<this.contadorslayer;i++) {
				if(this.slayerList[i].getXsalyer()==this.x && this.slayerList[i].getYslayer()==this.y) {
					this.v=i;
					ok= true;
				}
			}
		}
		return ok;
	}
	public void borrarArraySlayer() {
		for (int i = this.contadorslayer; i >=0; i--) {
			this.slayerList[i]=null;
		}
		this.contadorslayer=0;
	}
	public void removeSlayer() {
		boolean recorrido=true;
		int j=0;
		while(j<this.contadorslayer && recorrido)
		{
				if(tieneVidaslayer(j)==false)
				{		
					this.slayerList[j]=null;
					for (int i = j; i < this.contadorslayer; i++) 
					{
						if((i+1)==this.contadorslayer) 
						{
							this.slayerList[i]=null;
							this.contadorslayer--;
						}
						else 
						{
							this.slayerList[i]=this.slayerList[i+1];
						}
					}
					recorrido=false;
				}
			j++;
		}
	}
	public String iconoSlayer(){
		return this.slayerList[this.v].toString();
		
	}
	
}
