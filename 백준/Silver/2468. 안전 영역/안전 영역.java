import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N;
	static int[][] ground;
	static boolean[][] visit;
	static int answer;

	static int[] dr = { 1, 0, -1, 0 }; // 하 우 상 좌
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		N = stoi(br.readLine());

		ground = new int[N][N];

		int max = 0; // 최대 강수량

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				ground[i][j] = stoi(st.nextToken());

				if (ground[i][j] > max) {
					max = ground[i][j];
				}
			}
		}

		answer = 0;

		for (int amount = 0; amount < max; amount++) { // 강수량 진행
			visit = new boolean[N][N];
			int newCnt = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (ground[i][j] > amount && visit[i][j] == false) { // 강수량보다 위치가 높고 방문한 적 없다
						bfs(i, j, amount);
						newCnt++; // bfs 탐색이 끝날 때마다 땅 한덩어리
					}
				}
			}

			// 땅 덩어리 개수 갱신
			if (newCnt > answer) {
				answer = newCnt;
			}

		} // 강수량
		
		bw.write(answer + "");
		bw.flush();
	}

	private static void bfs(int r, int c, int h) {
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { r, c });
		visit[r][c] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];

				// 범위 밖, 방문한 적 있음, 높이가 강수량보다 같거나 낮음 -> 탐색 X
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visit[nr][nc] || ground[nr][nc] <= h) {
					continue;
				}

				// 갈수있는 곳
				visit[nr][nc] = true;
				q.add(new int[] { nr, nc });
			}

		}

	}

	private static int stoi(String line) {
		return Integer.parseInt(line);
	}

}
