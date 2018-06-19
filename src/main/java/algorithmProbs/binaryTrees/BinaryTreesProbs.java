/**
 * 
 */
package algorithmProbs.binaryTrees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import algorithmProbs.helper.TreeNode;

/**
 * @author 212393859
 *
 */
public class BinaryTreesProbs {

	private int sum = 0;
	
	Set<Integer> findTargetSet = new HashSet<Integer>();
	
	List<String> bTPaths = new ArrayList<String>();
	
	 int sumLeaves = 0;
	/**
	 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

		Example:
		Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

		Output: The root of a Greater Tree like this:
             18
            /   \
          20     13
	 * @param root
	 * @return
	 */
	public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
	
	public TreeNode trimBST(TreeNode root, int L, int R) {
        
        if(root == null)
            return null;
        
        TreeNode left = trimBST(root.left, L, R);
        TreeNode right = trimBST(root.right, L, R);
        
        if(root.val >=L && root.val <=R){
        	root.left = left;
        	root.right = right;
            return root;
        }else if(root.val < L){
        	return root.right;
        }
        else
        	return root.left;
        	
        
    }
	
	/**
	 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

	Example 1:
	Input: 
    5        2,3,4,5,6,7
   / \
  3   6
 / \   \
2   4   7

	Target = 9

	Output: True
	Example 2:
	Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
	 */
	
	public boolean findTarget(TreeNode root, int k) {

		inorderTraversal(root);

		for (Integer no : findTargetSet) {
			if ((k - no) != no && findTargetSet.contains(k - no)) {
				return true;
			}
		}
 
		return false;

	}

	private TreeNode inorderTraversal(TreeNode root) {

		if (root == null) {
			return null;
		}

		inorderTraversal(root.left);
		findTargetSet.add(root.val);
		inorderTraversal(root.right);

		return root;
	}
	
	
	/**
	 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
		Example 1:
		Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
	 */
	
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> average = new ArrayList<Double>();

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (q.size() > 0) {
			long sum = 0;
			long count = 0;
			long noToPop = q.size();
			while (count < noToPop) {

				count++;
				TreeNode node = q.remove();

				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);

				sum += node.val;

			}

			double avg = (double) sum / noToPop;
			average.add(avg);

		}

		return average;
	}
	
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
		
		if(p == null && q ==null)
			return true;
		else if(p == null || q == null)
			return false;
		else		
			return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		
		
        
    }
	
	/**
	 * Invert a binary tree.
     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1

	 */
	
	public TreeNode invertTree(TreeNode root) {

		if (root == null)
			return null;

		TreeNode right = invertTree(root.right);
		TreeNode left = invertTree(root.left);

		root.left = right;
		root.right = left;

		return root;
	}
	

	
	
	/**
	 * Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
/ \
4  5
All root-to-leaf paths are:

["1->2->5", "1->2->4","1->3"]
	 */
	
	public List<String> binaryTreePaths(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		
		List<String> paths = new ArrayList<String>();
		findPath(root, sb, paths);

		return paths;

	}

	private void findPath(TreeNode root, StringBuilder sb, List<String> paths) {

		if (root == null)
			return;

		if (sb.length() > 0)
			sb.append("->");
		sb.append(root.val);
		if (root.left == null && root.right == null) {

			paths.add(sb.toString());
			return;

		}

		findPath(root.left, new StringBuilder(sb), paths);
		findPath(root.right, new StringBuilder(sb), paths);

	}
	
	
	/**
	 * Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
	 * @param root
	 * @return
	 */
	public int sumOfLeftLeaves(TreeNode root) {

		sumLeft(root, false);

		return sumLeaves;
	}

	public void sumLeft(TreeNode root, boolean isLeft) {

		if (root == null)
			return;

		if (isLeft && root.left == null && root.right == null) {
			sumLeaves += root.val;
		}

		sumLeft(root.left, true);
		sumLeft(root.right, false);
	}
	

	/** Note - Did not understand the algo
	 * You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
	 */
	
	public static int pathSum(TreeNode root, int sum) {
	      return pathSum(root, sum, 0, new ArrayList<Integer>());
	    }

	    public static int pathSum(TreeNode root, int sum, int count, ArrayList<Integer> arr) {
	        arr.add(root.val);
	        int acc = 0;
	        for (int i=arr.size()-1; i>=0; i--) {
	          acc += arr.get(i);
	          if (acc == sum)
	            count++;
	        }
	        if(root.left != null)
	            count = pathSum(root.left, sum, count, arr);
	        if(root.right != null)
	            count = pathSum(root.right, sum, count, arr);
	        arr.remove(arr.size()-1);
	        return count;
	    }
}
