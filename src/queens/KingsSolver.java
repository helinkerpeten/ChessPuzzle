package queens;

import java.util.ArrayList;
import java.util.List;

public class KingsSolver extends Solver{

	@Override
	public List<Board> getAllSolutionsFor(int dimension) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
/*
ArrayList<Board> fulledBoards = new ArrayList<Board>();
public List<Board> getAllSolutionsFor(int dimension)throws IllegalArgumentException {
	if (dimension < 0)
		throw new IllegalArgumentException("Negative dimension!");
	this.dimension=dimension;
	ArrayList<Board> boards = new ArrayList<Board>();
	Board firstBoard = new Board(dimension);
	boards.add(firstBoard);
	while(boards.size()!=0){
		ArrayList<Board> validBoards = new ArrayList<Board>();
		for (Board board: boards) {
			for (int i = board.same; i < board.places.size(); i++) {
				Integer place= board.places.get(i);
				tryPlaceKingTo(board, place, validBoards,i);
				placeKingsToNoWhere(board, validBoards);
			}
		}
		boards=(ArrayList<Board>) validBoards.clone();
		System.out.println("boa"+boards.size());
	}
	return fulledBoards;
}
public void tryPlaceKingTo( Board board, int place,ArrayList<Board> validBoards,int i) {
	Board cloneBoard = (Board) board.clone();
	if(cloneBoard.getPieceAt(place%10,place/10)==null){
		cloneBoard.placePiece(new King(),  place%10,place/10);
		cloneBoard.same=i+1;
		cloneBoard.printBoard();
		if (cloneBoard.isValid()&& !validBoards.contains(cloneBoard)&& cloneBoard.pieces.size()<17){
			checkBoardPiecesSize(cloneBoard,validBoards);
//			if(cloneBoard.places!=null)
//				if(cloneBoard.places.contains(place))
//					//cloneBoard.places.remove(place);	

		}
	}
}
public void checkBoardPiecesSize(Board cloneBoard,ArrayList<Board> validBoards) {
	if(cloneBoard.pieces.size()==16)
		fulledBoards.add(cloneBoard);
	else if(cloneBoard.pieces.size()<16)
		validBoards.add(cloneBoard);



}
public void placeKingsToNoWhere(Board board,ArrayList<Board> validBoards) {
	Board cloneBoard3 = (Board) board.clone();
	if ( !validBoards.contains(cloneBoard3)) {
		validBoards.add(cloneBoard3);
	}
}*/