import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static char[][] maze;
	static boolean[][] visit;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static Queue<int[]> q;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input_maze.txt"));

		// tc = 10
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine(); // 번호
			maze = new char[16][16];
			for (int r = 0; r < 16; r++) {
				maze[r] = br.readLine().toCharArray();
			}

			visit = new boolean[16][16];
			// 시작
			visit[1][1] = true;

			System.out.print("#" + tc + " ");
			bfs(1, 1);
			// 출력
//			for (char[] i : maze) {
//				System.out.println(Arrays.toString(i));
//			}
//			for (boolean[] i : visit) {
//				System.out.println(Arrays.toString(i));
//			}

		} // tc
	}// main

	static void bfs(int r, int c) {
		q = new LinkedList<>();

		q.add(new int[] { r, c });
		visit[r][c] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];

				if (maze[nr][nc] == '0' && !visit[nr][nc]) {
					q.offer(new int[] { nr, nc });
					visit[nr][nc] = true;
				}
				if (maze[nr][nc] == '3') {
					System.out.println("1");
					return;
				}
			}

		}
		System.out.println("0");

	}

}
