import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, M;

	static char[][] map; // 미로
	static boolean[][] visited; // 방문배열
	static int[][] dist; // 경로길이 저장

	public static void main(String[] args) throws Exception {

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new boolean[N][M];
		dist = new int[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		bfs(0, 0);

		System.out.println(dist[N - 1][M - 1] + 1);

	}

	static int dr[] = { 1, 0, 0, -1 };
	static int dc[] = { 0, -1, 1, 0 };

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });
		visited[r][c] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == '1' && !visited[nr][nc]) {
					visited[nr][nc] = true;
					dist[nr][nc] = dist[now[0]][now[1]] + 1;
					q.add(new int[] { nr, nc });
				}
			}
		}

	}

}
