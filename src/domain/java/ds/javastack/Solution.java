package domain.java.ds.javastack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);
        List<Character> closeList = new ArrayList<Character>();
        closeList.add(')');
        closeList.add('}');
        closeList.add(']');
        while (sc.hasNext()) {
            Stack<Character> stack = new Stack<Character>();
            boolean balanced = true;
            String input=sc.nextLine();
            System.out.println(input);
            char[] braces = input.toCharArray();
            for (int i = 0; i < braces.length; i++) {
                if (closeList.contains(braces[i])) {
                    if (stack.empty()) {
                        balanced = false;
                        break;
                    }
                    char popped = stack.pop();
                    if (((int)braces[i] != popped + 1) && ((int)braces[i] != popped + 2)) {
                        balanced = false;
                        break;
                    }
                }
                else {
                    stack.push(braces[i]);              
                }
            }
            System.out.println(balanced ? stack.empty() : false);            
        }
        sc.close();
    }
}
