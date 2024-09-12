import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int N, K;
	static int[][] mount;
	static boolean[][] visit; // 방문 체크
	static int maxMount; // 가장 높은 봉우리
	static int answer; // 등산로 길이
	static boolean skill; // 공사가능여부

	// 하 우 상 좌
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			mount = new int[N][N];
			visit = new boolean[N][N];
			maxMount = 0;
			answer = 0;

			for (int i = 0; i < N; i++) {
				int idx = 0;
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				while (st2.hasMoreTokens()) {
					mount[i][idx] = Integer.parseInt(st2.nextToken());
					if (mount[i][idx] > maxMount) {
						maxMount = mount[i][idx];
					}
					idx++;
				}
			}

			// 가장 높은 봉우리에서 dfs로 등산로 길이 체크하기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (mount[i][j] == maxMount)
						dfs(i, j, 1, true); // 행, 열, 등산로 길이, 공사가능여부
				}
			}

			bw.write("#" + tc + " " + answer + "\n");
		} // tc
		bw.flush();
		bw.close();
	} // main

	private static void dfs(int r, int c, int dist, boolean skill) {
		if (dist > answer)
			answer = dist;

		visit[r][c] = true;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nr >= N || nc < 0 || nc >= N || visit[nr][nc])
				continue;

			// 다음 좌표의 높이(nr,nc)가 내 높이(r,c)보다 낮음 -> 이동 가능
			if (mount[r][c] > mount[nr][nc])
				dfs(nr, nc, dist + 1, skill); // skill의 사용여부는 그대로
			// 다음 좌표의 높이가 내 높이와 같거나 높음 + 공사 가능
			else if (skill && mount[r][c] > mount[nr][nc] - K) {
				int tmp = mount[nr][nc]; // dfs 빠져나올 때 원상 복구해야하므로 임시 저장
				mount[nr][nc] = mount[r][c] - 1; // K 만큼 뺄 필요 없고 1만큼만 낮으면 된다
				dfs(nr, nc, dist + 1, false); // skill을 사용했으니 false
				mount[nr][nc] = tmp; // 원상 복구
			}
			// 공사가 불가능한 경우는 아예 dfs를 할 수가 없다

		}
		visit[r][c] = false; // 새로운 봉우리에서 dfs를 시작할테니 다시 원상 복구
	}

}
