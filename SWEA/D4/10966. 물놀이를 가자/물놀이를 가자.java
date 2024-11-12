import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution{

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb;
	static StringTokenizer st;

	static int T, N, M;
	static char[][] map;
	static int[][] dis;
	static Queue<int[]> q;

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new char[N][M];
			dis = new int[N][M]; // 최단거리 값을 저장할 배열
			q = new LinkedList<>();

			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
				Arrays.fill(dis[i], -1); // 거리가 -1이라는 것은 방문한 적 없다는 뜻
			}

			// 모든 W 위치를 큐에 넣고 거리 0으로 설정
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 'W') {
						q.add(new int[] { i, j }); // 멀티소스 BFS
						dis[i][j] = 0;
					}
				}
			}

			int totalDis = 0; // 전체 거리 합

			// BFS
			while (!q.isEmpty()) {
				int[] curr = q.poll();
				int currR = curr[0], currC = curr[1];

				for (int i = 0; i < 4; i++) {
					int nr = currR + dr[i];
					int nc = currC + dc[i];
					
					// 범위 내 && 거리 -1 (방문한 적 없음) && 'L'인 곳
					if(nr >= 0 && nr < N && nc >= 0 && nc < M && dis[nr][nc] == -1 && map[nr][nc] == 'L') {
						dis[nr][nc] = dis[currR][currC] + 1;
						totalDis += dis[nr][nc];
						q.add(new int[] {nr, nc});
					}
				}
			}
			
			sb.append(totalDis).append("\n");
		} // tc

		sb.setLength(sb.length() - 1);
		bw.write(sb.toString());
		bw.flush();
	}// main

}

//오답
//채점용 input 파일로 채점한 결과 fail 입니다.
//(오답 : 20개의 테스트케이스 중 0개가 맞았습니다.)
//
//제한시간 초과가 발생하였습니다. 제한시간 초과로 전체 혹은 일부 테스트 케이스는 채점이 되지 않을 수 있습니다.

//for (int i = 0; i < N; i++) {
//for (int j = 0; j < M; j++) {
//	if (map[i][j] != 'W') {
//		answer += bfs(i, j);
//	}
//}
//}
//여기서 전체순회를 하면서 시간초과가 나는 것 같은데 그럼 어떻게 해야하지??
//W에서 시작해서 거리를 저장하면서 이동할때마다 +1을 하고싶은데 W가 한개가 아니라 여러개임...
//=> 멀티소스 BFS
//멀티 소스 BFS(Multi-source BFS)는 여러 개의 시작점에서 동시에 BFS를 수행하는 방법입니다. 일반적으로 BFS는 하나의 시작점에서 출발해서 목표까지의 최단 거리를 구할 때 사용되지만, 멀티 소스 BFS는 여러 개의 출발점을 동시에 처리하면서 각 지점까지의 최단 거리를 한 번에 계산할 수 있는 방법입니다.
//멀티 소스 BFS의 핵심 아이디어는 여러 시작점(소스)을 한 번에 큐에 넣고 BFS를 수행하는 것입니다. 각 시작점에서 동시에 확산해 나가면서 각 지점까지의 최단 거리를 계산합니다. 이 방식은 모든 시작점으로부터의 최소 거리를 한 번에 구해야 하는 문제에서 매우 유용합니다.
