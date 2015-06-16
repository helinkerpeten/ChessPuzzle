package queens;
//Helin Kerpeten S000738
import java.util.ArrayList;
import java.util.List;

public class NQueensSolver extends Solver{

	public List<Board> getAllSolutionsFor(int dimension)
			throws IllegalArgumentException {
		if (dimension < 0)
			throw new IllegalArgumentException("Negative dimension!");
		this.dimension = dimension;
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
				boardClone.placePiece(new Queen(), k, level);
				if (boardClone.isValid())
					validBoards.add(boardClone);
			}
		return validBoards;
	}

}