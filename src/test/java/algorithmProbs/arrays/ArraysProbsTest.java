/**
 * 
 */
package algorithmProbs.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author 212393859
 *
 */
public class ArraysProbsTest {	
	
	public ArraysProbs arrayProbs = new ArraysProbs();	

	@Test
	public void testIsOneBitCharacter_oneBit() {
		int[] input = {1, 0, 0};
		ArraysProbs arrayProbs = new ArraysProbs();
		boolean result = arrayProbs.isOneBitCharacter(input);
		
		Assert.assertEquals(true, result);
		
	}
	
	@Test
	public void testIsOneBitCharacter_twoBits() {
		int[] input = {1, 1, 1, 0};//{0,1,1,0,0,0};//{1,1,1,1,0};
		ArraysProbs arrayProbs = new ArraysProbs();
		boolean result = arrayProbs.isOneBitCharacter(input);
		Assert.assertEquals(false, result);
		
	}
	
	@Test	
	public void testGeneratePascalTriangle() {
		ArraysProbs arrayProbs = new ArraysProbs();
		List<List<Integer>> pascalTriangle = arrayProbs.generatePascalTriangle(5);
		
		System.out.println("Pascal Triangle" + pascalTriangle);
	}
	
	@Test	
	public void testGeneratePascalTriangle_Optimized() {
		ArraysProbs arrayProbs = new ArraysProbs();
		List<Integer> pascalTriangle = arrayProbs.pascalTriangle(5);
		
		System.out.println("Pascal Triangle" + pascalTriangle);
	}
	
	@Test	
	public void testMaximumProduct() {
		ArraysProbs arrayProbs = new ArraysProbs();
		int[] input = {-4,-3,-2,-1,60};
		int product = arrayProbs.maximumProduct(input);
		
		Assert.assertEquals(720, product);
	}
	
	@Test	
	public void testFindMaxAverage() {
		ArraysProbs arrayProbs = new ArraysProbs();
		int[] input = {1,12,-5,-6,50,3};
		//int[] input = {-1};
		double product = arrayProbs.findMaxAverage(input,4);
		
		Assert.assertEquals(12.75, product,0);
	}
	
	@Test	
	public void testCanPlaceFlowers() {
		ArraysProbs arrayProbs = new ArraysProbs();		
		int[] input = {1,0,0,0,1,0,0};
		
		boolean canPlaceFlowers = arrayProbs.canPlaceFlowers(input,2);
		
		Assert.assertEquals(true, canPlaceFlowers);
		
		
	}
	
	@Test	
	public void testMatrixReshape() {
		ArraysProbs arrayProbs = new ArraysProbs();		
		int[][] input = {{1,2},{3,4},{5,6}};
		
		int[][] reshapedMatrix = arrayProbs.matrixReshape(input,2,4);	
		
	}
	
	@Test	
	public void testArrayPairSum() {
		ArraysProbs arrayProbs = new ArraysProbs();		
		int[] input = {4,5,2,3,8,10,1,20};
		
		int maxSum = arrayProbs.arrayPairSum(input);
		
		Assert.assertEquals(19, maxSum);		
	}
	
	@Test	
	public void testPivotIndex() {
		ArraysProbs arrayProbs = new ArraysProbs();		
		int[] input = {1, 7, 3, 6, 5, 6};
		
		int index = arrayProbs.pivotIndex(input);		
		Assert.assertEquals(3, index);		
	}
	
	
	@Test	
	public void testCheckPossibility() {
		ArraysProbs arrayProbs = new ArraysProbs();		
		
		int[] input = {-1,4,2,3};
		
		boolean result = arrayProbs.checkPossibility(input);		
		Assert.assertEquals(true, result);		
	}
	
	@Test	
	public void testFindPairs() {
		ArraysProbs arrayProbs = new ArraysProbs();		
		int[] input = {3,1,4,1,5};
		
		
		
		int pairCount = arrayProbs.findPairs(input,2);		
		Assert.assertEquals(2, pairCount);		
	}
	
	@Test	
	public void testFindShortestSubArray() {
		ArraysProbs arrayProbs = new ArraysProbs();		
		
		int[] input = {1,2,2,3,1,4,2};
		
		
		int length = arrayProbs.findShortestSubArray(input);		
		Assert.assertEquals(6, length);		
	}
	
