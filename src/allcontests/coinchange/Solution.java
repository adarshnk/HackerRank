package allcontests.coinchange;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class Result {

	/*
	 * Complete the 'getWays' function below.
	 *
	 * The function is expected to return a LONG_INTEGER. The function accepts
	 * following parameters: 1. INTEGER n 2. LONG_INTEGER_ARRAY c
	 */

	public static long getWays(int n, List<Long> c) {

		// Sort the coins in ascending order
		Collections.sort(c);

		long[][] coinChange = new long[c.size()][n + 1];

		// Fill the first row
		for (int j = 0; j < (n + 1); j++) {
			coinChange[0][j] = (j % c.get(0) == 0) ? 1 : 0;
		}
		// Second row onwards
		for (int i = 1; i < c.size(); i++) {
			long currentCoinValue = c.get(i);
			for (int j = 0; j < (n + 1); j++) {
				if (j < currentCoinValue) {
					coinChange[i][j] = coinChange[i - 1][j];
					continue;
				}
				coinChange[i][j] = coinChange[i - 1][j] + coinChange[i][(int) (j - currentCoinValue)];
			}
		}
		// Write your code here
		return coinChange[c.size() - 1][n];
	}

}

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int m = Integer.parseInt(firstMultipleInput[1]);

		List<Long> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Long::parseLong)
				.collect(toList());

		// Print the number of ways of making change for 'n' units using coins having
		// the values given by 'c'

		long ways = Result.getWays(n, c);

		System.out.println(ways);
//			bufferedWriter.write(String.valueOf(ways));
//			bufferedWriter.newLine();

		bufferedReader.close();
//			bufferedWriter.close();

	}
}
