import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 이해 못해서 풀이 봤음... 맞게 이해한 건지 모르겠음
// 부모가 얼리어답터가 아닐 경우 자식이 모두 얼리어답터여야함
// 부모가 얼리어답터일 경우 자식이 얼리어답터일 수도 있고, 아닐 수도 있음
// dp로 0은 그 노드가 얼리어답터인 경우, 1은 그 노드가 얼리어답터가 아닌 경우 노드의 최소 수를 계속 갱신한다
// dfs로 자식 노드까지 들어가서 체크해야함

public class Main {

	static boolean[] visit; // dfs를 활용하기 위한 방문체크
	static int[][] dp;
	static List<List<Integer>> edgeList;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		int N = stoi(br.readLine());

		edgeList = new ArrayList<>(); // 노드 정보 저장

		for (int i = 0; i <= N; i++) { // N번까지 해야하므로 0부터 N까지 모두 생성
			edgeList.add(new ArrayList<>()); // 각 노드마다 연결된 노드 리스트 저장
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = stoi(st.nextToken());
			int v = stoi(st.nextToken());
			edgeList.get(u).add(v);
			edgeList.get(v).add(u);

		}

		dp = new int[N + 1][2]; // 현재 노드를 루트로 하는 트리에서 현재 노드가 얼리어답터일 때(0), 아닐 때(1) 필요한 얼리어답터의 수

		visit = new boolean[N + 1];

		dfs(1); // 노드 1번에서 시작

		bw.write(Math.min(dp[1][0], dp[1][1]) + ""); // 1번이 얼리어답터일 때 or 아닐 때 중에서 더 최소인 경우
		bw.flush();
		bw.close();
	}

	private static void dfs(int node) {
		visit[node] = true;
		dp[node][0] = 1; // 0 : 얼리어답터인 경우이므로 1 넣기

		// 해당 노드에 연결된 다음 노드를 불러와서 얼리어답터 계산
		for (int nextNode : edgeList.get(node)) {
			if (visit[nextNode])
				continue;

			dfs(nextNode);

			dp[node][1] += dp[nextNode][0]; // 현재 노드가 얼리어답터가 아니라면 자식이 모두 얼리어답터여야함
			dp[node][0] += Math.min(dp[nextNode][0], dp[nextNode][1]); // 현재 노드가 얼리어답터라면 자식이 얼리어답터이거나 아니거나 둘 중에서 더 최소인
																		// 경우를 더함
		}
	}

	private static int stoi(String line) {
		return Integer.parseInt(line);
	}
}
