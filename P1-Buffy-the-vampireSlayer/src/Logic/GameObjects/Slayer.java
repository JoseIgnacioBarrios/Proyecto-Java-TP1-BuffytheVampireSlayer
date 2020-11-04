package Logic.GameObjects;

import Logic.Game;

public class Slayer {
	private int x;
    private int y;
    private int vida;
    private int bala;
    private final int disparos;
    private final int danno;
    private final int coste;
    private Game game;
    
    public Slayer( int x,int y, Game game){
    	//this.vida = 3;
    	this.x= x;
    	this.y= y;
    	this.game = game;
    	
    	this.vida=3;
    	this.disparos=1;
    	this.danno=1;
    	this.coste=50;
    	this.bala=1;
    }
    
    
	public int atacar() {
	    	
	    	return danno;
	}
    public void defensa(int vida, int dano) {
    	this.vida = vida - dano;
    }
    
    public int get_vida() {//getter
    	return this.vida;
    }
    public void setCoordX(int x) {//setter
		this.x = x;
	}
    
	
	public int getXsalyer() {
		return this.x;
	}
	


	public int getYslayer() {
		return this.y;
	}


	public void setCoordY(int y) {//setter
		this.y = y;
	}
	public void recibedanno() {
		this.vida-=this.danno;
	}
	public int getbala () {
		return this.bala;
	}
	public void restabala() {
		this.bala--;
	}
	public void recargaBala() {
		this.bala++;
	}
	public String toString() {
		return "S ["+this.vida+"]";
	}
	

}
