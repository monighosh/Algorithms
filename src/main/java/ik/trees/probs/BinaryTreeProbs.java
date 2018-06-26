package ik.trees.probs;

import java.util.ArrayList;
import java.util.List;

import ik.dataStructure.trees.TreeNode;

public class BinaryTreeProbs {

	public boolean isValidBST(TreeNode root) {

		return isValidBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean isValidBSTUtil(TreeNode node, int min, int max) {
		if (node == null)
			return true;

		if (node.val < min || node.val > max)
			return false;

		return (isValidBSTUtil(node.left, min, node.val) && isValidBSTUtil(node.right, node.val, max));
	}
	
	
	void printAllPaths(TreeNode root) {
        
        int[] path = new int[10000];

        printAllPathsUtil(root, path,0);
    }
    
     void printAllPathsUtil(TreeNode n, int[] path, int pIndx){
        
        if(n == null)
            return;
            
        path[pIndx] = n.val ;
        pIndx ++;
        
        if(n.left == null && n.right == null){
            printPaths(path, pIndx);
            return;
        }
        
        
        printAllPathsUtil(n.left, path, pIndx);
        printAllPathsUtil(n.right, path, pIndx);
        
         
    }
    
     void printPaths(int[] path, int pIndx){
        
        for(int n = 0; n< pIndx ; n++){
            
            System.out.print(path[n] +" ");
            
        }
        
        System.out.println();
    }
}
