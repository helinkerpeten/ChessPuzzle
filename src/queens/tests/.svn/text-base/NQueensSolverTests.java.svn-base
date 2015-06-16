//Helin Kerpeten S000738
package queens.tests;

import org.junit.Test;

import queens.NQueensSolver;
import static org.junit.Assert.assertEquals;

public class NQueensSolverTests {

	@Test(expected = IllegalArgumentException.class)
	public void testGetAllSolutionsForNegativeDimension() {
		NQueensSolver twoQueensSolver = new NQueensSolver();
		twoQueensSolver.getAllSolutionsFor(-3);
	}

	@Test
	public void testGetAllSolutionsFor1Dimension() {
		NQueensSolver twoQueensSolver = new NQueensSolver();
		assertEquals(1, twoQueensSolver.getAllSolutionsFor(1).size());
	}

	@Test
	public void testGetAllSolutionsFor2Dimension() {
		NQueensSolver twoQueensSolver = new NQueensSolver();
		assertEquals(0, twoQueensSolver.getAllSolutionsFor(2).size());
	}

	@Test
	public void testGetAllSolutionsFor3Dimension() {
		NQueensSolver twoQueensSolver = new NQueensSolver();
		assertEquals(0, twoQueensSolver.getAllSolutionsFor(3).size());
	}

	@Test
	public void testGetAllSolutionsFor6Dimension() {
		NQueensSolver twoQueensSolver = new NQueensSolver();
		assertEquals(4, twoQueensSolver.getAllSolutionsFor(6).size());
	}

}
