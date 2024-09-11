import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int N;
	static int[][] cheese;
	static boolean[][] visit;
	static int maxCheese; // 가장 큰 치즈 사이즈

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			cheese = new int[N][N];
			maxCheese = 0;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int idx = 0;
				while (st.hasMoreTokens()) {
					cheese[i][idx] = Integer.parseInt(st.nextToken());
					if (cheese[i][idx] > maxCheese) {
						maxCheese = cheese[i][idx];
					}
					idx++;
				}
			} // 치즈 입력

			// 치즈 배열 확인
//			for (int[] i : cheese) {
//				System.out.println(Arrays.toString(i));
//			}
//
//			// 가장 큰 치즈 사이즈
//			System.out.println(maxCheese);
//			System.out.println("-------------");

			// dfs를 가장 많이 돈 횟수 = 덩어리가 가장 많은 횟수
			int answer = 1;

			for (int day = 1; day <= maxCheese; day++) {
				visit = new boolean[N][N]; // 방문 배열은 날마다 초기화해야한다.

				int count = 0; // dfs를 돈 횟수

				// 치즈 먹기
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {

						// 방문했거나 해당 치즈 크기가 오늘 날짜보다 작으면 이미 0이라는 뜻이므로 체크할 필요가 없다
						if (visit[r][c] || cheese[r][c] <= day)
							continue;

						dfs(day, r, c);
						count++;

					}
				}
				answer = Math.max(answer, count);
			} // 1~maxCheese

			System.out.println("#" + tc + " " + answer);

		} // tc

	}// main
	

	static int[] dr = { 1, 0, -1, 0 }; // 하 우 상 좌
	static int[] dc = { 0, 1, 0, -1 };

	private static void dfs(int day, int r, int c) {

		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];

			// 범위를 벗어나지 않고 방문한 적이 없고 day보다 치즈의 크기가 커야한다
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visit[nr][nc] && cheese[nr][nc] > day) {
				visit[nr][nc] = true;
				dfs(day, nr, nc);

			}

		}
	}

}

