/**
 * 
 */
package algorithmProbs.recursion;

/**
 * @author 212393859
 *
 */
public class RecursionProbs {
	
	
/**
 * Given an array of integers, write a recursive function thats adds sum of all the previous nos to each index of the array
 * eg input: 1,2,3,4,5,6  output: 1,3,6,10,15,21
 */

	public void computeSum(int[] a) {
		int length = a.length;
		computeSumHelper(a, length - 1);
	}

	private int computeSumHelper(int[] a, int i) {

		if (i == 0)
			return a[i];

		int sum = a[i] + computeSumHelper(a, i - 1);
		a[i] = sum;
		
		return sum;
	}
}
