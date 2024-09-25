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
			int N = Integer.parseInt(st.nextToken()); // 재료 개수
			int L = Integer.parseInt(st.nextToken()); // 제한 칼로리

			// 각 재료별 점수, 칼로리 입력
			int board[][] = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				board[i][0] = Integer.parseInt(st.nextToken()); // 점수
				board[i][1] = Integer.parseInt(st.nextToken()); // 칼로리
			}

			// DP
			// DP를 할 때 0은 아무 재료도 안 넣은 상태
			// 최종적으로 N개가 모두 들어갔을 때의 결과를 구해야하므로 N+1행 필요함
			// 칼로리도 마찬가지로 L까지 다 채워졌을 때의 값을 구해야하므로 L+1열 필요함
			int dp[][] = new int[N + 1][L + 1];
			for (int i = 0; i < N; i++) {
				int score = board[i][0];
				int cal = board[i][1];

				// 칼로리를 1씩 증가시키면서 어떤 경우가 점수가 높은지 비교
				// 이전 단계의 최적해를 가져온 것 vs 새로 갱신하는 것
				// i+1이 실질적으로 지금 내가 갱신하고 있는 답이라고 생각하면 됨 (i=0부터 시작하므로)
				for (int c = 0; c <= L; c++) {
					dp[i + 1][c] = dp[i][c];
					if (c >= cal) {
						dp[i + 1][c] = Math.max(dp[i][c], dp[i][c - cal] + score);
					}
				}
			}

			// 가장 마지막에 있는 것이 최적해
			bw.write("#" + tc + " " + dp[N][L]+"\n");
		} // tc
		bw.flush();
		bw.close();
	}
}
