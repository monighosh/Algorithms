/**
 * 
 */
package algorithmProbs.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;


/**
 * @author 212393859
 *
 */
public class ArraysProbs {
	
	
	/**
	 * We have two special characters. The first character can be represented by one bit 0. The second character can be represented by two bits (10 or 11).
	   Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.	
	 * @param bits
	 * @return
	 */
	public boolean isOneBitCharacter(int[] bits) {

		int i = 0;
		boolean isOneBit = false;

		while (i < bits.length) {
			if (isValidSingleBit(bits[i])) {
				if (i == bits.length - 1) {
					isOneBit = true;
				}
				i += 1;
			}

			else if (isValidTwoBits(bits[i], bits[i + 1])) {
				if (i + 1 == bits.length - 1)
					isOneBit = false;

				i += 2;
			}

		}

		return isOneBit;

	}

	public boolean isValidSingleBit(int bit) {
		if (bit == 0)
			return true;
		else
			return false;
	}

	public boolean isValidTwoBits(int bit1, int bit2) {
		String bit1String = Integer.toString(bit1);
		String bit2String = Integer.toString(bit2);

		int doubleBit = Integer.parseInt(bit1String + bit2String);

		if (doubleBit == 10 || doubleBit == 11)
			return true;
		else
			return false;
	}
	
	
	
	/**
	 * Given numRows, generate the first numRows of Pascal's triangle.
		For example, given numRows = 5,
		Return
		[
     		[1],
    	   [1,1],
   		  [1,2,1],
  		 [1,3,3,1],
 		[1,4,6,4,1]
		]
	 * @param numRows
	 * @return
	 */
	public List<List<Integer>> generatePascalTriangle(int numRows) {
		List<List<Integer>> pascalTriangle = new ArrayList<List<Integer>>();
		for (int i = 0; i < numRows; i++) {
			List<Integer> row = new ArrayList<Integer>();
			row.add(1);

			if (i != 0) {
				List<Integer> prevRow = pascalTriangle.get(i - 1);

				for (int j = 0; j <= prevRow.size(); j++) {
					if (j + 1 < prevRow.size()) {
						int sum = prevRow.get(j) + prevRow.get(j + 1);
						row.add(sum);
					}
				}

				row.add(1);
			}

			pascalTriangle.add(row);
		}

		return pascalTriangle;
	}
	
	
	public List<Integer> pascalTriangle(int rowIndex) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		if (rowIndex < 0)
			return result;

