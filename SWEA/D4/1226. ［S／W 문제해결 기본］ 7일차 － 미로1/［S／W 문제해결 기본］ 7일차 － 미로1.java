import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	static char[][] maze;
	static boolean[][] visit;
	static int answer;

	public static void main(String[] args) throws Exception {
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine(); // 번호 패스

			maze = new char[16][16];

			for (int i = 0; i < 16; i++) {
				maze[i] = br.readLine().toCharArray();
			} // 미로 입력

			// 2 시작 시점, 3 도착 지점

			visit = new boolean[16][16];

			visit[1][1] = true; // 시작지점
			
			answer = -1;

			bfs(1, 1);
			bw.write("#" + tc + " " + answer + "\n");

		} // tc
		
		bw.flush();
		bw.close();
	}

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Queue<int[]> q;

	private static void bfs(int r, int c) {
		q = new LinkedList<>();

		q.add(new int[] { r, c });

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				
				if(nr >= 0 && nr < 16 && nc >= 0 && nc < 16) {
					if (maze[nr][nc] == '3') {
						answer = 1;
						return;
						// 도착
					}
					
					if(maze[nr][nc] == '0' && !visit[nr][nc]) {
						q.offer(new int[] { nr, nc });
						visit[nr][nc] = true;
					}
				}
				

//				if (nr >= 0 && nr < 16 && nc >= 0 && nc < 16 && maze[nr][nc] == '0' && !visit[nr][nc]) {
//					q.offer(new int[] { nr, nc });
//					visit[nr][nc] = true;
//				} // 갈수 있는 곳이라면 queue에 집어넣고 방문체크
//
//				if (maze[nr][nc] == '3') {
//					answer = 1;
//					return;
//					// 도착
//				}
			}
		}
		
		// while문을 다 돌았는데도 3에 도착하지 못했다면 미로 풀이 실패
		answer = 0;

	}

	private static int stoi(String line) {
		return Integer.parseInt(line);
	}

}
