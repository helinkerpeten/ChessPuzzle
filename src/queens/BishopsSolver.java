package queens;

import java.util.ArrayList;
import java.util.List;

public class BishopsSolver extends Solver{
	int x = 0;
	int y = 0;

	public List<Board> getAllSolutionsFor(int dimension)throws IllegalArgumentException {
		if (dimension < 0)
			throw new IllegalArgumentException("Negative dimension!");
		this.dimension=dimension;
		ArrayList<Board> boards = new ArrayList<Board>();
		Board board = new Board(dimension);
		boards.add(board);
		while (level < 15) {
			ArrayList<Board> validBoards = new ArrayList<Board>();
			for (int i = 0; i < boards.size(); i++) {
				if (y == x) 
					tryPlaceBishopTo(boards.get(i), x,y,validBoards);
				else {
					tryPlaceBishopTo(boards.get(i), x,y,validBoards);
					tryPlaceBishopTo(boards.get(i), y,x,validBoards);
				}
				placeBishopToNoWhere(boards.get(i), validBoards);
			}
			boards = ((ArrayList<Board>) validBoards.clone());
			level++;
			if (level > 7)
				x++;
			else
				y++;
		}
		return  getBoardsWith14Pieces(boards);
	}

	public void placeBishopToNoWhere(Board board,ArrayList<Board> validBoards) {
		Board cloneBoard = (Board) board.clone();
		if (cloneBoard.emptyChoice	&& !validBoards.contains(cloneBoard)) {
			cloneBoard.emptyChoice = false;
			validBoards.add(cloneBoard);
		}
	}

	public void tryPlaceBishopTo( Board board, int x,int y,ArrayList<Board> validBoards) {
		Board cloneBoard = (Board) board.clone();
		cloneBoard.placePiece(new Bishop(), x, y);
		if (cloneBoard.isValid()&& !validBoards.contains(cloneBoard))
			validBoards.add(cloneBoard);
	}

	public List<Board> getBoardsWith14Pieces(List<Board> boards) {
		ArrayList<Board> fullBoards = new ArrayList<Board>();
		for (Board board:boards) 
			if(board.pieces.size()==14)
				fullBoards.add(board);			
		return fullBoards;
	}

}

