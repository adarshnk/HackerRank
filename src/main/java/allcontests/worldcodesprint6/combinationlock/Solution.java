package allcontests.worldcodesprint6.combinationlock;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inp[] = new int[5];
        for (int i = 0; i < 5; i++) {
            inp[i] = sc.nextInt();
        }
        int ops = 0;
        for (int i = 0; i < 5; i++) {
            ops += ops(inp[i], sc.nextInt());
        }
        System.out.println(ops);
        sc.close();
    }
    
    public static int ops(int in, int out) {
        int steps = 0;
        if (in != out) {
            int i = in, o = out, count = 0;
            while (i != o) {
            	if (i == 9)
            		i = 0;
            	else
            		i = ++i%10;
                count++;
            }
            steps = count;
            i = in;
            o = out;
            count = 0;
            while (i != o) {
                if (i == 0)
                	i = 9;
                else
                	i = --i%10;
                count++;
            }
            steps = count < steps ? count : steps;
        }
        return steps;
    }
}