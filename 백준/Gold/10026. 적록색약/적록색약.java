import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N;
	static char[][] color;
	static boolean[][] visit;

	static int[] dr = { 1, 0, -1, 0 }; // 하 우 상 좌
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		N = stoi(br.readLine());

		color = new char[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			color[i] = br.readLine().toCharArray();
		}

		// 적록색약이 아닌 사람
		int cntA = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {
					bfsA(i, j, color[i][j]);
					cntA++;
				}
			}
		}

		// 초기화
		visit = new boolean[N][N];

		// 적록색약인 사람 - 아직 X
		int cntB = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {
					bfsB(i, j, color[i][j]);
					cntB++;
				}
			}
		}

		bw.write(cntA + " " + cntB);
		bw.flush();
	}

	private static void bfsA(int r, int c, char letter) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });

		visit[r][c] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];

				// 범위 밖, 방문한 적 있음, 글자가 다름
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visit[nr][nc] || color[nr][nc] != letter) {
					continue;
				}

				// 갈수있는 곳
				visit[nr][nc] = true;
				q.add(new int[] { nr, nc });
			}

		}

	}

	private static void bfsB(int r, int c, char letter) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });

		visit[r][c] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];

				// 범위 밖, 방문한 적 있음
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visit[nr][nc]) {
					continue;
				}

				// 적록색약: R과 G를 같은 색으로 취급
				if (letter == 'R' || letter == 'G') {
					if (color[nr][nc] == 'B')
						continue; // B는 다른 색으로 처리
				} else if (letter == 'B') {
					if (color[nr][nc] != 'B')
						continue; // B가 아닌 색은 다르게 처리
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
