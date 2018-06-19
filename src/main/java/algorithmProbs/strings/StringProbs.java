/**
 * 
 */
package algorithmProbs.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import sun.misc.Queue;
import algorithmProbs.helper.TreeNode;

/**
 * @author 212393859
 *
 */
public class StringProbs {

	
	/**
	 * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

	The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

Example 1:
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /    
  4     

Output: "1(2(4))(3)"

Example 2:
Input: Binary tree: [1,2,3,null,4]
       1
     /   \
    2     3
     \  
      4 

Output: "1(2()(4))(3)"

	 * @return
	 */
	public String tree2str(TreeNode t) {

		if(t == null)
            return "";
        
        StringBuilder sb = new StringBuilder();
		Stack<TreeNode> s = new Stack<TreeNode>();
		Set<TreeNode> visited = new HashSet<TreeNode>();
		s.push(t);

		while (!s.isEmpty()) {
			TreeNode node = s.peek();

			if (!visited.contains(node)) {

				sb.append("(");
				sb.append(node.val);

				if (node.left == null && node.right != null) {
					sb.append("()");
				}

				if (node.right != null)
					s.push(node.right);
				if (node.left != null)
					s.push(node.left);

				visited.add(node);

			} else {
				s.pop();
				sb.append(")");
			}
		}

		String result = sb.toString();
		return result.substring(1, result.length() - 1);
	}
	
	
	public String countAndSay(int n) {
		String prevSequence = "1";

		for (int i = 1; i < n; i++) {

			char prevChar = 0;
			int charCount = 1;
			StringBuilder sb = new StringBuilder();

			for (char c : prevSequence.toCharArray()) {
				if (prevChar == 0) {
					prevChar = c;					
				} else {
					if (prevChar == c) {
						charCount++;
					} else {
						sb.append(charCount);
						sb.append(prevChar);
						charCount = 1;
						prevChar = c;
					}
				}

			}

			sb.append(charCount);
			sb.append(prevChar);
			prevSequence = sb.toString();

		}

		return prevSequence;

	}
	
	
	/**
	 * Given a group of two strings, you need to find the longest uncommon subsequence of this group of two strings. 
	 * The longest uncommon subsequence is defined as the longest subsequence of one of these strings and this subsequence should not be any subsequence
	 *  of the other strings.

	A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing the order of the remaining
	 elements. Trivially, any string is a subsequence of itself and an empty string is a subsequence of any string.

	The input will be two strings, and the output needs to be the length of the longest uncommon subsequence. If the longest uncommon subsequence doesn't exist, return -1.

	Example 1:
	Input: "aba", "cdc"
	Output: 3
	Explanation: The longest uncommon subsequence is "aba" (or "cdc"), 
	because "aba" is a subsequence of "aba", 
	but not a subsequence of any other strings in the group of two strings.
	 */
	
	public int findLUSlength(String a, String b) {
		if (a.equalsIgnoreCase(b))
			return -1;
		else
			return (a.length() > b.length()) ? a.length() : b.length();
	}
	
	
	/**
	 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
		Example 1:
		Input: "abab"
		Output: True Explanation: It's the substring "ab" twice.
		
		Example 2:
		Input: "aba"
		Output: False
		
		Example 3:
		Input: "abcabcabcabc"
		Output: True  Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
	 * @param s
	 * @return
	 */
	public boolean repeatedSubstringPattern(String s) {

		int i = 1;
		String subString = s.substring(0, i);
		int start = 1;
		int end = s.length() - 1;
		int compareStringLength = end - start + 1;
		while (compareStringLength >= subString.length()) {

			if (checkIfSubStringExists(subString, s, start, end)) {
				return true;
			}
			i++;
			subString = s.substring(0, i);
			start = i;
			compareStringLength = end - start + 1;

		}

		return false;

	}
	
	private boolean checkIfSubStringExists(String subString, String original,
			int start, int end) {

		int i = start;
		while (i < original.length()) {

			int subIndex = 0;
			int matchCount = 0;
			while (matchCount < subString.length() && i<original.length()) {
				if (subString.charAt(subIndex) != original.charAt(i)) {
					return false;
				}
				subIndex++;
				matchCount++;
				i++;
			}
			
			if(matchCount != subString.length())
				return false;
		}
		return true;
	}
    
