package queens;
//Helin Kerpeten S000738
public abstract class Piece {
    // Returns true if this piece can attack the
    // the board position x,y in a single move.
	int x;
	int y;
    public abstract boolean canAttack(int x, int y);

    public void setPosition(int x, int y) throws IllegalArgumentException{
		if(x<0||y<0)
			throw new IllegalArgumentException("Negative place!");
        this.x=x;
        this.y=y;
        
    }

    public int getX() {
        return x; // TODO
    }

    public int getY() {
        return y; // TODO
    }
}