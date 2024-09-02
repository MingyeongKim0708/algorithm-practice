import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	int[] nums;
	static int N, M;
	int[] result;
	boolean[] visited;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public void Solution() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		result = new int[M];
		visited = new boolean[N];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = i + 1;
		}

		perm(0);

		bw.flush();
		bw.close();

	}

	private void perm(int idx) throws Exception {
		// 기저
		if (idx == M) {
			for (int i : result) {
				sb.append(i).append(" ");
//				System.out.print(i + " ");
			}
			sb.setLength(sb.length()-1);
			bw.write(sb.toString() + "\n");
			sb.setLength(0);

			return;
		}
		// 재귀
		for (int i = 0; i < N; i++) {
			result[idx] = nums[i];
			perm(idx + 1);

		}

	}

	public static void main(String[] args) throws Exception {

		new Main().Solution();
	}

}
