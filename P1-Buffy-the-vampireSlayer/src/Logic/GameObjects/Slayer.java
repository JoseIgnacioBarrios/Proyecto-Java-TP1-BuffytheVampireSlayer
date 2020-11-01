package Logic.GameObjects;

import Logic.Game;

public class Slayer {
	private int x;
    private int y;
    private int vida=3;
    private final int disparos = 1;
    private final int danno = 1;
    private final int coste = 50;
    private Game game;
    
    public Slayer( int x,int y, Game game){
    	//this.vida = 3;
    	this.x= x;
    	this.y= y;
    	this.game = game;
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
	
	public void setCoordY(int y) {//setter
		this.y = y;
	}

}
