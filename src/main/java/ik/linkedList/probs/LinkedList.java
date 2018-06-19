/**
 * 
 */
package ik.linkedList.probs;

import java.util.Arrays;
import java.util.Stack;

import ik.dataStructure.linkedList.ListNode;

/**
 * @author 212393859
 *
 */
public class LinkedList {

	
	/**
	 * 
Find Median Of Sorted Circular Singly Linked List
Given a pointer ptr to an arbitrary node of a sorted circular singly linked list L containing only even integers. You have to find the median value M of L.
When even number of elements in L, then the median M is average of two middle elements. 

Input Format:
There is only one argument, ptr denoting a pointer to an arbitrary node of L.

Output Format:
Return one integer denoting the median M.

Constraints:
Value contained in nodes will be even number. (Hence when even number of elements in L, median M will be an integer. (even + even) / 2 = integer (aka, not float). So answer will always be integer (never float).)

Sample Input: L: 2 -> 4 -> 6 -> 8 -> 10
ptr: Pointer of the node containing value 4. 

Sample Output: 6
	 * @param head
	 * @return
	 */
	
	
	public int findMedian(ListNode curr) {

		ListNode head;
		int median;
		boolean isIncreasing = isIncreasing(curr);
		int length = findLength(curr);

		if (isIncreasing)
			head = findSmallest(curr);
		else
			head = findLargest(curr);

		for (int i = 0; i < (length - 1) / 2; i++) {
			head = head.next;
		}

		if (length % 2 == 1)
			median = head.val;
		else {

			median = (head.val + head.next.val) / 2;
		}

		return median;
	}

	private boolean isIncreasing(ListNode curr) {
		if (curr != null) {
			if (curr.val < curr.next.val)
				return true;
			else
				return false;

		}

		return false;
	}

	private ListNode findSmallest(ListNode curr) {

		ListNode n = curr;

		while (n.val < n.next.val) {

			n = n.next;
		}

		return n.next;
	}

	private ListNode findLargest(ListNode curr) {

		ListNode n = curr;

		while (n.val > n.next.val) {

			n = n.next;
		}

		return n.next;
	}

	private int findLength(ListNode node) {
		ListNode curr = node.next;
		int length = 1;
		while (curr != node) {
			curr = curr.next;
			length++;
		}

		return length;

	}
	
	public ListNode addNumbers(ListNode l1, ListNode l2){
		ListNode result = null;
        int carryOver = 0;
        
        while(l1 != null || l2!=null){
            int sum = 0;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            
            sum += carryOver;
            
            
            carryOver = sum/10;
            if(sum > 9)
                sum = sum%10;
            
            ListNode node = new ListNode(sum);
            
            if(result == null){
                result = node;
            }
            else {
                result.next = node;
                result = node;
            }
                

                
        }
        
        if(carryOver >0){
        	ListNode node = new ListNode(carryOver);
            result.next = node;
        }
        
        return result;
	}
	
	
	public ListNode zip_given_linked_list(ListNode head) {
	    
		ListNode curr = head;
		
        int length = findLength1(head);
        ListNode midNode = findMidNode(length, head);
        ListNode reverseList= reverseList(midNode.next);
        ListNode rHead = reverseList;
        midNode.next = null;
        
        while(curr !=null && curr.next != null && rHead!= null){
        	reverseList = rHead;
        	ListNode next = curr.next;
            curr.next = rHead;
            rHead = reverseList.next;
            reverseList.next = next;
            
            curr = next;            
        }
        
        while(rHead != null){
            curr.next = reverseList;
            curr = reverseList;
            reverseList = reverseList.next;
        }
        
    
        return head;
    }
    
    private  int findLength1(ListNode n){
        int length =0;
        
        while(n != null){
            length++;
            n = n.next;
        }
        
        return length;
    }
    
    private static ListNode findMidNode(int length, ListNode n){
        int mid = 0;
        
        while(mid < length/2){
            n = n.next;
            mid++;
        }
        
        return n;
    }
    
    private static ListNode reverseList(ListNode n){
    	ListNode prev = null;
    	ListNode curr = n;
        ListNode next = n;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    public int find_max_length_of_matching_parentheses(String brackets) {
        int maxLength = 0;
        boolean[] output = new boolean[brackets.length()];
        Arrays.fill(output, false);
        
        Stack<Integer> bracketIdx = new Stack<Integer>();
        char[] bArray = brackets.toCharArray();
        
        for(int i=0; i< bArray.length; i++){
            if(bArray[i] == '('){
                bracketIdx.push(i);
            }
            else {
                int matchedIdx = bracketIdx.pop();
                output[i] = true;
                output[matchedIdx] = true;
            }
        }
        
        int lengthSoFar = 0;
        for(int j =0; j < output.length; j++){
            if(output[j]){
                lengthSoFar++;
            }else {            	
                maxLength = (lengthSoFar > maxLength) ? lengthSoFar : maxLength;
                lengthSoFar = 0;
            }
        }
        
        return (lengthSoFar > maxLength) ? lengthSoFar : maxLength;
    }

	
	
}
