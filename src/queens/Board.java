package queens;
//Helin Kerpeten S000738

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Board implements Cloneable {
	int dimension ;
	boolean emptyChoice=true;
	int same= 0;
	ArrayList<Piece> pieces=new ArrayList<Piece>();
	ArrayList<Integer> places = new ArrayList<Integer>();
	public Board(int dimension)throws IllegalArgumentException {
		if (dimension<=0)
			throw new IllegalArgumentException("Illegal dimension!.");
		else
			this.dimension=dimension;
		for (int i = 0; i < 8; i++) 
			for (int j = 0; j < 8; j++) 
				places.add(i*10+j);
	}

	public Board clone(){  
		Board cloneBoard=new Board(dimension);
		for(Piece piece: getPieces()){
			Piece clonePiece =null;
			if(piece instanceof Queen){
				clonePiece =new Queen ();
			}else if (piece instanceof Rook)
				clonePiece =new Rook ();
			else if (piece instanceof Bishop)
				clonePiece =new Bishop ();
			else if (piece instanceof King)
				clonePiece =new King ();
			cloneBoard.placePiece(clonePiece,piece.getX(), piece.getY());
			cloneBoard.emptyChoice=emptyChoice;
			cloneBoard.same=same;
			ArrayList<Integer> clonePlaces=(ArrayList<Integer>) places.clone();
		}
		return cloneBoard;  
	}  


	// Raises IllegalArgumentException if the coordinates
	// are out of bounds, or if the position x,y is already
	// occupied.
	public void placePiece(Piece piece, int x, int y) throws IllegalArgumentException {
		if (dimension<=x||dimension<=y)
			throw new IllegalArgumentException("Unbounded place!.");
		if(x<0||y<0)
			throw new IllegalArgumentException("Negative place!");
		else if(getPieceAt(x, y)!=null)
			throw new IllegalArgumentException("This place already full!");
		else {
			piece.setPosition(x, y);
			getPieces().add(piece);
		}
	}

	// Returns null if no piece at position x,y exists
	public Piece getPieceAt(int x, int y) {
		if(getPieces()!=null)
			for(Piece piece: getPieces())
				if (piece.getX()==x&&piece.getY()==y)
					return piece;
		return null; 

	}

	// For a board to be valid,
	// no piece should be able to attack another
	public boolean isValid() {
		if(getPieces().size()==0)
			return true; 
		else {
			for(Piece piece :getPieces())
				for(Piece otherPiece:getPieces()){
					if(!piece.equals(otherPiece)&&
							otherPiece.canAttack(piece.getX(),piece.getY()))
						return false;
				}
			return true;
		}
	}

	public List<Piece> getPieces() {
		return pieces;
	}

	public int getDimension() {
		return dimension; 
	}

	@Override
	public boolean equals(Object that) {
		if(pieces.size()==((Board)that).pieces.size()&&dimension==((Board)that).dimension){
			for (Piece piece:pieces){
				if(((Board)that).getPieceAt(piece.getX(),piece.y)==null)
					return false;
			}return true;
		}else return false	;
	}

	public void printBoardWithGUI( JButton [][]  square,Game game){

		for(int i=0 ;i<dimension;i++){
			for (int j = 0; j <dimension; j++) 
				if(getPieceAt(j, i)!=null){
					if(getPieceAt(j, i) instanceof Rook)
						square[j][i].setIcon(new ImageIcon("R.png"));
					if(getPieceAt(j, i) instanceof Bishop)
						square[j][i].setIcon(new ImageIcon("B.png"));
					if(getPieceAt(j, i) instanceof Queen)
						square[j][i].setIcon(new ImageIcon("Q.png"));
					if(getPieceAt(j, i) instanceof King)
						square[j][i].setText(" K ");
				}		
		}
	}

}