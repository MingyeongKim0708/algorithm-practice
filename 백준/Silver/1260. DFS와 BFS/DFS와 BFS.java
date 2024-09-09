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
	static StringBuilder sb = new StringBuilder();

	static int N, M, V; // 노드 개수, 간선 개수, 시작 위치
	static List<Integer>[] adj; // 인접 리스트
	static boolean[] visited; // 해당 노드 방문 체크

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N + 1];
		// 각 노드의 번호마다 인접 노드를 저장할 ArrayList 생성
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st2.nextToken());
			int B = Integer.parseInt(st2.nextToken());

			adj[A].add(B);
			adj[B].add(A);
		} // 간선 입력 완료

		// 인접 리스트 정렬 (작은 번호부터 탐색하기 위해)
		for (int i = 1; i <= N; i++) {
			Collections.sort(adj[i]);
		}

		// DFS
		visited = new boolean[N + 1]; // 방문 배열 초기화
		dfs(V);
		sb.append("\n");

		// BFS
		visited = new boolean[N + 1]; // 방문 배열 초기화
		bfs(V);

		// 결과 출력
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void dfs(int v) throws Exception {
		visited[v] = true;
		sb.append(v).append(" ");
		for (int w : adj[v]) {
			if (!visited[w]) {
				dfs(w);
			}
		}
	}

	private static void bfs(int v) throws Exception {

		Queue<Integer> q = new LinkedList<>();

		q.add(v);

		visited[v] = true;

		while (!q.isEmpty()) {
			int curr = q.poll(); // 정점 번호
			sb.append(curr).append(" ");

			for (int w : adj[curr]) {
				if (!visited[w]) {
					q.add(w);
					visited[w] = true;
				}
			}
		}

	}

}
