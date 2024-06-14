package oneweekprepkit;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

class Result {

	/*
	 * Complete the 'plusMinus' function below.
	 *
	 * The function accepts INTEGER_ARRAY arr as parameter.
	 */

	public static void plusMinus(List<Integer> arr) {

		double pCount = 0, nCount = 0, zCount = 0, totalCount = arr.size();
		for (int i : arr) {
			if (i == 0)
				zCount++;
			else if (i > 0)
				pCount++;
			else
				nCount++;
		}
		
		System.out.printf("%.5f\n", pCount/totalCount);
		System.out.printf("%.5f\n", nCount/totalCount);
		System.out.printf("%.5f", zCount/totalCount);
	}

}

public class PlusMinus {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		Result.plusMinus(arr);

		bufferedReader.close();
	}
}
