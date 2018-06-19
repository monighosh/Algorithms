/**
 * 
 */
package ik.dataStructure;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

/**
 * @author 212393859
 *
 */
public class MaxHeapTest {

	
	@Test
	public void testInsertHeap() {
		ArrayList<Integer> heap = new ArrayList<Integer>(Arrays.asList(40, 15, 22, 13, 8));

		MaxHeap maxHeap = new MaxHeap(heap);

		maxHeap.insertIntoHeap(45);
		
		int N = 3;
		System.out.println("TOP "+N+" elements are:");
		for(int i =0; i<N;i++){
			System.out.println(heap.get(i));
		}

	}
	
	@Test
	public void testBuildHeap() {
		ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(3, 1, 6, 5, 2, 4));

		MaxHeap maxHeap = new MaxHeap(array);

	}

	@Test
	public void testDeleteFromHeap() {

		ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(40, 18, 20, 15, 13, 9, 19, 1, 3, 8));

		MaxHeap maxHeap = new MaxHeap(array);

		maxHeap.deleteFromHeap();
	}
}
