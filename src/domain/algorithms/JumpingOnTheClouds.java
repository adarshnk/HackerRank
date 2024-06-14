package domain.algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

class Result {

	/*
	 * Complete the 'jumpingOnClouds' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * INTEGER_ARRAY c as parameter.
	 */

	public static int jumpingOnClouds(List<Integer> c) {

		int indexToReach = c.size() - 1;
		int curIndex = 0;
		int numberOfHops = 0;
		while (curIndex < indexToReach) {
			int tempCurIndex = curIndex + 2;
			if (tempCurIndex <= indexToReach && c.get(curIndex + 2) == 0) {
				curIndex += 2;
			} else {
				curIndex += 1;
			}
			numberOfHops += 1;
		}
		return numberOfHops;
	}

}

public class JumpingOnTheClouds {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		String[] cTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		List<Integer> c = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int cItem = Integer.parseInt(cTemp[i]);
			c.add(cItem);
		}

		int result = Result.jumpingOnClouds(c);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
