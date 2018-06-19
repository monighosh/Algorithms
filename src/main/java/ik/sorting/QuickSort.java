/**
 * 
 */
package ik.sorting;

/**
 * @author 212393859
 *
 */
public class QuickSort {
	
	
	
	public void quickSort(int[] a, int start, int end){
		
		/*
		 * Equivalent to if(start >= end)
							return;
			If cases are split for clarity
		 */
		if(start == end)  //array size is 1
			return;
		if(start > end)  // can also be written as if(start == end+1) -> since there cannot be a case where start == end+2 or high
			return; 
		
		
		int pivotIndex = choosePivot(a, start, end);
		
		int paritionedPivotIndex = partition(a, start,end,pivotIndex);
		
		quickSort(a, start, paritionedPivotIndex-1);
		quickSort(a, paritionedPivotIndex+1, end);
		
	}
	
	public int choosePivot(int[] a, int start, int end){
		int pivotIndex = 0;
		
		
		return pivotIndex;
	}
	
	public int partition(int[] a , int start, int end, int pivot){
		int paritionedPivotIndex = 0;
		
		
		return paritionedPivotIndex;
	}

}
