package ik.recursion;

import java.util.Collections;
import java.util.PriorityQueue;

public class RecursionProbs {
	
	/**
	 * Print Permutations of a given string
	 */
	
	public void permute(String s , int i){
		String swapped;
		
		if(i == s.length()-1){
			System.out.println(s);
			return;
		}
		
		for(int j =i; j< s.length(); j++){
			swapped = swap(s.toCharArray(), i, j);
			
			permute(swapped, i+1);			
			
			swapped = swap(swapped.toCharArray(),i,j);
			s = swapped;
		}
		
		
	}
	
	private String swap(char[] c, int i, int j){
		char temp = c[i];
		c[i] = c[j];
		c[j] = temp;
		
		return new String(c);
	}
	
	
	public void printSubSets(String s){
		
		
	}
	
	private void printSubsetsHelper(char[] s, char[] sub_so_far, int i, int j){
		
		
		printSubsetsHelper(s, sub_so_far, i+1, j);
		sub_so_far[i] = s[i];
		printSubsetsHelper(s, sub_so_far, i+1, j+1);
		
	}
	
//	public int[] maxSlidingWindow(int[] nums, int k) {
//	    if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
//	      return new int[0];
//	    }
//
//	    int[] result = new int[nums.length - k + 1];
//	    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
//	    for (int i = 0; i < nums.length; ++i) {
//	      maxHeap.add(nums[i]);
//	      if (i >= k - 1) {
//	        result[i - k + 1] = maxHeap.peek();
//	        maxHeap.remove(nums[i - k + 1]);
//	      }
//	    }
//
//	    return result;
//	  }
	
	
	

}