	/**
	 * Given an array of characters, compress it in-place.The length after compression must always be smaller than or equal to the original array.
	   Every element of the array should be a character (not int) of length 1.
	   After you are done modifying the input array in-place, return the new length of the array.
	   Example 1:
		Input:
		["a","a","b","b","c","c","c"]
		Output:Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
		Explanation: "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
		
		Example 2:
		Input:["a"]
		Output:Return 1, and the first 1 characters of the input array should be: ["a"]
		Explanation:Nothing is replaced.
		
		Example 3:
		Input:["a","b","b","b","b","b","b","b","b","b","b","b","b"]
		Output:Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
		Explanation:Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
		Notice each digit has it's own entry in the array.
	 * @param chars
	 * @return
	 */
	public int compress(char[] chars) {
		int charStartIndex = 0;
		int charCount = 1;
		int compressedLength = 1;

		for (int i = 0; i < chars.length; i++) {

			if (i + 1 < chars.length && chars[i] == chars[i + 1]) {
				charCount++;
			} else {
				chars[charStartIndex] = chars[i];
				charStartIndex++;
				if (charCount > 1) {
					
					String countString = String.valueOf(charCount);

					for (char c : countString.toCharArray()) {
						chars[charStartIndex] = c;
						charStartIndex++;
					}
				}

				charCount = 1;
				compressedLength = charStartIndex;
			}
		}
		return compressedLength;
	}
	
	public int romanToInt(String s) {
        int sum = 0;
        char[] sArray = s.toCharArray();
        
        for(int i=1; i< sArray.length; i++){
            if(getIntValue(sArray[i-1]) >= getIntValue(sArray[i]))
                sum = sum + getIntValue(sArray[i-1]);
            
            else
                sum = sum - getIntValue(sArray[i-1]);
            
            
        }
        
        sum += getIntValue(sArray[sArray.length-1]);
        
        return sum;
    }
	
	private int getIntValue(char romanChar){
        int intValue =0;
        switch(romanChar){
            case 'I':
                intValue = 1;
                break;
            case 'V':
                intValue = 5;
                break;
            case 'X':
                intValue = 10;
                break;
            case 'L':
                intValue = 50;
                break;
            case 'C':
                intValue = 100;
                break;
            case 'D':
                intValue = 500;
                break;
            case 'M':
                intValue = 1000;  
                break;
                
                
        }
        
        return intValue;
    }
	
