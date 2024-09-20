import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// MST - 프림 - 우선순위큐(완전 이진 트리. Heap)
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int V, E;
	static boolean[] visit; // 방문체크
	static List<Edge>[] adjList; // 인접리스트

	static class Edge implements Comparable<Edge> {
		int A, B, C;

		public Edge(int a, int b, int c) {
			super();
			A = a;
			B = b;
			C = c;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.C, o.C);
		}

	}

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[V + 1];
		for (int i = 0; i < V + 1; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			adjList[x].add(new Edge(x, y, z));
			adjList[y].add(new Edge(y, x, z));

		}

		visit = new boolean[V + 1];
		visit[1] = true; // 노드가 1번부터 시작

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.addAll(adjList[1]);

		int ans = 0;
		int pick = 1; // 1번 뽑은 상태

		while (pick != V) {
			Edge e = pq.poll();
			if (visit[e.B])
				continue;

			ans += e.C;
			visit[e.B] = true;
			pick++;

			pq.addAll(adjList[e.B]);
		}

		bw.write(ans + "");
		bw.flush();
		bw.close();

	}

}
