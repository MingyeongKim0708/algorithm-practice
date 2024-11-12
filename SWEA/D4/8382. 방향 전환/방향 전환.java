import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb;
	static StringTokenizer st;

	static int T, x1, y1, x2, y2, dir;
	static int[][] map;
	static boolean[][] visit;
	static int count, answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken()) + 100; // 배열 크기에 맞추기 위해 +100
			y1 = Integer.parseInt(st.nextToken()) + 100;
			x2 = Integer.parseInt(st.nextToken()) + 100;
			y2 = Integer.parseInt(st.nextToken()) + 100;

			map = new int[201][201];
			map[y1][x1] = 1;
			map[y2][x2] = 2;

			int case1 = bfs(y1, x1, 0); // (x1, y1)에서 시작. 방향 0 (가로 시작)
			int case2 = bfs(y1, x1, 1); // (x1, y1)에서 시작. 방향 1 (세로 시작)

			// 둘 중에 더 적은 걸 골라야 함
			answer = Math.min(case1, case2);

			sb.append(answer).append("\n");
		} // tc

		sb.setLength(sb.length() - 1);
		bw.write(sb.toString());
		bw.flush();

	} // main

	static int[] drGaro = { 0, 0 }; // r 가만히
	static int[] dcGaro = { 1, -1 };

	static int[] drSero = { 1, -1 };
	static int[] dcSero = { 0, 0 }; // c 가만히

	private static int bfs(int r, int c, int dir) {
		count = 0;
		visit = new boolean[201][201];
		visit[y1][x1] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c, dir, 0 }); // 좌표, 방향, 이동 횟수

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int currR = curr[0], currC = curr[1], currDir = curr[2], moves = curr[3];

			// 목적지 도착
			if (currR == y2 && currC == x2) {
				return moves;
			}

			// 현재 방향에 따라 다음 이동 설정
			if (currDir == 0) { // 가로 이동 후 세로 방향으로 전환
				for (int i = 0; i < 2; i++) {
					int nr = currR + drSero[i];
					int nc = currC + dcSero[i];

					if (nr >= 0 && nr < 201 && nc >= 0 && nc < 201 && !visit[nr][nc]) {
						visit[nr][nc] = true;
						q.add(new int[] { nr, nc, 1, moves + 1 }); // 세로 방향으로 전환
					}
				}
			} else {
				for (int i = 0; i < 2; i++) {
					int nr = currR + drGaro[i];
					int nc = currC + dcGaro[i];

					if (nr >= 0 && nr < 201 && nc >= 0 && nc < 201 && !visit[nr][nc]) {
						visit[nr][nc] = true;
						q.add(new int[] { nr, nc, 0, moves + 1 }); // 가로 방향으로 전환
					}
				}
			}

		}

		// 못가는 경우
		return Integer.MAX_VALUE;
	}
}
