/**
 * 
 */
package ik.sorting;

/**
 * @author 212393859
 *
 */
public class MergeSort {

	
	public void mergeSort(int[] a, int start, int end) {

		if (start == end)
			return;
		if (start == end + 1)
			return;

		int mid = start + (end - start) / 2;

		/*
		 * Splitting it into left & right arrays ard mid
		 */
		mergeSort(a, start, mid);
		mergeSort(a, mid + 1, end);

		merge(a, start, end, mid);
	}

	private void merge(int[] a, int start, int end, int mid) {

		int[] leftArray = new int[mid - start + 1];
		int[] rightArray = new int[end - mid];

		int left = 0;
		int right = 0;

		// Copy elements into right & left array
		for (int i = start; i <= mid; i++) {
			leftArray[left] = a[i];
			left++;
		}
		for (int i = mid + 1; i <= end; i++) {
			rightArray[right] = a[i];
			right++;
		}

		int leftSize = leftArray.length;
		int rightSize = rightArray.length;

		int lIndex = 0;
		int rIndex = 0;
		int k = start;

		//Compare elements in left & right array & populate the original array
		while (lIndex < leftSize && rIndex < rightSize) {

			if (leftArray[lIndex] <= rightArray[rIndex]) {  //Merge sort is stable due to the equal sign. It maintains the order of the duplicates since it picks the left first
				a[k] = leftArray[lIndex];
				lIndex++;
			} else {
				a[k] = rightArray[rIndex];
				rIndex++;
			}

			k++;
		}

		while (lIndex < leftSize) {
			a[k] = leftArray[lIndex];
			lIndex++;
			k++;
		}

		while (rIndex < rightSize) {
			a[k] = rightArray[rIndex];
			rIndex++;
			k++;
		}

	}
}
