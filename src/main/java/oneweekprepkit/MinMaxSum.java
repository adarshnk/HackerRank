package oneweekprepkit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Result1 {

	/*
	 * Complete the 'miniMaxSum' function below.
	 *
	 * The function accepts INTEGER_ARRAY arr as parameter.
	 */

	public static void miniMaxSum(List<Integer> arr) {

		long allSum = 0, min = arr.get(0), max = arr.get(0);
		for (int i : arr) {
			allSum = allSum + i;
			if (i <= min)
				min = i;
			if (i >= max)
				max = i;
		}
		System.out.println((allSum - max) + " " + (allSum - min));
	}

}

public class MinMaxSum {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(Collectors.toList());

		Result1.miniMaxSum(arr);

		bufferedReader.close();
	}
}
