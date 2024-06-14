package allcontests.marsexploration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Result {

	/*
	 * Complete the 'marsExploration' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts STRING s
	 * as parameter.
	 */

	public static int marsExploration(String s) {

		String correctSOS = "SOS";
		
		int result = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != correctSOS.charAt(i%3))
				result++;
		}
		
		return result;
	}
}

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = bufferedReader.readLine();

		int result = Result.marsExploration(s);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
