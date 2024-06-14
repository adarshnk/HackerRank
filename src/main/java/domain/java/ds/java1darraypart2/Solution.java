package domain.java.ds.java1darraypart2;

import java.util.Scanner;

public class Solution {
	public static void main(String args[]) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			int cases = sc.nextInt();
			for (int i = 0; i < cases; i++) {
				int size = sc.nextInt();
				int[] arr = new int[size];
				int jump = sc.nextInt();
				for (int j = 0; j < size; j++) {
					arr[j] = sc.nextInt();
				}
				System.out.println(canFinish(0, arr, jump) ? "YES" : "NO");
			}
		}
		finally {
			if (sc != null)
				sc.close();
		}
	}
	
	public static boolean canFinish(int startIndex, int arr[], int jump) {
		boolean canFinish = false;
		if (startIndex + jump >= arr.length)
			canFinish = true;
		else {
			int nextNumber = arr[startIndex + 1];
			if (nextNumber == 0) {
				canFinish = canFinish(startIndex + 1, arr, jump);
			}
		}
		return canFinish;
	}
}

class Output {
	double[][] a;
}
