import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	// 제발 M, N 가 어떤 것을 가리키고 있는지 어떤 순서로 값이 들어오는지 잘 확인하자
	static int M, N, K; // 가로, 세로, 배추 위치의 개수
	static int[][] farm;
	static boolean[][] visit;
	static int answer; // 배추흰지렁이 마리 수

	// 전체를 다 돌면서 방문한 적 없는 1이면 dfs든 bfs든 실행해서 종료할 때마다 지렁이 수 +1
	public static void main(String[] args) throws Exception {

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			farm = new int[N][M];

			for (int i = 0; i < K; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st2.nextToken());
				int B = Integer.parseInt(st2.nextToken());

				farm[B][A] = 1;
			}

			answer = 0;

			// 이미 방문한 것은 dfs를 시작할 필요가 없도록 방문 체크
			visit = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (farm[i][j] == 1 && !visit[i][j]) {
						dfs(i, j);
						answer++; // dfs가 끝난 후 지렁이 수 +1
					}
				}
			}

			System.out.println(answer);

		}
	}

	// 델타 배열 : 하, 우, 상, 좌
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	private static void dfs(int r, int c) {
		if (farm[r][c] == 0 || visit[r][c])
			return;

		visit[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visit[nr][nc] && farm[nr][nc] == 1) {
				dfs(nr, nc);
			}
		}
	}

}
