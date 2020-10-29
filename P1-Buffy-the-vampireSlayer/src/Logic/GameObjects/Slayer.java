package Logic.GameObjects;

import Logic.Game;

public class Slayer {
	private int x;
    private int y;
    private int vida;
    private final int disparos = 1;
    private final int danno = 1;
    private final int coste = 50;
    private Game game;
    
    public Slayer(int x, int y, Game game){
    	this.vida = 3;
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
    public void muerte(int poslista) {
    	
    }

}
