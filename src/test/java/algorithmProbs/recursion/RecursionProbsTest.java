/**
 * 
 */
package algorithmProbs.recursion;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author 212393859
 *
 */
public class RecursionProbsTest {
	
	RecursionProbs rProbs = new RecursionProbs();
	
	@Test
	public void testComputeSum(){
		int[] a = {1,2,3,4,5,6};
		rProbs.computeSum(a);
		
		assertEquals(1,a[0]);
		assertEquals(3,a[1]);
		assertEquals(6,a[2]);
		assertEquals(10,a[3]);
		assertEquals(15,a[4]);
		assertEquals(21,a[5]);		
	}

}
