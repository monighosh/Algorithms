package ik.trees.probs;

import org.junit.Assert;
import org.junit.Test;

import ik.dataStructure.trees.TreeNode;

public class BinaryTreeProbsTest {
	
	BinaryTreeProbs btProbs = new BinaryTreeProbs();

	@Test
	public void testIsValidBST(){
		TreeNode node5 = new TreeNode(5);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node8 = new TreeNode(8);
		TreeNode node6 = new TreeNode(6);
		
		node5.left = node1;
		node5.right = node6;
		node6.left = node2;
		node6.right = node8;
		
		boolean result = btProbs.isValidBST(node5);
		
		Assert.assertEquals(false, result);
	}
	
	@Test
	public void testPrintAllPaths(){
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		
		 btProbs.printAllPaths(node1);
		
		
	}
}
