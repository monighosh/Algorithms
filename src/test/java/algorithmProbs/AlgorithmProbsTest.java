package algorithmProbs;
import org.junit.Assert;
import org.junit.Test;

import algorithmProbs.AlgorithmProbs;
import algorithmProbs.helper.ListNode;
import algorithmProbs.helper.TreeNode;


/**
 * 
 */

/**
 * @author 212393859
 *
 */
public class AlgorithmProbsTest {

	@Test
	public void testAddTwoNumbers() {
		
		AlgorithmProbs probs = new AlgorithmProbs();
		ListNode l1 = new ListNode(2);	
		ListNode l12 = new ListNode(4);
		ListNode l13 = new ListNode(3);
		
		l1.next=l12;
		l12.next=l13;
		
		
		
		ListNode l2 = new ListNode(5);
		ListNode l21 = new ListNode(6);
		ListNode l22 = new ListNode(4);
		l2.next=l21;
		l21.next=l22;
		
		ListNode resultList = probs.addTwoNumbers(l1, l2);
		System.out.println("Result List is: " + resultList);
		
		
	}
	
	
	@Test
	public void testSingleNumber_RepeatedMoreThanTwice() {
		AlgorithmProbs probs = new AlgorithmProbs();
		int[] nums = {1,2,2,1,1};
		int output = probs.singleNumber(nums);	
		Assert.assertEquals(1, output, 0);
		
		
	}
	
	@Test
	public void testSingleNumber_NotRepeated() {
		AlgorithmProbs probs = new AlgorithmProbs();
		int[] nums = {1,3,1};
		int output = probs.singleNumber(nums);	
		Assert.assertEquals(3, output, 0);
		
		
	}
	
	@Test
	public void testMergeTrees(){
		AlgorithmProbs probs = new AlgorithmProbs();
		TreeNode t1 = new TreeNode(1);
		TreeNode subt_11 = new TreeNode(3);
		TreeNode subt_12 = new TreeNode(2);
		TreeNode subt_13 = new TreeNode(5);
		
		subt_11.left = subt_13;
		t1.left = subt_11;
		t1.right = subt_12;
		
		TreeNode t2 = new TreeNode(3);
		TreeNode subt_21 = new TreeNode(2);
		TreeNode subt_22 = new TreeNode(10);
		TreeNode subt_23 = new TreeNode(5);
		
		subt_21.right = subt_22;
		t2.left = subt_21;
		t2.right = subt_23;
		
		TreeNode mergedTree = probs.mergeTrees(t1, t2);	
		System.out.println(mergedTree.toString());
		
	}
	
	@Test
	public void testFindAnagrams() {
		AlgorithmProbs probs = new AlgorithmProbs();
		
		probs.findAnagrams("cbaebabacd", "abc");
	}
	
	
	
}
