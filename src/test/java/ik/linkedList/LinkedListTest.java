/**
 * 
 */
package ik.linkedList;

import org.junit.Assert;
import org.junit.Test;

import ik.dataStructure.linkedList.ListNode;
import ik.linkedList.probs.LinkedList;

/**
 * @author 212393859
 *
 */
public class LinkedListTest{

	LinkedList ll = new LinkedList();
	
	@Test
	public void testFindMedian() {
		//Circular sorted LL with values which are even nos   2->6>16->20->22->24		
		
		ListNode node2 = new ListNode(2);
		ListNode node6 = new ListNode(6);
		ListNode node16 = new ListNode(16);
		ListNode node20 = new ListNode(20);
		ListNode node22 = new ListNode(22);
		ListNode node24 = new ListNode(24);
		
		node2.next = node6;
		node6.next = node16;
		node16.next = node20;
		node20.next = node22;
		node22.next = node24;
		node24.next = node2;
		
		int median = ll.findMedian(node6);
		
		Assert.assertEquals(18, median);
		
	}
	
	@Test
	public void testAddNumbers(){
		ListNode n2 = new ListNode(2);
		ListNode n1_1 = new ListNode(1);
		n2.next = n1_1;
		
		ListNode n4 = null;
		
		
		ll.addNumbers(n2, n4);
	}
	
	@Test
	public void testZipGivenLinkedList() {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		ListNode result = ll.zip_given_linked_list(node1);
		
		
	}
	
	@Test
	public void testMaxLengthOFMatchingParanthesis(){
		int result = ll.find_max_length_of_matching_parentheses("((((())(((()");
	}
}
