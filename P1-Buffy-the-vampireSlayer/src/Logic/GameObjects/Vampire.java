package Logic.GameObjects;
import Logic.Game;
import Logic.Level;

public class Vampire {
	
	private String nivel;
	private int numVampire;
	private int x;
    private int y;
    private int vida;
    private final int casillaMoverse;
    private final int turnosMoverse;
    private final int danno;
    private Game game;
    private Level level;
    
    public Vampire(int x, int y,Game game){//?????????????????????debe saberlo los x,y,nivel
//    	this.nivel=nivel;
//    	this.numVampire=numVampire;
    	this.x= x;
    	this.y= y;
    	this.game = game;
    	
    	 this.vida=3;
    	 this.casillaMoverse = 1;
    	 this.turnosMoverse = 2;
    	 this.danno = 1;
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
