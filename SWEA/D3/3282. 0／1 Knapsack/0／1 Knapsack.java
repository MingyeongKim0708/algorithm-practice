import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 물건의 개수
			int K = Integer.parseInt(st.nextToken()); // 가방의 부피

			// 각 물건별 부피, 가치 넣기
			int[][] item = new int[N + 1][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				item[i][0] = Integer.parseInt(st.nextToken()); // 부피
				item[i][1] = Integer.parseInt(st.nextToken()); // 가치
			}

			// DP
			int dp[][] = new int[N + 1][K + 1];
			for (int i = 0; i < N; i++) {
				int volume = item[i][0];
				int cost = item[i][1];

				// 이전에 구한 최적해 vs 갱신하는 값
				for (int v = 0; v <= K; v++) {
					dp[i + 1][v] = dp[i][v];
					if (v >= volume) {
						dp[i + 1][v] = Math.max(dp[i][v], dp[i][v - volume] + cost);
					}
				}
			}
			
			bw.write("#" + tc + " " + dp[N][K] + "\n");

		} // tc

		bw.flush();
		bw.close();
	}// main

}
