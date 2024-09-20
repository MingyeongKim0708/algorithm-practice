import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// MST - 크루스칼
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int V, E;
	static Edge[] edge;
	static int[] p;

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
			return this.C - o.C;
		}

	}

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		edge = new Edge[E];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			edge[i] = new Edge(x, y, z);
		}
		Arrays.sort(edge);

		p = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			p[i] = i;
		}

		int ans = 0;
		int pick = 0;

		for (int i = 0; i < E; i++) {

			int px = findSet(edge[i].A);
			int py = findSet(edge[i].B);

			if (px != py) {
				union(px, py);
				ans += edge[i].C;
				pick++;
			}

			if (pick == V - 1)
				break;
		}

		bw.write(ans + "");
		bw.flush();
		bw.close();

	}

	private static void union(int px, int py) {
		p[py] = p[px];
	}

	private static int findSet(int x) {
		if (p[x] == x)
			return x;
		return p[x] = findSet(p[x]);
	}
}
