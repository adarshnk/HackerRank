package domain.algoithms.strings.gameofthrones1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        String inputString = myScan.nextLine();
       
        String ans = "NO";
        
        char[] characters = inputString.toCharArray();
        int oddCharCount = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < characters.length; i++) {
            char c = characters[i];
            if (map.containsKey(c)) {
                int count = map.get(c);
                count += 1;
                map.put(c, count);
                if (count % 2 != 0)
                    oddCharCount++;
                else
                    oddCharCount--;
            }
            else {
                map.put(c, 1);
                oddCharCount++;
            }
        }
        if (map.keySet().size() == 1)
            ans = "YES";
        else if (map.keySet().size() != 1 && oddCharCount > 1)
            ans = "NO";
        else
        	ans = "YES";
        System.out.println(ans);
        myScan.close();
    }
}