package allcontests.primenumber;

import java.util.Scanner;

public class Solution {
	public static void isPrime(int n) {
		if(n < 1)
			System.out.println("Not prime");
		for(int i = 2; i < n/2; i++) {
			if((n % i) == 0) {
				System.out.println("Not prime");
				return;
			}
		}
		System.out.println("Prime");
	}
	
	public static void main(String args[]) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			int T = sc.nextInt();
			int[] input = new int[T];
			int i = 0;
			while (T-- > 0) {
				input[i++] = sc.nextInt();
			}
			for(i = 0; i < input.length; i++)
				isPrime(input[i]);
		} finally {
			if (sc != null)
				sc.close();
		}
	}
}
