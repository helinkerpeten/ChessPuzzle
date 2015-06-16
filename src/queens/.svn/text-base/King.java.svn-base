package queens;

public class King extends Piece {

	public boolean canAttack(int x, int y) throws IllegalArgumentException{
		if(x<0||y<0)
			throw new IllegalArgumentException("Negative place!");
	    return ((getX()==x && Math.abs(getY()-y)==1)||
	    		(getY()==y && Math.abs(getX()-x)==1)||
	    		(Math.abs( getX() - x) == Math.abs(getY() - y) && Math.abs(getX()-x)==1));
	}

}
