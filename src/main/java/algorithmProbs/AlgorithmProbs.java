package algorithmProbs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import algorithmProbs.helper.ListNode;
import algorithmProbs.helper.TreeNode;

/**
 * Created by 212393859 on 10/24/16.
 */
public class AlgorithmProbs {

	/**
	 * Add Two Numbers You are given two non-empty linked lists representing two
	 * non-negative integers. The digits are stored in reverse order and each of
	 * their nodes contain a single digit. Add the two numbers and return it as
	 * a linked list.
	 * 
	 * You may assume the two numbers do not contain any leading zero, except
	 * the number 0 itself.
	 * 
	 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
	 */

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int quotient = 0;
		ListNode prev = null;
		ListNode currl1 = l1;
		ListNode currl2 = l2;
		ListNode newList = null;

		while (currl1 != null || currl2 != null) {

			int value1 = (currl1 == null) ? 0 : currl1.val;
			int value2 = (currl2 == null) ? 0 : currl2.val;

			int sum = value1 + value2 + quotient;

			int remainder = sum % 10;
			quotient = sum / 10;

			ListNode newNode = new ListNode(remainder);

			if (newList == null)
				newList = newNode;

			if (prev != null) {
				prev.next = newNode;
			}

			prev = newNode;

			if (currl1 != null)
				currl1 = currl1.next;
			if (currl2 != null)
				currl2 = currl2.next;

		}

		if (quotient > 0) {
			ListNode newNode = new ListNode(quotient);
			prev.next = newNode;
		}

		return newList;

	}	
	
	/**
	 * Given an array of integers, every element appears twice except for one. Find that single one.

	Note:
	Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
	 */

	public int singleNumber(int[] nums) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int no : nums) {
			int count = 0;
			if (map.containsKey(no)) {
				count = map.get(no);
			}
			count++;
			map.put(no, count);

		}

		Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();

			int value = (int) pair.getValue();
			if (value % 2 != 0) {
				return (int) pair.getKey();
			}

		}

		return 0;
	}
	
	/**
	 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

	You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

	Example 1:
	Input: 
		Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
	Output: 
	Merged tree:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7
	 * @param t1
	 * @param t2
	 * @return
	 */
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        
		if (t1 == null)
			return t2;
		if (t2 == null)
			return t1;

		t1.val = t1.val + t2.val;

		t1.left = mergeTrees(t1.left, t2.left);
		t1.right = mergeTrees(t1.right, t2.right);

		return t1;
        
    }
	
	
	public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        if (p.length() > s.length()) {
            return result;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int match = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    match++;
                }
            }
            if (i >= p.length()) {
                c = s.charAt(i - p.length());
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    if (map.get(c) == 1) {
                        match--;
                    }
                }
            }
            if (match == map.size()) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }
}
