import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M;
	static int[] p;

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		p = new int[N + 1];

		// 각 집합의 대표자 배열
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());

			union(a, b);
		}

		// 대표자 개수 확인

		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= N; i++) {
			set.add(findSet(p[i]));
		}
		
		bw.write(set.size() + "");
		bw.flush();
		bw.close();

	}

	private static void union(int A, int B) {
		p[findSet(B)] = findSet(A);
	}

	private static int findSet(int x) {
		if (p[x] == x)
			return x;

		return p[x] = findSet(p[x]);
	}

}
