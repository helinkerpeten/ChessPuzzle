package queens;

public class Bishop extends Piece{

	public boolean canAttack(int x, int y) throws IllegalArgumentException{
		if(x<0||y<0)
			throw new IllegalArgumentException("Negative place!");
	    return (Math.abs( this.x - x) == Math.abs(this.y - y));
	}

}
