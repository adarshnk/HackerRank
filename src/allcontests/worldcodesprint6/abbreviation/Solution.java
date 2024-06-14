package allcontests.worldcodesprint6.abbreviation;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int queries = Integer.valueOf(sc.nextLine());
        for (int i = 0; i < queries; i++) {
            String input = sc.nextLine();
            String output = sc.nextLine();
            canConvert(input, output);
        }
        sc.close();
    }
    
    public static void canConvert(String in, String out) {
        for (int i = 0; i < out.length(); i++) {
            String replace = Character.toString(out.charAt(i)).toLowerCase();
            in = in.replaceAll(replace, "");
        }
        // System.out.println(in);
        while(!in.isEmpty()) {
        	char c = in.charAt(0);
        	String s = Character.toString(c);
        	if (c > 90) {
        		in = in.replaceAll(s, "");
        	} else {
        		if (!out.contains(s)) {
        			System.out.println("NO");
        			break;
        		}
        		in = in.replaceFirst(s, "");
        		if (in.contains(s)) {
        			System.out.println("NO");
        			break;
        		}
        	}
        }
        if (in.isEmpty())
        	System.out.println("YES");
    }
}