import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb;

	static int T, k, n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();

		for (int tc = 0; tc < T; tc++) {
			k = Integer.parseInt(br.readLine());
			n = Integer.parseInt(br.readLine());

			int[][] dp = new int[15][15];

			for (int i = 0; i < 15; i++) {
				dp[0][i] = i;
			}

			for (int i = 1; i <= k; i++) {
				for (int j = 1; j <= n; j++) {
					dp[i][j] += dp[i][j - 1] + dp[i - 1][j];
				}
			}

			sb.append(dp[k][n]).append("\n");

		} // tc
		sb.setLength(sb.length() - 1);
		bw.write(sb.toString());
		bw.flush();
	}
}

// 1층 3호 : 1+2+3 = 6
// 2층 3호 : 10 (1층1호+1층2호+1층3호) (1+3+6)