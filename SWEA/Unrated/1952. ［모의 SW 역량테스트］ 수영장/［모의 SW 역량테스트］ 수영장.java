import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dayP = Integer.parseInt(st.nextToken());
			int oneP = Integer.parseInt(st.nextToken());
			int threeP = Integer.parseInt(st.nextToken());
			int yearP = Integer.parseInt(st.nextToken());

			// 1차원 배열로 바꿔보기
			// 냅색 문제랑 다르게 이용권의 개수가 늘어날 필요가 없기 때문에 이전 행에서 구한 최적해에 요금을 더하는 개념이 아님

			// 이용 계획(1일권만 이용하는 경우 누적합X)
			int[] day = new int[13];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < 13; i++) {
				day[i] = Integer.parseInt(st.nextToken()) * dayP;
			}

			int[][] dp = new int[5][13];

			// 1일권만 모두 사용하는 경우
			for (int i = 1; i < 13; i++) {
				dp[1][i] = day[i] + dp[1][i - 1];
			}

			// 1달권 케이스 먼저 구하기
			// 1일권만 사용하는 경우 vs 1일권 + 1달권을 사용하는 경우 vs 1달권 사용하는 경우
			for (int i = 1; i < 13; i++) {
				// 1일권 vs 1달권과의 비교 vs 갱신값+1달권 vs 갱신값+1일권
				// dp[2][i] = Math.min(dp[2][i-1] + day[i], Math.min(dp[2][i-1] + oneP,
				// Math.min(dp[1][i], dp[1][i-1] + oneP)));;
				dp[2][i] = Math.min(dp[2][i - 1] + day[i], dp[2][i - 1] + oneP);
			}

			// 직전값 + 1일권 / 직전값 + 1달권 / 직전값 + 3달권
			for (int i = 1; i < 13; i++) {
				dp[3][i] = dp[2][i];
				if (i >= 3) {
					dp[3][i] = Math.min(dp[3][i - 3] + threeP, Math.min(dp[3][i - 1] + day[i], dp[3][i - 1] + oneP));
				}
			}

			int answer = 0;
			// 1년이랑 비교
			if (dp[3][12] < yearP) {
				answer = dp[3][12];
			} else {
				answer = yearP;
			}

			// 코드 리팩토링 - 1차원 배열로 풀기 - 50개 중에 48개 맞춤
			int[] cost = new int[13];
			for (int i = 1; i <= 12; i++) {
				if (day[i] != 0) {
					int minCost = 0;

					// 1일권만 사용
					cost[i] = day[i] + cost[i - 1];
					minCost = cost[i];

					// 1일권 vs 1달권 사용
					minCost = Math.min(minCost, cost[i - 1] + oneP);

					// 이전 값 vs 3달권 사용
					if (i >= 3) {
						minCost = Math.min(minCost, cost[i - 3] + threeP);
					} else {
						minCost = Math.min(minCost, threeP);
					}

					cost[i] = minCost;

				} else {
					cost[i] = cost[i - 1]; // 사용일이 없는 경우에는 이전 값을 그대로 가져감
				}

				// 최종적으로 1년권과 비교하여 최소 비용 선택
				answer = Math.min(cost[12], yearP);
			}

			bw.write("#" + tc + " " + answer + "\n");

			// System.out.println("#" + tc + " " + answer);
			System.out.println("#" + tc + " " + answer);

			// System.out.println(Arrays.toString(day));
			// System.out.println("---------");
			// for (int[] c : dp) {
			// System.out.println(Arrays.toString(c));
			// }

		} // tc

		bw.flush();
		bw.close();
	}// main
}
