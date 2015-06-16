package queens;
//Helin Kerpeten S000738
public class Queen extends Piece {
	@Override
	public boolean canAttack(int x, int y) throws IllegalArgumentException{
		if(x<0||y<0)
			throw new IllegalArgumentException("Negative place!");
	    return (getX()==x||getY()==y)||(getX()+getY()==x+y)||(y==x+getY()-getX());
	}

	@Override
	public boolean equals(Object that) {
	if (((Queen)that).getX()==getX()&&((Queen)that).getY()==getY())
		return true;
	return false; 
}
}