//Helin Kerpeten S000738
package queens.tests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import queens.Board;
import queens.Piece;
import queens.Queen;

public abstract class PieceTests {

	@Test(expected = IllegalArgumentException.class)
	public void testPieceCanAttackNegative() {
		Piece piece = new Queen();
		Board board = new Board(8);
		board.placePiece(piece, 3, 4);
		piece.canAttack(3, -7);
	}

	@Test
	public void testPieceCanAttackVertical() {
		Piece piece = new Queen();
		Board board = new Board(8);
		board.placePiece(piece, 3, 4);
		assertEquals(true, piece.canAttack(3, 7));
	}

	@Test
	public void testPieceCanAttackHorizontal() {
		Piece piece = new Queen();
		Board board = new Board(8);
		board.placePiece(piece, 3, 4);
		assertEquals(true, piece.canAttack(2, 4));
	}

	@Test
	public void testPieceCanAttackDiagonal() {
		Piece piece = new Queen();
		Board board = new Board(8);
		board.placePiece(piece, 1, 2);
		assertEquals(true, piece.canAttack(2, 3));
	}
	@Test
	public void testPieceCanAttackDiagonal2() {
		Piece piece = new Queen();
		Board board = new Board(8);
		board.placePiece(piece, 2, 2);
		assertEquals(true, piece.canAttack(3, 3));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetPositionNegative() {
		Piece piece = new Queen();
		piece.setPosition(2, -3);
	}

	@Test
	public void testXWithSetPosition() {
		Piece piece = new Queen();
		piece.setPosition(2, 3);
		assertEquals(2, piece.getX());
	}

	@Test
	public void testYWithSetPosition() {
		Piece piece = new Queen();
		piece.setPosition(2, 3);
		assertEquals(2, piece.getX());
	}

}
