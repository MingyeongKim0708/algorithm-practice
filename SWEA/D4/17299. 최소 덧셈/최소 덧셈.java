import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			int answer = Integer.MAX_VALUE;

			for (int i = 0; i < str.length() - 1; i++) {
				String num1 = str.substring(0, i + 1);
				String num2 = str.substring(i + 1);
				int n1 = Integer.parseInt(num1);
				int n2 = Integer.parseInt(num2);
				int temp = n1 + n2;

				if (temp < answer)
					answer = temp;
			}

			bw.write("#" + tc + " " + answer + "\n");

		} // tc
		bw.flush();
		bw.close();

	}// main
}
