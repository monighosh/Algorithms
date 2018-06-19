/**
 * 
 */
package algorithmProbs.general;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author 212393859
 *
 */
public class GeneralProbsTest {
	GeneralProbs gProbs = new GeneralProbs();

	@Test
	public void testClimbStairs(){
		int result = gProbs.climbStairs(8);
		
		assertEquals(34, result);
		
	}
}
