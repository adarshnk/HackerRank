package sort;

public class MergeSort {

	public static void main(String[] args) {

		int[] a = { 5, 1, 6, 2, 3, 4 };
		
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
		
		mergeSort(a, a.length);
		
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
	}
	
	public static void mergeSort(int[] a, int length) {
		
		if (length < 2)
			return;
		
		int mid = length / 2;
		int l[] = new int[mid];
		int r[] = new int[length - mid];
		
		for (int i = 0; i < mid; i++)
			l[i] = a[i];
		
		for (int i = mid; i < length; i++)
			r[i - mid] = a[i];
		
		mergeSort(l, l.length);
		mergeSort(r, r.length);
		merge(a, l, r, mid, length - mid);
	}
	
	public static void merge(int[] a, int[] l, int[] r, int left, int right) {
		
		int i = 0, j = 0, k = 0;
		
		while (i < left && j < right) {
			if (l[i] <= r[j])
				a[k++] = l[i++];
			else
				a[k++] = r[j++];
		}
		
		while (i < left) {
			a[k++] = l[i++];
		}
		
		while (j < right) {
			a[k++] = r[j++];
		}
	}
}
