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
	public int getXvampire() {
		return this.x;
	}

	public int getYvampire() {
		return this.y;
	}
	public void mueveXvampire()
	{
		this.x-=1;
	}

	public int getVida() {
		return this.vida;
	}
	public void recibedannoVampire() {
		this.vida-=this.danno;
	}
	public String toString() {
		return "V ["+this.vida+"]";
	}
	
}
