package Logic.GameObjects;

import Logic.Game;

public class Vampire extends GameObject{
	private int HARM ;
	private boolean muevete;
	private static int vampiretablero;
	private static int vampireEliminado;
	private int vampireporaparecer;
	public Vampire( int x, int y,Game game) {
		super(x,y,5,game);
		vampiretablero+=1;
		this.HARM=1;
		this.muevete=true;
		//vampireporaparecerSum();
		//vampireporaparecer=0;
		
	}

	public static int getvampireporaparecer() {
		return vampiretablero;
	}
	public static int getVampiretablero() {
		return vampiretablero;
	}
	public static int getvampireEliminado() {
		return vampireEliminado;
	}

	public int getVampireporaparecer() {
		return vampireporaparecer;
	}
	
	public void vampireporaparecerSum() {
		if(isAlive()==false) {
			this.vampireporaparecer++;
			vampireEliminado=this.vampireporaparecer;
		}	
	}

	@Override
	public void attack() {
		if (isAlive () ) {
			IAttack other = this.g.getAttackableInPosition(this.x-1, this.y);
			if (other != null ) {
			other.receiveVampireAttack(HARM);}
		}
	}
	public boolean receiveSlayerAttack(int HARM) {
		this.vida-=HARM;
		return true;
		
	}
	@Override
	public String toString() {
		
	
		String	 cadena = "V"+"["+this.vida+"]";
		
		
		return cadena;
	}



	@Override
	public void mov() {
		boolean ok=false;
			if(isAlive()) {
				ok=this.g.getceldaVacia(this.x-1,this.y);
				mueveteCambio();
				if (ok == false ) {
					//mueveteCambio();
					if(this.muevete==true) {
						moveIA2();
					//mueveteCambio();
					}
				}
				else if(this.muevete==true) {
					moveIA2();
				//else mueveteCambio();
				}
				 
			}
		//}
	}
	public boolean moveIA2() {
		this.x--;
		return true;
	}
	public boolean moveIA() {
		this.x--;
		return true;
	}
	private void mueveteCambio() {
		if (this.muevete)
			this.muevete=false;
		else this.muevete=true;
	}





}
