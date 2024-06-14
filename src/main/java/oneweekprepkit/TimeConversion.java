package oneweekprepkit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Result2 {

	/*
	 * Complete the 'timeConversion' function below.
	 *
	 * The function is expected to return a STRING. The function accepts STRING s as
	 * parameter.
	 */

	public static String timeConversion(String s) {

		if (!s.matches("[\\d]{2}\\:[\\d]{2}\\:[\\d]{2}(AM|PM)")) {
			return null;
		}

		String[] timeComponents = s.split(":");
		System.out.println(timeComponents[0] + ":" + timeComponents[1] + ":" + timeComponents[2]);
		if (timeComponents[2].endsWith("PM") && Integer.valueOf(timeComponents[0]) < 12) {
			timeComponents[0] = String.valueOf(Integer.valueOf(timeComponents[0]) + 12);
		} else if (timeComponents[2].endsWith("AM") && Integer.valueOf(timeComponents[0]) == 12) {
			timeComponents[0] = "00";
		} else {
			// Do nothing
		}

		return timeComponents[0] + ":" + timeComponents[1] + ":" + timeComponents[2].substring(0, 2);
	}

}

public class TimeConversion {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = bufferedReader.readLine();

		String result = Result2.timeConversion(s);

//		bufferedWriter.write(result);
//		bufferedWriter.newLine();

		bufferedReader.close();
//		bufferedWriter.close();
		System.out.println(result);
	}
}
