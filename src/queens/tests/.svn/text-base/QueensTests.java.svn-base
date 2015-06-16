//Helin Kerpeten S000738
package queens.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import queens.Board;
import queens.Queen;

public class QueensTests extends PieceTests {

	@Test(expected = IllegalArgumentException.class)
	public void testQueensCanAttackNegative() {
		Queen queen = new Queen();
		Board board = new Board(8);
		board.placePiece(queen, 3, 4);
		queen.canAttack(3, -7);
	}

	@Test
	public void testQueensCanAttackVertical() {
		Queen queen = new Queen();
		Board board = new Board(8);
		board.placePiece(queen, 3, 4);
		assertEquals(true, queen.canAttack(3, 7));
	}

	@Test
	public void testQueensCanAttackHorizontal() {
		Queen queen = new Queen();
		Board board = new Board(8);
		board.placePiece(queen, 3, 4);
		assertEquals(true, queen.canAttack(2, 4));
	
	}

	@Test
	public void testQueensCanAttackDiagonal() {
		Queen queen = new Queen();
		Board board = new Board(8);
		board.placePiece(queen, 1, 2);
		assertEquals(true, queen.canAttack(2, 3));
	}

	@Test
	public void testEquals1() {
		Queen queen1 = new Queen();
		Queen queen2 = new Queen();
		queen1.setPosition(1, 2);
		queen2.setPosition(2, 3);
		assertEquals(false, queen1.equals(queen2));
	}

	@Test
	public void testEquals2() {
		Queen queen1 = new Queen();
		Queen queen2 = new Queen();
		queen1.setPosition(1, 2);
		queen2.setPosition(1, 2);
		assertEquals(true, queen1.equals(queen2));
	}

}
