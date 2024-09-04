import java.util.Scanner;
// dfs
public class Solution {

	static int N, max, min;
	static int[][] board;
	static boolean[][] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			board = new int[N][N];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					board[r][c] = sc.nextInt();
				}
			}

			int maxCnt = 1; // dfs를 가장 많이 돈 횟수 = 덩어리가 가장 많은 횟수
			for (int day = 1; day <= 100; day++) {
				visit = new boolean[N][N]; // 방문 배열은 날이 지날 때마다 초기화

				int cnt = 0; // dfs를 돈 횟수

				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (visit[r][c] || board[r][c] <= day)
							continue;
						dfs(day, r, c);
						cnt++;
					}
				}
				maxCnt = Math.max(maxCnt, cnt);

			}
			System.out.println("#" + tc + " " + maxCnt);
		} // tc
	}// main

	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	// r,c를 방문한 상태에서 상하좌우를 탐색 -> 갈수있으면 재귀적으로 dfs 호출
	static void dfs(int day, int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (0 <= nr && nr < N && 0 <= nc && nc < N && !visit[nr][nc] && board[nr][nc] > day) {
				visit[nr][nc] = true;
				dfs(day, nr, nc);
			}
		}

	}
}
