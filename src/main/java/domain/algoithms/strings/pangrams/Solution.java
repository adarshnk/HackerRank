package domain.algoithms.strings.pangrams;

import java.util.Scanner;

public class Solution {
	public static void main(String args[]) {
		String[] s = new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		Scanner sc = new Scanner(System.in);
		try {
		    String input = sc.nextLine();
		    input = input.toLowerCase().trim();
		    for (int i = 0; i < s.length; i++) {
		        if (!input.contains(s[i])) {
		        	System.out.println("not pangram");
		            return;
		        }
		    }
		    System.out.println("pangram");
		}
		finally {
			sc.close();
		}
	}
}
