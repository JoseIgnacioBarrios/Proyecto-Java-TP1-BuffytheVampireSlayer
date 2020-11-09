package Logic.GameObjects;
import Logic.Game;

public class Vampire {
	

	private int x;
    private int y;
    private int vida;
    private final int casillaMoverse;
    private final int danno;
    private Game game;
    private boolean mueve;
    
    ////
    //private Level level;
    
    public Vampire(int x, int y,Game game){//?????????????????????debe saberlo los x,y,nivel
    	this.x= x;
    	this.y= y;
    	this.game = game;
    	this.vida=5;
    	 this.casillaMoverse = 1;
    	 this.danno = 1;
    	 this.mueve=true;
    	 
    	 
    }
   
    public int atacar() {
    	return danno;
    }
    public void defensa(int vida, int dano) {
    	this.vida = vida - dano;
    }
    public void muerte(int poslista) {

    }
	public int getCasillaMoverse() {
		return casillaMoverse;
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
	public void mueveCambio() {
		if (this.mueve)
			this.mueve=false;
		else this.mueve=true;
	}
	
	public boolean getmueve()
	{
		return this.mueve;
	}

	public String toString() {
		return "V ["+this.vida+"]";
	}
	
}
