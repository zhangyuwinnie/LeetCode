import java.util.Arrays;

public class QuickSort {
	public void sortInteger(int[] A){
		quickSort(A, 0, A.length -1);
	}
	
	public void quickSort(int[] A, int start, int end){//[4,3,3,7],0,3
		if (start >= end){
			return;
		}
		int left = start;
		int right = end;
		int pivot = A[(start + end)/2];
		while (left <= right){
			while (left <= right && A[left] < pivot){
				left++;
			}
			while (left <= right && A[right] > pivot){
				right--;
			}
			if (left <= right){
				int temp = A[left];
				A[left] = A[right];
				A[right] = temp;
				left++; //!!!
				right--;  //!!!ss
			}
		}
		quickSort(A, start, right);
		quickSort(A, left, end);
	}
	
	public static void main (String[] args){
		QuickSort test = new QuickSort();
		int[] A = {4,3,7};
		test.sortInteger(A);
		System.out.println(Arrays.toString(A));
	}
}