	/**
	 * Implement strStr().Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

		Example 1:
		Input: haystack = "hello", needle = "ll"
		Output: 2
		
		Example 2:
		Input: haystack = "aaaaa", needle = "bba"
		Output: -1
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public int strStr(String haystack, String needle) {

		char[] hayStackArray = haystack.toCharArray();
		char[] needleArray = needle.toCharArray();
		int index = 0;
		
		if (needleArray.length == 0)
			return 0;
		else if (hayStackArray.length == 0)
			return -1;

		while (index < hayStackArray.length && (hayStackArray.length - index) >= needleArray.length) {
			if (hayStackArray[index] == needleArray[0]) {
				boolean matchFound = true;
				int hayStackIndex = index + 1;

				for (int i = 1; i < needleArray.length; i++) {

					if (hayStackArray[hayStackIndex] != needleArray[i]) {
						matchFound = false;
						break;
					}
					hayStackIndex++;
				}
				if (matchFound)
					return index;
			}
			index++;
		}
		return -1;
	}
	
	/**Note : Revise this implementation logic
	 * Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.

		Substrings that occur multiple times are counted the number of times they occur.
		Example 1:
		Input: "00110011"
		Output: 6
		Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
		Notice that some of these substrings repeat and are counted the number of times they occur.

		Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
		Example 2:
		Input: "10101"
		Output: 4
		Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
	 * @param s
	 * @return
	 */
	public int countBinarySubstrings(String s) {
        int ans = 0, prev = 0, cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) != s.charAt(i)) {
                ans += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            } else {
                cur++;
            }
        }
        return ans + Math.min(prev, cur);
    }
	
	/**
	 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

		Examples:
		s = "leetcode" return 0.
		s = "loveleetcode", return 2.
	 * @param s
	 * @return
	 */
	public int firstUniqChar(String s) {
		HashMap<Character, ArrayList<Integer>> charIndexMap = new HashMap<Character, ArrayList<Integer>>();
		char[] cArray = s.toCharArray();
		for (int i = 0; i < cArray.length; i++) {
			ArrayList<Integer> indexList;
			if (charIndexMap.containsKey(cArray[i])) {
				indexList = charIndexMap.get(cArray[i]);

			} else {
				indexList = new ArrayList<Integer>();
			}

			indexList.add(i);
			charIndexMap.put(cArray[i], indexList);
		}

		int minIndex = s.length();
		for (Map.Entry<Character, ArrayList<Integer>> entry : charIndexMap.entrySet()) {
			if (entry.getValue().size() == 1) {
				int index = entry.getValue().get(0);
				minIndex = (index < minIndex) ? index : minIndex;
			}
		}

		if (minIndex != s.length())
			return minIndex;
		else
			return -1;
	}
	
	public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", " ");
        char[] cArray = s.toCharArray();
        
        int i = 0 ; int j= s.length()-1;
        
        while(i < j){
            if(cArray[i] != ' ' && cArray[j]!= ' ' && Character.toLowerCase(cArray[i]) != Character.toLowerCase(cArray[j]))
                return false;
            else if (Character.toLowerCase(cArray[i]) == Character.toLowerCase(cArray[j])){
                i++;
                j--;
            }
            else if(cArray[i] == ' ')
                i++;
            else if(cArray[j] == ' ')
                j--;
            
        }
        
        return true;
	}
	
	
	
	public boolean validPalindrome(String s) {
        char[] cArray = s.toCharArray();
        int i =0 ; int j = s.length()-1;
        boolean isDeleted = false;
        while(i <j){
            if(cArray[i] == cArray[j]){
                i++;
                j--;
            }
            else{
                if(isDeleted)
                    return false;
                else {
                    if(i+1 < j && cArray[i+1] == cArray[j]){
                        i++;
                    }
                    else {
                        j--;
                    }
                    //if(j-1 > i && cArray[j-1] == cArray[i])
                    isDeleted = true;
                    
                }
            }
        }
        
        
        return true;
        
    }
	
	/**
	 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.

	The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.

	Example 1:
	Input: "UD" Output: true
	Example 2:
	Input: "LL" Output: false
	 * @param moves
	 * @return
	 */
	public boolean judgeCircle(String moves) {
		int x = 0;
		int y = 0;
		for (char c : moves.toCharArray()) {
			if (c == 'R')
				y++;
			else if (c == 'L')
				y--;
			else if (c == 'U')
				x++;
			else if (c == 'D')
				x--;

		}

		if (x == 0 && y == 0)
			return true;
		else
			return false;
	}
	
	
	/*
	 * Given two binary strings, return their sum (also a binary string).

		For example,
		a = "11"
		b = "1"
		Return "100"
	 */
	public String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int aIndex = a.length() - 1;
		int bIndex = b.length() - 1;
		int sum = 0;
		int rem = 0;
		while (aIndex >= 0 || bIndex >= 0) {
			int currSum = 0;
			int aInt = 0;
			int bInt = 0;

			if (aIndex >= 0)
				aInt = Character.getNumericValue(a.charAt(aIndex));
			if (bIndex >= 0)
				bInt = Character.getNumericValue(b.charAt(bIndex));

			currSum = rem + aInt + bInt;

			if (currSum > 1) {
				rem = currSum / 2;
				sum = currSum % 2;
			} else {
				rem = 0;
				sum = currSum;
			}

			sb.append(Character.forDigit(sum, 10));

			aIndex--;
			bIndex--;
		}

		if(rem >0)
			sb.append(Character.forDigit(rem, 10));
		return sb.reverse().toString();
	}
	
	
	/**
	 * Given a string s and a list of strings dict, you need to add a closed pair of bold tag <b> and </b> to wrap the substrings in s that exist in dict. If two such substrings overlap, you need to wrap them together by only one pair of closed bold tag. Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.

		Example 1:
		Input: s = "abcxyz123"   dict = ["abc","123"]
		Output: "<b>abc</b>xyz<b>123</b>" 

		Example 2:
		Input: s = "aaabbcc" dict = ["aaa","aab","bc"]
		Output: "<b>aaabbc</b>c"
		Note: The given dict won't contain duplicates, and its length won't exceed 100. All the strings in input have length in range [1, 1000].
	 * @param words
	 * @param S
	 * @return
	 */
	public String boldWords(String[] words, String S){
		StringBuilder sb = new StringBuilder();
		boolean isConsecutive = false;
		boolean[] bold = new boolean[S.length()];
		Arrays.fill(bold, false);
		
		for(int i =0 ; i< S.length(); i++){			
		
			for(String word: words){
				int wordIndex = 0; int sIndex = i; boolean matched = true;
				
				while(wordIndex < word.length() && sIndex < S.length()){
					if(word.charAt(wordIndex) != S.charAt(sIndex)){
						matched = false;
						break;
					}	
					
					wordIndex++;
					sIndex++;
				}
				
				if(sIndex <= S.length() && matched){
					for(int j =i; j< i+word.length(); j++)
						bold[j] = true;
				}
			}
		}	
		
		for(int i =0 ; i< S.length(); i++){		
			if(!isConsecutive && bold[i]) {			
				sb.append("<b>");
				
				isConsecutive = true;
			}
			else if(isConsecutive && !bold[i]){
				sb.append("</b>");			
				isConsecutive = false;
			}
			
			sb.append(S.charAt(i));
		}
		if(isConsecutive)
			sb.append("</b>");			
		
		return sb.toString();
	}
	
	
	/**
	 * Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.
		A string such as "word" contains only the following valid abbreviations:

		["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
		Notice that only the above abbreviations are valid abbreviations of the string "word". Any other string is not a valid abbreviation of "word".

		Note: Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.
		Example 1:
		Given s = "internationalization", abbr = "i12iz4n":   Return true. 

		Example 2:
		Given s = "apple", abbr = "a2e": Return false.
	 */
	public boolean validWordAbbreviation(String word, String abbr) {

		if (abbr.length() > word.length())
			return false;

		StringBuilder sb = new StringBuilder();

		int wordIndex = 0;
		int abbrIndex = 0;

		while (wordIndex < word.length() && abbrIndex < abbr.length()) {

			if (Character.isDigit(abbr.charAt(abbrIndex))) {
				sb.append(abbr.charAt(abbrIndex));
				abbrIndex++;

			} else if (word.charAt(wordIndex) != abbr.charAt(abbrIndex)
					&& sb.length() == 0)
				return false;
			else {
				if (sb.length() > 0) {
					int value = Integer.parseInt(sb.toString());

					wordIndex = wordIndex + (value);
					sb = new StringBuilder();

				} else {
					wordIndex++;
					abbrIndex++;
				}

			}

		}

		if (sb.length() > 0) {
			int value = Integer.parseInt(sb.toString());

			wordIndex = wordIndex + (value);
			sb = new StringBuilder();

		}
		if (wordIndex == word.length() && abbrIndex == abbr.length())
			return true;
		else
			return false;
	}
	
	
	/**
	 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". 
	 * The game ends when a person can no longer make a move and therefore the other person will be the winner.
		Write a function to compute all possible states of the string after one valid move.
	 */
	public List<String> generatePossibleNextMoves(String s) {
		List<String> moves = new ArrayList<String>();

		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == '+' && i + 1 < s.length() && s.charAt(i + 1) == '+') {
				char[] cArray = s.toCharArray();
				cArray[i] = '-';
				cArray[i + 1] = '-';
				
				moves.add(new String(cArray));
			}

		}

		return moves;
	}

	/**
	 * Given a string, find the length of the longest substring without repeating characters.	
		Examples:
		Given "abcabcbb", the answer is "abc", which the length is 3.
		Given "bbbbb", the answer is "b", with the length of 1.
		Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
	 */
	
	public int lengthOfLongestSubstring(String s) {
		int maxLength = 0;
		Set<Character> visited = new HashSet<Character>();
		int i = 0;
		int j = 0;
		
		while (i < s.length() && j < s.length()) {
			if (visited.contains(s.charAt(j))) {
				visited.remove(s.charAt(i));
				maxLength = Math.max(maxLength, j - i);
				i++;
			} else {
				visited.add(s.charAt(j));
				j++;
			}
		}
		maxLength = Math.max(maxLength, j - i);
		return maxLength;

	}
	
	/**
	 * Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.
	 */
	
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;

		Map<Character, Integer> cMap = new HashMap<Character, Integer>();

		for (char c : s.toCharArray()) {
			int count = 0;
			if (cMap.containsKey(c)) {
				count = cMap.get(c);
			}
			cMap.put(c, count += 1);
		}

		for (char c : t.toCharArray()) {
			if (cMap.containsKey(c)) {
				int count = cMap.get(c);
				if (count == 1)
					cMap.remove(c);
				else
					cMap.put(c, count -= 1);

			} else
				return false;

		}

		return (cMap.size() == 0) ? true : false;

	}
	
	
}










