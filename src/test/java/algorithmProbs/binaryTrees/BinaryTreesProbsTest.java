/**
 * 
 */
package algorithmProbs.binaryTrees;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import algorithmProbs.helper.TreeNode;

/**
 * @author 212393859
 * 
 */
public class BinaryTreesProbsTest {
	BinaryTreesProbs bProbsTest = new BinaryTreesProbs();

	@Test
	public void testConvertBST() {
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(13);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(7);
		TreeNode node6 = new TreeNode(20);

		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.left = node5;
		node3.right = node6;

		TreeNode result = bProbsTest.convertBST(node1);
	}

	@Test
	public void testTrimBST() {
		TreeNode node5 = new TreeNode(5);
		TreeNode node2 = new TreeNode(2);
		TreeNode node10 = new TreeNode(10);
		TreeNode node1 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node9 = new TreeNode(9);
		TreeNode node20 = new TreeNode(20);

		node5.left = node2;
		node5.right = node10;

		node2.left = node1;
		node2.right = node3;

		node10.left = node9;
		node10.right = node20;

		node3.right = node4;

		TreeNode result = bProbsTest.trimBST(node5, 4, 10);

	}

	@Test
	public void testFindTarget() {
		TreeNode node5 = new TreeNode(5);
		TreeNode node3 = new TreeNode(3);
		TreeNode node6 = new TreeNode(6);
		TreeNode node2 = new TreeNode(2);
		TreeNode node4 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);

		node5.left = node3;
		node5.right = node6;

		node3.left = node2;
		node3.right = node4;

		node6.right = node7;
		node3.right = node4;

		boolean result = bProbsTest.findTarget(node5, 9);

		assertEquals(true, result);

	}

	@Test
	public void testAverageOfLevels() {
		TreeNode node5 = new TreeNode(5);
		TreeNode node3 = new TreeNode(3);
		TreeNode node6 = new TreeNode(6);
		TreeNode node2 = new TreeNode(2);
		TreeNode node4 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);

		node5.left = node3;
		node5.right = node6;

		node3.left = node2;
		node3.right = node4;

		node6.right = node7;
		node3.right = node4;

		List<Double> result = bProbsTest.averageOfLevels(node5);

		assertEquals(5, result.get(0), 0);
		assertEquals(4.5, result.get(1), 0);
		assertEquals(4.333333333333333, result.get(2), 0);

	}

	@Test
	public void testIsSameTree() {
		TreeNode node5 = new TreeNode(5);
		TreeNode node3 = new TreeNode(3);
		TreeNode node6 = new TreeNode(6);
		TreeNode node2 = new TreeNode(2);
		

		node5.left = node3;
		node5.right = node6;

		node3.left = node2;
		
		TreeNode node5_2 = new TreeNode(5);
		TreeNode node3_2 = new TreeNode(3);
		TreeNode node6_2 = new TreeNode(6);
		TreeNode node2_2 = new TreeNode(2);

		node5_2.left = node3_2;
		node5_2.right = node6_2;

		node3_2.left = node2_2;

		boolean result = bProbsTest.isSameTree(node5, node5_2);

		assertEquals(true, result);

	}

	@Test
	public void testInvertTree() {
		TreeNode node4 = new TreeNode(4);
		TreeNode node2 = new TreeNode(2);
		TreeNode node7 = new TreeNode(7);
		TreeNode node1 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		TreeNode node6 = new TreeNode(6);
		TreeNode node9 = new TreeNode(9);

		node4.left = node2;
		node4.right = node7;

		node2.left = node1;
		node2.right = node3;

		node7.left = node6;
		node7.right = node9;

		TreeNode result = bProbsTest.invertTree(node4);

	}

	@Test
	public void testBinaryTreePaths() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);

		node1.left = node2;
		node1.right = node3;

		node2.left = node4;
		node2.right = node5;
		List<String> result = bProbsTest.binaryTreePaths(node1);

	}

	@Test
	public void testSumOfLeftLeaves() {
		TreeNode node3 = new TreeNode(3);
		TreeNode node9 = new TreeNode(9);
		TreeNode node20 = new TreeNode(20);
		TreeNode node15 = new TreeNode(15);
		TreeNode node7 = new TreeNode(7);

		node3.left = node9;
		node3.right = node20;

		node20.left = node15;
		node20.right = node7;
		int result = bProbsTest.sumOfLeftLeaves(node3);

		assertEquals(24, result);

	}
	
	@Test
	/**
	 * 10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1
	 */
	public void testpathSum() {
		TreeNode node10 = new TreeNode(10);
		TreeNode node5 = new TreeNode(5);
		TreeNode node_3 = new TreeNode(-3);
		TreeNode node3 = new TreeNode(3);
		TreeNode node2 = new TreeNode(2);
		TreeNode node11 = new TreeNode(11);
		TreeNode node3_1 = new TreeNode(3);
		TreeNode node_2 = new TreeNode(-2);
		TreeNode node1 = new TreeNode(1);
		
		node10.left = node5;
		node10.right = node_3;
		
		node5.left = node3;
		node5.right = node2;
		
		node3.left = node3_1;
		node3.right = node_2;
		
		node2.right = node1;
		node_3.right = node11;

		int result = bProbsTest.pathSum(node10, 8);

		//assertEquals(true, result);

	}

}
