import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

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
			return this.C - o.C; // 오름차순
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N, M;
	static int[] p; // 대표자를 저장하는 배열
	static Edge[] edge; // 가중치 오름차순으로 정렬할 예정

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		edge = new Edge[M];

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int pc1 = Integer.parseInt(st.nextToken());
			int pc2 = Integer.parseInt(st.nextToken());
			int net = Integer.parseInt(st.nextToken());

			edge[i] = new Edge(pc1, pc2, net);
		}

		Arrays.sort(edge);

		// 두 노드를 뽑았을 때 이미 대표자가 같다면 사이클이 발생한다
		// V-1개를 뽑기 전까지 사이클이 발생하지 않도록 가중치가 적은 것을 계속 고르면 된다

		p = new int[N + 1]; // 1번부터 시작
		for (int i = 0; i < N; i++) {
			p[i] = i;
		}

		int ans = 0; // 최소 비용을 저장하는 변수
		int pick = 0; // 내가 뽑은 간선의 개수(N-1개 뽑아야 함)

		for (int i = 0; i < M; i++) {
			int px = findSet(edge[i].A);
			int py = findSet(edge[i].B);

			if (px != py) {
				union(px, py);
				ans += edge[i].C;
				pick++;
			}

			if (pick == N - 1)
				break;
		}

		bw.write(ans + "");
		bw.flush();
		bw.close();
	}// main

	private static void union(int px, int py) {
		// 이미 위에서 findSet을 했으므로 여기서 findSet을 안해도 됨
		p[py] = px;
	}

	private static int findSet(int x) {
		if (p[x] == x)
			return x;
		return p[x] = findSet(p[x]);
	}

}
