import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N, M;
	static List<Integer>[] adj; // 인접리스트
	static boolean[] visit; // 방문체크
	static int answer = -1; // 감염된 컴퓨터 수. 1은 체크하지 않으므로 -1부터 시작

	// BFS

	public static void main(String[] args) throws Exception {

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		// 인접리스트 생성
		adj = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		// 연결관계 적기
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			adj[A].add(B);
			adj[B].add(A);
		}

		// 인접 리스트 정렬 (작은 번호부터 탐색하기 위해)
		for (int i = 1; i <= N; i++) {
			Collections.sort(adj[i]);
		}

		visit = new boolean[N + 1];
		bfs(1);
		bw.write(answer + "");
		bw.flush();
		bw.close();
	} // main

	private static void bfs(int v) {

		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		visit[v] = true;

		while (!q.isEmpty()) {
			int curr = q.poll();
			answer++;
			for (int w : adj[curr]) {
				if (!visit[w]) {
					q.add(w);
					visit[w] = true;
				}
			}
		}

	}

}
