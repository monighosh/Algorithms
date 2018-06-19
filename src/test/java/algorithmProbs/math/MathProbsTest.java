/**
 * 
 */
package algorithmProbs.math;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author 212393859
 *
 */
public class MathProbsTest {

	@Test
	public void testCountPrimes(){
		MathProbs mProbs = new MathProbs();
		
		int result = mProbs.countPrimes(2);
		System.out.println("Result : " + result);
	}
	
	@Test
	public void testReverse(){
		MathProbs mProbs = new MathProbs();
		
		int result = mProbs.reverse(1534236469);
		System.out.println("Result : " + result);
	}
	
	@Test
	public void testIsHappy(){
		MathProbs mProbs = new MathProbs();
		
		boolean result = mProbs.isHappy(19);
		assertEquals(true, result);
	}
	
	@Test
	public void testAddDigits(){
		MathProbs mProbs = new MathProbs();
		
		int result = mProbs.addDigits(38);
		assertEquals(2, result);
	}
	
	@Test
	public void testAddDigits_efficient(){
		MathProbs mProbs = new MathProbs();
		
		int result = mProbs.addDigits_efficient(38);
		assertEquals(2, result);
	}
	
	@Test
	public void testCalculate(){
		MathProbs mProbs = new MathProbs();
		
		int result = mProbs.calculate("3+2*2");
		assertEquals(2, result);
	}
}
