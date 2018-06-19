/**
 * 
 */
package ik.sorting.probs;

/**
 * @author 212393859
 *
 */
public class SortingProbs {

	/**
	 * DUTCH NATIONAL FLAG
	 * Problem Statement:
Given balls of three colors (Red, Green and Blue) arranged randomly in a line.
The task is to arrange them such that all balls of the same color are together and their collective color groups are in the correct order (Red balls first, Green balls next and Blue balls last).

These are the colors similar to the Dutch National Flag, hence the problem name. 

Input Format:
A string of letters, where each letter represents a ball with color.
'R' = Red Ball  'G' = Green Ball	'B' = Blue Ball

Balls are arranged in the line, in the same order as they appear in the string.

Output Format: A string of letters, in sorted order.

Constraints:1 <= length of string <= 200000
Do this in ONE pass over the string - NOT TWO passes, just one pass.
Your solution can only use O(1) extra memory i.e. you have to do this in-place. Don't use any other memory for processing.

Sample Input: GBGGRBRG
Sample Output:RRGGGGBB

Explanation:
In the input there are total 2 red balls, 4 green balls and 2 blue balls. In output red balls should come first, then green and then blue. So RRGGGGBB is the correct output.
	 */
	
	public String dutchFlagSort(String balls){
		int length = balls.length();
		int blueIdx = length-1;
		int redIdx = 0;
		int greenIdx = 0;
		int currIdx = 0;
		String replacedString = balls;
				
		while(currIdx <= blueIdx){
			char ball = balls.charAt(currIdx);
			
			if(ball == 'R'){
				replacedString = swap(redIdx, currIdx, balls);
				redIdx ++;
				currIdx++;
			}
			else if (ball == 'G'){
				replacedString = swap(greenIdx, currIdx, balls);
				greenIdx ++;
				currIdx++;
			}
			else if(ball == 'B'){
				replacedString = swap(blueIdx, currIdx, balls);
				blueIdx --;
			}
			
			balls = replacedString;
			
			
		}
		
		return balls;
		
	}

	private String swap(int idx1, int idx2, String balls) {
		char[] ballsArray = balls.toCharArray();
		char temp  = ballsArray[idx1];
		ballsArray[idx1] = ballsArray[idx2];
		ballsArray[idx2] = temp;	
		
		return String.valueOf(ballsArray);
		
	}
}
