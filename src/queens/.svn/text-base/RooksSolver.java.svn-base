package queens;

import java.util.ArrayList;
import java.util.List;

public class RooksSolver extends Solver {
	ArrayList<Board> boards = new ArrayList<Board>();

	public List<Board> getAllSolutionsFor(int dimension)
			throws IllegalArgumentException {
		if (dimension < 0)
			throw new IllegalArgumentException("Negative dimension!");
		this.dimension=dimension;
		Board board = new Board(dimension);
		boards.add(board);
		return findSolutions(boards);
	}

	public ArrayList<Board> findSolutions(ArrayList<Board> boardComes) {
		ArrayList<Board> validBoards = generateValidBoardsInSameLevel(boardComes);
		level++;
		if (level >= dimension)
			return validBoards;
		else
			return findSolutions(((ArrayList<Board>) validBoards.clone()));
	}

	public ArrayList<Board> generateValidBoardsInSameLevel(
			ArrayList<Board> boardComes) {
		ArrayList<Board> validBoards = new ArrayList<Board>();
		for (int i = 0; i < boardComes.size(); i++)
			for (int k = 0; k < dimension; k++) {
				Board boardClone = ((Board) boardComes.get(i).clone());
				boardClone.placePiece(new Rook(), k, level);
				if (boardClone.isValid())
					validBoards.add(boardClone);
			}
		return validBoards;
	}
}
