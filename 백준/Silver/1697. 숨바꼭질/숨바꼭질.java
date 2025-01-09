import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static boolean[] visit;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		visit = new boolean[100001];

		int answer = bfs(start, end);

		System.out.println(answer);

	}

	private static int bfs(int a, int b) {
		visit[a] = true;
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { a, 0 });

		while (!q.isEmpty()) {
			int[] now = q.poll();

			int loc = now[0]; // 위치
			int time = now[1]; // 시간(depth)

			// 도착
			if (loc == b)
				return time;

			// x-1
			if (loc - 1 >= 0 && !visit[loc - 1]) {
				q.add(new int[] { loc - 1, time + 1 });
				visit[loc - 1] = true;
			}

			// x+1
			if (loc + 1 <= 100000 && !visit[loc + 1]) {
				q.add(new int[] { loc + 1, time + 1 });
				visit[loc + 1] = true;
			}

			// 2x
			if (loc * 2 <= 100000 && !visit[loc * 2]) {
				q.add(new int[] { loc * 2, time + 1 });
				visit[loc + 1] = true;
			}

		}

		return -1;
	}

}
