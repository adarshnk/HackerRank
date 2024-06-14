package allcontests.worldcodesprint6.bonappetit;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfItems = sc.nextInt();
        int k = sc.nextInt();
        int cost[] = new int[noOfItems];
        for (int i = 0; i < noOfItems; i++) {
            cost[i] = sc.nextInt();
        }
        int charged = sc.nextInt();
        int totalCost = 0;
        for (int i = 0; i < noOfItems; i++) {
            if (i == k)
                continue;
            totalCost += cost[i];
        }
        if (charged == totalCost/2) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println(charged - totalCost/2);
        }
        sc.close();
    }
}