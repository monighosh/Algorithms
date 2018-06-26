package ik.recursion;


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
	
	private String swap(char[] c, int i, int j) {
		char temp = c[i];
		c[i] = c[j];
		c[j] = temp;

		return new String(c);
	}
	
	public void printSubSets(String s){		
		char[] sub_so_far = new char[s.length()];
		printSubsetsHelper(s.toCharArray(), sub_so_far, 0, 0);
		
	}
	
	private void printSubsetsHelper(char[] s, char[] sub_so_far, int i, int j){
		if(i == s.length){
			printSubsets(sub_so_far , j);
			return;
		}			
		
		
		printSubsetsHelper(s, sub_so_far, i+1, j);
		sub_so_far[j] = s[i];
		printSubsetsHelper(s, sub_so_far, i+1, j+1);
		
		return;
	}

	private void printSubsets(char[] sub_so_far, int j) {
		for(char c: sub_so_far){
			if((int)c !=0)
				System.out.print(c);
			System.out.print(" ");
				
		}
			
		
	}
	
	
	/**
	 * Given an array arr of size n and a target sum k. 
	You have to determine, whether there exists a group of numbers (numbers need not to be contiguous and group can not be empty) in arr such that their sum equals to k.

	Input Format: There are two argument. First one is arr and second one is k.
	Output Format: Return a boolean denoting your answer
	 */
	
	public boolean checkIfSumK(int[] a, int k){
		int sum_so_far = 0;
		return checkIfSumKHelper( a,  k, sum_so_far, 0, false);
		
	}
	
	private boolean checkIfSumKHelper(int[] a, int k, int sum_so_far, int i, boolean oneIncluded){
		
		if(sum_so_far == k && oneIncluded) {
			return true;		}
		
		if(i == a.length)
			return false;		
		
		return (checkIfSumKHelper(a, k , sum_so_far, i+1, oneIncluded)) || (checkIfSumKHelper(a, k , sum_so_far +a[i], i+1, true));	
		
	}	

}
