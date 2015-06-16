//Helin Kerpeten S000738
package queens.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import queens.Board;
import queens.Piece;
import queens.Queen;

public class BoardTests {

	@Test(expected = IllegalArgumentException.class)
	public void testCreateBoardWithNegativeDimension() {
		Board board = new Board(-8);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testUnBoundedPlace() {
		Board board = new Board(8);
		Queen queen = new Queen();
		board.placePiece(queen, 9, 6);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConflictPlace() {
		Board board = new Board(8);
		Queen queen1 = new Queen();
		Queen queen2 = new Queen();
		board.placePiece(queen1, 3, 4);
		board.placePiece(queen2, 3, 4);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNegativePlace() {
		Board board = new Board(8);
		Queen queen = new Queen();
		board.placePiece(queen, -3, 6);
	}

	@Test
	public void testGetNullPiece() {
		Board board = new Board(8);
		assertEquals(null, board.getPieceAt(2, 3));
	}

	@Test
	public void testGetPiece() {
		Board board = new Board(8);
		Piece queen = new Queen();
		board.placePiece(queen, 4, 5);
		assertTrue( board.getPieceAt(4, 5).equals(queen));
	}

	@Test
	public void testIsValidWithEmptyBoard() {
		Board board = new Board(8);
		assertEquals(true, board.isValid());
	}

	@Test
	public void testIsValid1() {
		Board board = new Board(8);
		Queen queen1 = new Queen();
		Queen queen2 = new Queen();
		board.placePiece(queen1, 2, 3);
		board.placePiece(queen2, 2, 7);
			assertEquals(false, board.isValid());
	}

	@Test
	public void testIsValid2() {
		Board board = new Board(8);
		Queen queen1 = new Queen();
		Queen queen2 = new Queen();
		board.placePiece(queen1, 3, 3);
		board.placePiece(queen2, 2, 2);
		assertEquals(false, board.isValid());
	}

	@Test
	public void testGetPiecesInEmptyBoard() {
		Board board = new Board(8);
		assertEquals(0, board.getPieces().size());
	}

	@Test
	public void testGetPieces() {
		Board board = new Board(8);
		Queen queen1 = new Queen();
		Queen queen2 = new Queen();
		board.placePiece(queen1, 1, 3);
		board.placePiece(queen2, 2, 2);
		assertEquals(2, board.getPieces().size());
	}
	@Test
	public void testGetThirdPieceInPieces() {
		Board board = new Board(8);
		Queen queen1 = new Queen();
		Queen queen2 = new Queen();
		Queen queen3 = new Queen();
		Queen queen4 = new Queen();
		board.placePiece(queen1, 1, 3);
		board.placePiece(queen2, 2, 2);
		board.placePiece(queen3, 6, 4);
		board.placePiece(queen4, 5, 7);
		assertEquals(queen3, board.getPieces().get(2));
	}
	
	@Test
	public void testEquals() {
		Board board1 = new Board(8);
		Board board2 = new Board(2);
		assertEquals(false, board1.equals(board2));
	}
	@Test
	public void testEquals2() {
		Board board1 = new Board(8);
		Board board2 = new Board(8);
		board1.placePiece(new Queen(), 1, 2);
		board2.placePiece(new Queen(), 3, 4);
		assertEquals(false, board1.equals(board2));
	}
	@Test
	public void testGetDimension() {
		Board board = new Board(8);
		assertEquals(8, board.getDimension());
	}
}
