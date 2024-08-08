import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public void Solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int rear = -1;

			int N = Integer.parseInt(br.readLine());
			int[] queue = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				int data = Integer.parseInt(st.nextToken());
				queue[++rear] = data;

				// i : data의 위치
				int i = rear;

				// j : 비교하는 값의 위치
				int j;
				for (j = i - 1; j >= 0 && queue[j] > data; j--) {
					queue[j+1] = queue[j];
				}
				queue[j+1] = data;
			}
			
			// 출력
			System.out.printf("#%d ", tc);
			for (int num : queue) {
				sb.append(num + " ");
			}
			
			sb.setLength(sb.length()-1);
			
			System.out.println(sb);
			sb.setLength(0);
		} // tc

	}// solution

	public static void main(String[] args) throws Exception {
		new Solution().Solution();
	}// main
}
