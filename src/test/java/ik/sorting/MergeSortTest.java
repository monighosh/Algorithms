/**
 * 
 */
package ik.sorting;

import org.junit.Test;

/**
 * @author 212393859
 *
 */
public class MergeSortTest {
	
	MergeSort mergeSort = new MergeSort();
	

	@Test
	public void testMergeSort(){
		int[] a = {10,5,15,1,0,7,16,0};
		
		mergeSort.mergeSort(a, 0, a.length-1);
		
		System.out.println(a.toString());
	}
}
