import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public void Solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			// 카드 개수
			int N = Integer.parseInt(br.readLine());

			Queue<String> queue1 = new LinkedList<>();
			Queue<String> queue2 = new LinkedList<>();

			StringTokenizer st = new StringTokenizer(br.readLine());

			// queue 2개 분리해서 삽입
			for (int i = 0; i < N; i++) {
				String str = st.nextToken();
				// queue1이 무조건 더 많게
				if (i < (N + 1) / 2) {
					queue1.add(str);
				} else {
					queue2.add(str);
				}
			}

			// 하나의 덱으로 만들어주기
			while (!queue1.isEmpty() || !queue2.isEmpty()) {
				if (!queue1.isEmpty()) {
					sb.append(queue1.poll()).append(" ");
				}
				if (!queue2.isEmpty()) {
					sb.append(queue2.poll()).append(" ");
				}
			}
			
			// 마지막 공백 제거
			sb.setLength(sb.length() -1);

			System.out.println("#" + tc + " " + sb.toString());
			sb.setLength(0);
		}

	}

	public static void main(String[] args) throws Exception {
		new Solution().Solution();
	}
}
