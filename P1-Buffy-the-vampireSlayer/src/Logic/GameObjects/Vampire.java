package Logic.GameObjects;
import Logic.Game;
import Logic.Level;

public class Vampire {
	
	private String nivel;
	private int numVampire;
	private int x;
    private int y;
    private int vida=3;
    private final int casillaMoverse = 1;
    private final int turnosMoverse = 2;
    private final int danno = 1;
    private Game game;
    private Level level;
    
    public Vampire(String nivel, int numVampire ,int x, int y,Game game){
    	this.nivel=nivel;
    	this.numVampire=numVampire;
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
	//lista[i].getY();

	public int getCasillaMoverse() {
		return casillaMoverse;
	}
	
	public int getTurnosMoverse() {
		return turnosMoverse;
	}
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getVida() {
		return vida;
	}
	
}
