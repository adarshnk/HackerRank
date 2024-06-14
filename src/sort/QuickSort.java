package sort;

public class QuickSort {

	public static void main(String[] args) {

		int[] a = { 5, 1, 6, 2, 3, 4 };
		
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
		
		quickSort(a, 0, a.length - 1);
		
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
	}
	
	public static void quickSort(int[] a, int begin, int end) {
		
		if (begin < end) {
			int pivotIndex = partition(a, begin, end);
			
			quickSort(a, begin, pivotIndex - 1);
			quickSort(a, pivotIndex + 1, end);
		}
	}
	
	public static int partition(int[] a, int begin, int end) {
		
		int pivot = a[end];
		int i = begin - 1;
		
		for (int j = begin; j < end; j++) {
			if (a[j] <= pivot) {
				i++;
				
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		
		int temp = a[i+1];
		a[i+1] = a[end];
		a[end] = temp;
		
		return i + 1;
	}
}
