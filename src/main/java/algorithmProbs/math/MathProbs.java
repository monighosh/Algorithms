/**
 * 
 */
package algorithmProbs.math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @author 212393859
 *
 */
public class MathProbs {

	/**
	 *
	Count the number of prime numbers less than a non-negative number, n.	 */
	
	public int countPrimes(int n) {
		int count = 0;
		if (n <= 2)
			return count;
		else
			count += 1;

		for (int i = 3; i < n; i += 2) {
			int divCount = 0;
			for (int j = 3; j <= Math.sqrt(i); j += 2) {
				if (i % j == 0) {
					divCount++;
					break;
				}
			}
			if (divCount == 0)
				count++;
		}

		return count;
	}
	
	public int reverse(int x) {
        int rev_num = 0;
        while(x != 0){
            rev_num = rev_num*10 + x%10;
            x = x/10;
        }
        
        return rev_num;
        
    }
	
	/**
	 * Write an algorithm to determine if a number is "happy".

	A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

	Example: 19 is a happy number

	12 + 92 = 82
	82 + 22 = 68
	62 + 82 = 100
	12 + 02 + 02 = 1
	 * @param n
	 * @return
	 */
	public boolean isHappy(int n) {
		Set<Integer> nums = new HashSet<Integer>();

		while (nums.add(n)) {
			int sum = 0;
			int no = n;
			while (no > 0) {
				int rem = no % 10;
				sum += rem * rem;
				no = no / 10;
			}
			if (n == 1)
				return true;
			else
				n = sum;

		}

		return false;

	}
	
	/**
	 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime?
	 */
	public int addDigits(int num) {
		int no = num;
		while (no / 10 > 0) {
			int sum = 0;
			while (no > 0) {
				int rem = no % 10;
				sum += rem;
				no = no / 10;
			}

			no = sum;

		}
		return no;
	}
	
	public int addDigits_efficient(int num) {
		if (num == 0) {
			return 0;
		}
		if (num % 9 == 0) {
			return 9;
		} else {
			return num % 9;
		}

	}
	
	/** @TODO -  Redo
	 * Implement a basic calculator to evaluate a simple expression string.

		The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

		You may assume that the given expression is always valid.

		Some examples:
		"3+2*2" = 7
		"3/2" = 1
		"3*2+4-2" = 8                      S = 3 * 2 -> r = 6 + 4 -> 10 -2
		" 3+5 / 2 " = 5   BODMAS				
	 */
	 
	public int calculate(String s) {
        int result = 0;
        
        Stack<Character> stack = new Stack<Character>();
        int lastOperator = -1;
        boolean isFirst = true;
       for(int i =0; i<s.toCharArray().length; i++){
    	   int operator = -1;

    	   if(s.charAt(i) == '/'){
    		   operator = 3;
    		   
    	   }else if(s.charAt(i) == '*'){
    		   operator = 2;
    		   
    	   }else if(s.charAt(i) == '+'){
    		   operator = 1;
    		   
    	   }else if(s.charAt(i) == '-'){
    		   operator = 0;
    		   
    	   }
    	   
    	   
    	   //Pop elements from stack & compute the result
    	   if(lastOperator > operator){
    		   int output = 0;
    		   while(!stack.isEmpty()){
    			   boolean calculateResult = false;
    			   Character c = stack.pop();
    			   
    			   if(!(c >= '0' || c<='9')){
    				   char op = c;
    				  // int op = getOperatorIntValue(c);
    				   
    				   if(calculateResult){
    					   output = performOperation(result, c, op);
    					   
    				   }
    			   }
    			   else{
    				   calculateResult = true;
    				   result = Character.getNumericValue(c);
    				   isFirst = false;
    			   }
    		   }
    		   
    		   stack.push((char)output);
    		   
    		   
    	   }
    		   
    	   lastOperator = operator;   
    	
    	   stack.push(s.charAt(i));   	   
    	   
    	   
       }
        
        
        
        
        
        
        
        
        return result;
    }
	
	
	private int getOperatorIntValue(char c){
		 int operator = -1;
	   
	   
	   if(c == '/'){
		   operator = 3;
		   
	   }else if(c == '*'){
		   operator = 3;
		   
	   }else if(c == '+'){
		   operator = 3;
		   
	   }else if(c == '-'){
		   operator = 3;
		   
	   }
	   
	   return operator;
		
	}
	
	private int performOperation(int a, int b, char c){
		int result = 0;
		
		if(c == '+')
			result = a + b;
		else if(c == '-')
			result = a - b;
		else if(c == '*')
			result = a * b;
		else if(c == '/')
			result = a / b;
		
		return result;
	}
	
}