		result.add(1);
		for (int i = 1; i <= rowIndex; i++) {
			for (int j = result.size() - 1; j >= 0; j--) {

				if (j + 1 < result.size())
					result.set(j + 1, result.get(j) + result.get(j + 1));

			}
			result.add(1);

		}
		return result;
	}
	
	/**
	 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
	Example 1:
	Input: [1,2,3]
	Output: 6
	Example 2:
	Input: [1,2,3,4]
	Output: 24
	 * @param nums
	 * @return
	 */
	
	public int maximumProduct(int[] nums) {
		int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;
        
        for(int num : nums){
            
            if(num > max3){
                max1 = max2;
                max2 = max3;
                max3 = num;
            }
            else if(num > max2){
                max1 = max2;
                max2 = num;
            }
            else if(num > max1) {
                max1 = num;
            }
            
            if(num < min3){
                min1 = min2;
                min2 = min3;
                min3 = num;
            }
            else if(num < min2){
                min1 = min2;
                min2 = num;
            }
            else if(num < min1) {
                min1 = num;
            }
        }
        
        
        return Math.max(max3*max2*max1, max3*min3*min2);
        
    }
	
	
	/**
	 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.
		Example 1:
		Input: [1,12,-5,-6,50,3], k = 4
		Output: 12.75
		Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
	 * @param nums
	 * @param k
	 * @return
	 */
	public double findMaxAverage(int[] nums, int k) {
		double maxSum = Double.NEGATIVE_INFINITY;
		double sum = 0;
		for (int i = 0; i < k; i++) {
			sum += nums[i];

		}
		maxSum = sum;
		for (int j = k; j < nums.length; j++) {
			sum = sum - nums[j - k] + nums[j];
			maxSum = (sum > maxSum) ? sum : maxSum;
		}
		return maxSum / k;
	}
	
	/**
	 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

		Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

		Example 1:
		Input: flowerbed = [1,0,0,0,1], n = 1
		Output: True
		Example 2:
		Input: flowerbed = [1,0,0,0,1], n = 2
		Output: False
	 * @param flowerbed
	 * @param n
	 * @return
	 */
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int flowersCount = 0;

		for (int i = 0; i < flowerbed.length; i++) {
			if (flowerbed[i] != 1) {
				if (isValidSpot(i, flowerbed)) {
					flowersCount += 1;
					flowerbed[i] = 1;
				}
			}

			if (n == 0 || flowersCount == n)
				return true;
		}
		return false;
	}

	private boolean isValidSpot(int index, int[] flowerbed) {

		if ((index == 0 || flowerbed[index - 1] == 0)
				&& (index == flowerbed.length - 1 || flowerbed[index + 1] == 0))
			return true;
		else
			return false;

	}
	
	public int[][] matrixReshape(int[][] nums, int r, int c) {
		int[][] reshapedMatrix = new int[r][c];
		int originalRowLength = nums.length;
		int originalColLength = nums[0].length;
		int rowCount = 0;
		int colCount = 0;

		if (r * c != originalRowLength * originalColLength)
			return nums;

		for (int row = 0; row < originalRowLength; row++) {
			for (int col = 0; col < originalColLength; col++) {

				reshapedMatrix[rowCount][colCount] = nums[row][col];
				colCount++;
				if (colCount == c) {
					rowCount++;
					colCount = 0;
				}

			}
		}

		return reshapedMatrix;

	}
	
	
    /**
     * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn)
     *     which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

		Example 1:
		Input: [1,4,3,2]

		Output: 4
		Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
     **/
	
	public int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        
        for(int i =0; i<=nums.length-2; i+=2){
            sum = sum + Math.min(nums[i],nums[i+1]);
        }
        
        return sum;
        
    }
	
	/**
	 * Given an array of integers nums, write a method that returns the "pivot" index of this array.
		We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
		If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.

		Example 1:
		Input: 
		nums = [1, 7, 3, 6, 5, 6]
		Output: 3
		Explanation: 
		The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
		Also, 3 is the first index where this occurs.
		Example 2:
		Input: 
		nums = [1, 2, 3]
		Output: -1
		Explanation: 
		There is no index that satisfies the conditions in the problem statement.
	 * @param nums
	 * @return
	 */
	public int pivotIndex(int[] nums) {
		int tillSum = 0;
		int remainingSum = 0;
		int totalSum = 0;
		
		for (int num : nums) {
			totalSum += num;
		}

		for (int i = 0; i < nums.length; i++) {
			remainingSum = totalSum - nums[i] - tillSum;

			if (tillSum == remainingSum)
				return i;

			tillSum += nums[i];
		}
		return -1;
	}
	
	
	public boolean checkPossibility(int[] nums) {

		int modifyElementsCount = 0;		

		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] > nums[i]) {
				modifyElementsCount++;

				if (i - 2 < 0 || nums[i - 2] < nums[i])
					nums[i - 1] = nums[i];
				else
					nums[i] = nums[i - 1];
			}

			if (modifyElementsCount > 1)
				return false;

		}

		return true;
	}

