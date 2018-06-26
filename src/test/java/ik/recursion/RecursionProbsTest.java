package ik.recursion;

import org.junit.Test;

public class RecursionProbsTest {

	RecursionProbs recursion = new RecursionProbs();
	
	@Test
	public void testPermute() {
		//recursion.permute("abcd", 0);
	}
	
	@Test
	public void testPrintSubSets() {
		recursion.printSubSets("abc");
	}
	
	@Test
	public void testCheckIfSumK() {
		int[] a = new int[]{10};
		boolean hasSum = recursion.checkIfSumK(a, 0);
	}
}
