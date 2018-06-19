package ik.sorting.probs;

import org.junit.Test;

import org.junit.Assert;

public class SortingProbsTest {
	
	SortingProbs sp = new SortingProbs();

	@Test
	public void testDutchFlagSort() {
		String balls = "GBGGRBRG";
		String result = sp.dutchFlagSort(balls);
		
		Assert.assertEquals("RRGGGGBB", result);
	}
}