/**
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.

Example 1:
Input: [3, 1, 4, 1, 5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
Example 2:
Input:[1, 2, 3, 4, 5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
Example 3:
Input: [1, 3, 1, 5, 4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).
Note:
The pairs (i, j) and (j, i) count as the same pair.
The length of the array won't exceed 10,000.
All the integers in the given input belong to the range: [-1e7, 1e7].   
 */
  
	public int findPairs(int[] nums, int k) {
		if (k < 0)
			return 0;

		HashMap<Integer, Integer> noFrequencyMap = new HashMap<Integer, Integer>();
		Set<List<Integer>> uniquePair = new HashSet<List<Integer>>();
		int uniquePairCount = 0;

		for (int no : nums) {
			int frequency = 0;
			if (noFrequencyMap.containsKey(no)) {
				frequency = noFrequencyMap.get(no);
			}
			noFrequencyMap.put(no, frequency += 1);
		}

		for (int no : nums) {
			int value = no + k;
			List<Integer> pairs = new ArrayList<Integer>();
			pairs.add(no);
			pairs.add(value);

			if (k == 0) {
				int frequency = noFrequencyMap.get(no);
				if (frequency > 1 && !uniquePair.contains(pairs)) {
					uniquePairCount++;
					uniquePair.add(pairs);
					noFrequencyMap.put(no, frequency -= 1);

				}
			} else if (noFrequencyMap.containsKey(value) && !uniquePair.contains(pairs)) {
				uniquePair.add(pairs);
				uniquePairCount++;
			}

		}

		return uniquePairCount;

	}
	
	/**
	 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

	   Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

		Example 1:
		Input: [1, 2, 2, 3, 1]
		Output: 2
		Explanation: 
		The input array has a degree of 2 because both elements 1 and 2 appear twice.
		Of the subarrays that have the same degree:
		[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
		The shortest length is 2. So return 2.
		Example 2:
		Input: [1,2,2,3,1,4,2]
		Output: 6
	 * @param nums
	 * @return
	 */
	public int findShortestSubArray(int[] nums) {
		int maxCount = 0;
		// Find degree of the array
		Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		Map<Integer, List<Integer>> indexMap = new HashMap<Integer, List<Integer>>();
		int minLength = Integer.MAX_VALUE;
		List<Integer> processNos = new ArrayList<Integer>();
		List<Integer> indexList = null;

		for (int i = 0; i < nums.length; i++) {
			int count = 0;
			if (countMap.containsKey(nums[i])) {
				count = countMap.get(nums[i]);
			}
			countMap.put(nums[i], count += 1);

			if (indexMap.containsKey(nums[i])) {
				indexList = indexMap.get(nums[i]);
			} else {
				indexList = new ArrayList<Integer>();
			}

			indexList.add(i);
			indexMap.put(nums[i], indexList);
		}

		for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
			int key = entry.getKey();
			if (entry.getValue() == maxCount) {
				processNos.add(key);
			} else if (entry.getValue() > maxCount) {
				maxCount = entry.getValue();

				processNos.clear();

				processNos.add(0, key);
			}
		}

		for (int no : processNos) {
			List<Integer> indexes = indexMap.get(no);
			int length = indexes.get(indexes.size() - 1) - indexes.get(0) + 1;

			minLength = (length < minLength) ? length : minLength;
		}

		return minLength;
        
    }
	
	/**
	 * Given m arrays, and each array is sorted in ascending order. Now you can pick up two integers from two different arrays (each array picks one) and calculate the distance. We define the distance between two integers a and b to be their absolute difference |a-b|. Your task is to find the maximum distance.

		Example 1:
		Input: 
		[[1,2,3],
 		[4,5],
 		[1,2,3]]
		Output: 4
		Explanation: 
		One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5
		in the second array.
	 */
	
	public int findMaximumDistance(List<List<Integer>> arrays){
		int maxDistance = 0;
		int minElement = Integer.MAX_VALUE;
		int maxElement = Integer.MIN_VALUE;
		int maxArrayNo = -1;

		for (int i = 0; i < arrays.size(); i++) {
			List<Integer> array = arrays.get(i);

			if (array.get(array.size() - 1) > maxElement) {
				maxElement = array.get(array.size() - 1);
				maxArrayNo = i;
			}

		}

		for (int i = 0; i < arrays.size(); i++) {
			List<Integer> array = arrays.get(i);

			if (i != maxArrayNo) {
				minElement = (array.get(0) < minElement) ? array.get(0)
						: minElement;
			}

		}

		maxDistance = Math.abs(maxElement) - Math.abs(minElement);

		return maxDistance;
	}
	
	/**
	 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

		For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

		Given word1 = "coding", word2 = "practice", return 3.
		Given word1 = "makes", word2 = "coding", return 1.
	 */
	
	public int findShortestDistance(List<String> words, String word1,
			String word2) {
		int minDistance = Integer.MAX_VALUE;
		int word1Index = -1;
		int word2Index = -1;

		for (int i = 0; i < words.size(); i++) {
			int distance = Integer.MAX_VALUE;
			if (words.get(i).equalsIgnoreCase(word1)) {
				word1Index = i;
			} else if (words.get(i).equalsIgnoreCase(word2)) {
				word2Index = i;
			}

			if (word2Index != -1 && word1Index != -1)
				distance = Math.abs(word1Index - word2Index);

			minDistance = (distance < minDistance) ? distance : minDistance;
		}

		return minDistance;

	}
	
	
	/**
	 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

		For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
		the contiguous subarray [4,-1,2,1] has the largest sum = 6.
		
		Note: Kandane's algorithm
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
		int max_so_far = Integer.MIN_VALUE;
		int max_ending_here = 0;

		for (int num : nums) {
			max_ending_here += num;
			max_so_far = (max_so_far < max_ending_here) ? max_ending_here : max_so_far;

			if (max_ending_here < 0) {
				max_ending_here = 0;
			}

		}

		return max_so_far;
	}	
	
	/**
	 * Rotate an array of n elements to the right by k steps.

	For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
	 * @param nums
	 * @param k
	 */
	public void rotateArray(int[] nums, int k) {

		int size = nums.length;

		if (size == 1)
			return;

		int[] a = new int[size * 2];
		int copyIndex = size;
		for (int i = 0; i < size; i++) {
			a[i] = nums[i];
			a[copyIndex] = nums[i];
			copyIndex++;
		}
		int startIndex = size;

		int shiftIndex = k % size;
		int rotateStartIndex = startIndex - shiftIndex;

		if (shiftIndex == 0)
			return;
		for (int i = 0; i < size; i++) {
			nums[i] = a[rotateStartIndex];
			rotateStartIndex++;
		}

	}
	
	/**
	 * Say you have an array for which the ith element is the price of a given stock on day i.

	Design an algorithm to find the maximum profit. You may complete as many transactions as you like
    (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions
    at the same time (ie, you must sell the stock before you buy again).   
    
	 */
	
	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		for (int i = 1; i < prices.length; i++) {

			if (prices[i] > prices[i - 1]) {
				maxProfit += prices[i] - prices[i - 1];
			}
		}

		return maxProfit;

	}
	
	
	public int minCostClimbingStairs(int[] cost) {

     
		  int f1 = 0, f2 = 0;
	        for (int i = cost.length - 1; i >= 0; --i) {
	            int f0 = cost[i] + Math.min(f1, f2);
	            f2 = f1;
	            f1 = f0;
	        }
	        return Math.min(f1, f2);
     
 }
	
	/**
	 * Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.

		Example 1:
		Input:
		[[1,1,1],
 		[1,0,1],
 		[1,1,1]]
		Output:
		[[0, 0, 0],
 		[0, 0, 0],
 		[0, 0, 0]]
		Explanation:
		For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
		For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
		For the point (1,1): floor(8/9) = floor(0.88888889) = 0
	 * 
	 */
	public int[][] imageSmoother(int[][] M) {
		int rows = M.length;
		int cols = M[0].length;
		int[][] result = new int[rows][cols];

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				int sum = M[row][col];

				List<ArrayList<Integer>> verticalCells = getVerticalCells(row, col, rows);
				List<ArrayList<Integer>> horizontalCells = getHorizontalCells(row, col, cols);
				List<ArrayList<Integer>> diagonalCells = getDiagonalCells(row, col, rows, cols);

				for (List<Integer> pair : verticalCells) {
					sum += M[pair.get(0)][pair.get(1)];
				}

				for (List<Integer> pair : horizontalCells) {
					sum += M[pair.get(0)][pair.get(1)];
				}

				for (List<Integer> pair : diagonalCells) {
					sum += M[pair.get(0)][pair.get(1)];
				}

				int count = 1 + verticalCells.size() + horizontalCells.size() + diagonalCells.size();

				result[row][col] = sum / count;

			}
		}

		return result;

	}

	// (x-1,y)(x+1,y)
	private List<ArrayList<Integer>> getVerticalCells(int x, int y, int rows) {
		List<ArrayList<Integer>> verticalCells = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> pair;
		if (x - 1 >= 0) {
			pair = new ArrayList<Integer>();
			pair.add(x - 1);
			pair.add(y);
			verticalCells.add(pair);
		}
		if (x + 1 < rows) {
			pair = new ArrayList<Integer>();
			pair.add(x + 1);
			pair.add(y);
			verticalCells.add(pair);
		}

		return verticalCells;
	}

	// (x, y-1) (x, y+1)
	private List<ArrayList<Integer>> getHorizontalCells(int x, int y, int cols) {
		List<ArrayList<Integer>> horizontalCells = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> pair;
		if (y - 1 >= 0) {
			pair = new ArrayList<Integer>();
			pair.add(x);
			pair.add(y - 1);
			horizontalCells.add(pair);
		}
		if (y + 1 < cols) {
			pair = new ArrayList<Integer>();
			pair.add(x);
			pair.add(y + 1);
			horizontalCells.add(pair);
		}

		return horizontalCells;
	}

	private List<ArrayList<Integer>> getDiagonalCells(int x, int y, int rows,
			int cols) {
		List<ArrayList<Integer>> diagonalCells = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> pair;
		if (x - 1 >= 0) {

			if (y - 1 >= 0) {
				pair = new ArrayList<Integer>();
				pair.add(x - 1);
				pair.add(y - 1);
				diagonalCells.add(pair);
			}
			if (y + 1 < cols) {
				pair = new ArrayList<Integer>();
				pair.add(x - 1);
				pair.add(y + 1);
				diagonalCells.add(pair);
			}

		}
		if (x + 1 < rows) {

			if (y - 1 >= 0) {
				pair = new ArrayList<Integer>();
				pair.add(x + 1);
				pair.add(y - 1);
				diagonalCells.add(pair);
			}
			if (y + 1 < cols) {
				pair = new ArrayList<Integer>();
				pair.add(x + 1);
				pair.add(y + 1);
				diagonalCells.add(pair);
			}
		}

		return diagonalCells;
	}
	
