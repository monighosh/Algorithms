/**
 * 
 */
package algorithmProbs.strings;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import algorithmProbs.helper.TreeNode;



/**
 * @author 212393859
 *
 */
public class StringProbsTest {
	
	/**
	 * [1,2,3,4,null,null,null,null,5]   -> "1(2(4()(5)))(3)"
	 * [1,2,3,4]						->  "1(2(4))(3)"
	 */
	@Test	
	public void testTree2str() {
		StringProbs stringProbs = new StringProbs();	
		
		
		TreeNode treeNode = createTreeNode();
		String result = stringProbs.tree2str(treeNode);	
		Assert.assertEquals("1(2(4()(5)))(3)", result);
		
	}
	
	private TreeNode createTreeNode(){
		TreeNode node = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		node.left = node1;
		node.right = node2;
		node1.left = node3;
		node3.right = node4;
		
		return node;
		
		
		
	}
	
	@Test	
	public void testCountAndSay() {
		StringProbs stringProbs = new StringProbs();		
		int input = 7;
		String result = stringProbs.countAndSay(input);	
		Assert.assertEquals("13112221", result);
		
	}
	
	@Test	
	public void testFindLUSlength() {
		StringProbs stringProbs = new StringProbs();		
		String a = "aba"; String b ="cdc";
		int result = stringProbs.findLUSlength(a,b);	
		Assert.assertEquals(3, result);
		
	}
	
	@Test	
	public void testRepeatedSubstringPattern() {
		StringProbs stringProbs = new StringProbs();		
		String a = "abcabcabcabc"; 
		
		boolean result = stringProbs.repeatedSubstringPattern(a);	
		Assert.assertEquals(true, result);
		
	}
	
	@Test	
	public void testCompress() {
		StringProbs stringProbs = new StringProbs();		
		char[] c = {'a','a','a','a','a','b'} ;
		
		int result = stringProbs.compress(c);	
		Assert.assertEquals(3, result);
		
	}
	
	@Test	
	public void testRomanToInt() {
		StringProbs stringProbs = new StringProbs();		
		//String s = "DCXXI";
		String s = "IXDC";
		
		int result = stringProbs.romanToInt(s);	
		Assert.assertEquals(589, result);
		
	}
	
	@Test	
	public void testStrStr() {
		StringProbs stringProbs = new StringProbs();		
		String haystack = "mississippi";
		String needle = "issip";
		
		int result = stringProbs.strStr(haystack,needle);	
		Assert.assertEquals(4, result);
		
	}
	
	@Test	
	public void testCountBinarySubstrings() {
		StringProbs stringProbs = new StringProbs();		
		String input = "00110011";
		
		
		int result = stringProbs.countBinarySubstrings(input);	
		Assert.assertEquals(6, result);
		
	}
	
	@Test	
	public void testFirstUniqChar() {
		StringProbs stringProbs = new StringProbs();		
		String input = "loveleetcode";	
		
		int result = stringProbs.firstUniqChar(input);	
		Assert.assertEquals(2, result);
		
	}
	
	@Test	
	public void testIsPalindrome() {
		StringProbs stringProbs = new StringProbs();		
		String input = "A man, a plan, a canal: Panama";	
		
		boolean result = stringProbs.isPalindrome(input);	
		Assert.assertEquals(true, result);
		
	}
	
	@Test	
	public void testValidPalindrome() {
		StringProbs stringProbs = new StringProbs();		
			
		String input = "cupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucu";
		boolean result = stringProbs.validPalindrome(input);	
		//Assert.assertEquals(true, result);
		
	}

	@Test	
	public void testJudgeCircle() {
		StringProbs stringProbs = new StringProbs();		
			
		String input = "RDLU";
		boolean result = stringProbs.judgeCircle(input);	
		Assert.assertEquals(true, result);
		
	}
	@Test	
	public void testAddBinary() {
		StringProbs stringProbs = new StringProbs();		
			
		String a = "11";
		String b = "1011";
		String result = stringProbs.addBinary(a,b);	
		Assert.assertEquals("1110", result);
		
	}
	
	@Test	
	public void testValidWordAbbreviation() {
		StringProbs stringProbs = new StringProbs();		
			
		String a = "internationalization";
		String b = "i12iz4n";
		
		boolean result = stringProbs.validWordAbbreviation(a,b);	
		Assert.assertEquals(true, result);
		
	}
	
	@Test	
	public void testGeneratePossibleNextMoves() {
		StringProbs stringProbs = new StringProbs();		
			
		String input = "++++";
		
		
		List<String> result = stringProbs.generatePossibleNextMoves(input);	
		Assert.assertEquals(3, result.size());
		
	}
	
	@Test	
	public void testBoldWords() {
		StringProbs stringProbs = new StringProbs();
		String[] words = {"aaa" , "aab", "bc"};		
		String input = "aaabbcc";

		
		String result = stringProbs.boldWords(words,input);	
		Assert.assertEquals("<b>aaabbc</b>c", result);
		
	}
	
	@Test
	public void testLengthOfLongestSubstring(){
		StringProbs stringProbs = new StringProbs();
		
		String input = "dvdf";
		
		int result = stringProbs.lengthOfLongestSubstring(input);	
		Assert.assertEquals(3, result);
		
		
	}

	@Test
	public void testIsAnagram(){
		StringProbs stringProbs = new StringProbs();
		
		String s = "anagram";
		String t = "nagaram";
		
		boolean result = stringProbs.isAnagram(s, t);	
		Assert.assertEquals(true, result);
		
		
	}

}