	@Test	
	public void testFindMaximumDistance() {
		ArraysProbs arrayProbs = new ArraysProbs();		
		List<List<Integer>> arrays = new ArrayList<List<Integer>>();
		List<Integer> array1 = new ArrayList<Integer>(0);
		array1.add(1);
		array1.add(2);
		array1.add(3);
		List<Integer> array2 = new ArrayList<Integer>(0);
		array2.add(4);
		array2.add(5);
		List<Integer> array3 = new ArrayList<Integer>(0);
		array3.add(1);
		array3.add(2);
		array3.add(3);
		arrays.add(array1);
		arrays.add(array2);
		arrays.add(array3);
		
		int length = arrayProbs.findMaximumDistance(arrays);		
		Assert.assertEquals(4, length);		
	}
	
	@Test	
	public void testFindShortestDistance() {
		ArraysProbs arrayProbs = new ArraysProbs();		
		
		List<String> words = Arrays.asList("practice", "makes", "perfect", "coding", "makes");
		String word1 = "makes"; String word2 = "coding";
		
		
		int distance = arrayProbs.findShortestDistance(words, word1, word2);		
		Assert.assertEquals(1, distance);		
	}
	
	@Test	
	public void testMaxSubArray() {
		ArraysProbs arrayProbs = new ArraysProbs();		
		
		int[] input = {-2,1,-3,4,-1,2,1,-5,4};
		int sum = arrayProbs.maxSubArray(input);		
		Assert.assertEquals(6, sum);		
	}
	
	@Test	
	public void testRotateArray() {
		ArraysProbs arrayProbs = new ArraysProbs();		
		
		int[] input = {1,2,3,4,5,6,7};
		arrayProbs.rotateArray(input,3);		
		System.out.println("Rotated array: " + Arrays.toString(input));		
	}
	
	@Test	
	public void testMaxProfit() {
		ArraysProbs arrayProbs = new ArraysProbs();		
		
		int[] input = {7,8,1,5,6,2,10};
		int profit = arrayProbs.maxProfit(input);		
		Assert.assertEquals(14, profit);		
	}
	
	@Test	
	public void testMinCostClimbingStairs() {
		ArraysProbs arrayProbs = new ArraysProbs();		
		
		int[] input = {0,2,2,1};
		int minCost = arrayProbs.minCostClimbingStairs(input);		
		Assert.assertEquals(2, minCost);		
	}
	
	@Test	
	public void testImageSmoother() {
		ArraysProbs arrayProbs = new ArraysProbs();		
		
		int[][] input = {{1,1,1}, {1,0,1}, {1,1,1}};
		int[][] result = arrayProbs.imageSmoother(input);		
		System.out.println(Arrays.asList(result));		
	}
	
	@Test	
	public void testMaxAreaOfIsland() {
		ArraysProbs arrayProbs = new ArraysProbs();		
		
//		int[][] input = {{0,0,1,0,0,0,0,1,0,0,0,0,0}, {0,0,0,0,0,0,0,1,1,1,0,0,0}, {0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0}, {0,1,0,0,1,1,0,0,1,1,1,0,0},
//						{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
		
		int[][] input = {{0,1,1,1,0},{0,1,1,0,0}};
		
		
		//int area= arrayProbs.maxAreaOfIsland(input);		
		//Assert.assertEquals(6, area);
	}
	
	@Test	
	public void testIntersect() {
		ArraysProbs arrayProbs = new ArraysProbs();		
		
		int[] input1 = {5,3,2,4,1,2};
		int[] input2 = {2,5,4,2,10};
		int[] result = arrayProbs.intersect(input1,input2);		
		Assert.assertEquals(4, result);		
	}
	
	@Test	
	public void testProductArray() {
		ArraysProbs arrayProbs = new ArraysProbs();		
		
		int[] input1 = {1,2,3,4};
		
		int[] result = arrayProbs.productArray(input1);		
		Assert.assertEquals(4, result);		
	}
	
	
	@Test
	public void testFindDuplicates(){
		int[] input = {1,4,6,6,6,2,3};
		arrayProbs.findDuplicate(input);
	}
}