//	public int maxAreaOfIsland(int[][] grid) {
//		int rows = grid.length;
//		int cols = grid[0].length;
//		int maxArea = 0;
//		//List<ArrayList<Integer>> processed = new ArrayList<ArrayList<Integer>>();
//		boolean[][] processed = new boolean[rows][cols]; 
//
//		for (int row = 0; row < rows; row++) {
//			for (int col = 0; col < cols; col++) {
//
//				Stack<ArrayList<Integer>> toProcess = new Stack<ArrayList<Integer>>();
//
//				int sum = 0;
//
//				ArrayList<Integer> corodinates = new ArrayList<Integer>();
//				corodinates.add(row);
//				corodinates.add(col);
//
//				if (processed[row][col])
//					continue;
//
//				if (grid[row][col] == 1) {
//
//					toProcess.push(corodinates);
//
//				}
//
//				while (toProcess.size() > 0) {
//					ArrayList<Integer> pair = toProcess.pop();
//					if (grid[pair.get(0)][pair.get(1)] == 1) {
//						//sum += 1;
//						List<ArrayList<Integer>> verticalCells = getVerticalCells(pair.get(0), pair.get(1), rows);
//						List<ArrayList<Integer>> horizontalCells = getHorizontalCells(pair.get(0), pair.get(1), cols);
//
////						if (verticalCells.size() < 2 || horizontalCells.size() < 2)
////							break;
//
//						for (ArrayList<Integer> vPair : verticalCells) {
//							if (grid[vPair.get(0)][vPair.get(1)] == 1 && !processed.contains(vPair) && !toProcess.contains(vPair)) {
//								toProcess.push(vPair);
//								
//							}
//						}
//
//						for (ArrayList<Integer> hPair : horizontalCells) {
//							if (grid[hPair.get(0)][hPair.get(1)] == 1 && !processed.contains(hPair) && !toProcess.contains(hPair)) {
//								toProcess.push(hPair);
//								
//							}
//						}
//
//						sum += 1;
//						processed.add(pair);
//					}
//				}
//
//				maxArea = (sum > maxArea) ? sum : maxArea;
//
//			}
//
//		}
//
//		return maxArea;
//	}
	
	/**
	 * Given two arrays, write a function to compute their intersection.

		Example:
		Given nums1 = [1, 4, 2, 2], nums2 = [2, 4, 2], return [2, 4, 2].
		Note:
			Each element in the result should appear as many times as it shows in both arrays.
			The result can be in any order.
		Follow up:
			What if the given array is already sorted? How would you optimize your algorithm?
			What if nums1's size is small compared to nums2's size? Which algorithm is better?
			What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
	 
	
	 */
	
	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Integer> resultList = new ArrayList<Integer>();

		for (int num : nums1) {
			int value = 0;
			if (map.containsKey(num)) {
				value = map.get(num);
			}

			map.put(num, value += 1);
		}

		for (int num : nums2) {
			if (map.containsKey(num)) {
				int value = map.get(num);
				if (value > 0) {
					resultList.add(num);
					map.put(num, value -= 1);

				}
			}
		}

		int[] result = new int[resultList.size()];
		for (int i = 0; i < resultList.size(); i++) {
			result[i] = resultList.get(i);
		}

		return result;
		
		
	}
	
	
	/**
	 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

	Solve it without division and in O(n).

	For example, given [1,2,3,4], return [24,12,8,6].

	Follow up:Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
	 */
	
	public int[] productArray(int nums[])
    {
		   int n = nums.length;
	        int[] prod = new int[n];
	        prod[0] = 1;
	        int temp =1;
	        for(int i=0; i<n ;i++){
	            prod[i] = temp;
	            temp *= nums[i];
	        }
	        
	        temp =1;
	        for(int i=n-1; i>=0;i--){
	            prod[i] *= temp;
	            temp *= nums[i];
	        }
	        
	        return prod;
    }
	
	
	/**
	 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.

Flyod's hare tortoise cycle detection algorithm
	 */
    
	public int findDuplicate(int[] nums) {
        // Find the intersection point of the two runners.
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = slow;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }
    

}
