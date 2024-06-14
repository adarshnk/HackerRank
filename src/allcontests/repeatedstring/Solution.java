package allcontests.repeatedstring;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Result {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

	public static long repeatedString(String s, long n) {

		// Get length of string
		int len = s.length();
		// Number of times pattern repeats
		long numFullPatterns = n / len;
		// Remaining characters after pattern repeat
		long rem = n % len;
		
		long totalAs = numAsInPattern(s) * numFullPatterns;

		if (rem == 0) {
			return totalAs;
		} else {
			String substr = s.substring(0, (int) rem);
			return totalAs + numAsInPattern(substr);
		}

	}

	public static int numAsInPattern(String s) {

		int count = 0;
		for (char c : s.toCharArray()) {
			if ('a' == c)
				count++;
		}

		return count;
	}
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

