import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public void Solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 1개의 테스트 케이스
		for (int tc = 1; tc <= 10; tc++) {
			Queue<Integer> queue = new LinkedList<>();

			int t = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 8개의 값을 queue에 삽입
			for (int i = 0; i < 8; i++) {
				int s = Integer.parseInt(st.nextToken());
				queue.add(s);
			}
			
			// 사이클 ( -1 ~ -5 반복)
			int cycle = 1;
			
			// queue 반복
			while (true) {
				// 가장 앞에 있는 값을 - cycle 값 하며 뺌
				int move_value = queue.poll() - cycle;

				if (move_value <= 0) {
					queue.add(0);
					break;
				}
				// 큐에 다시 추가
				queue.add(move_value);
				cycle = (cycle % 5) + 1;
			}

			// 결과 출력
			while (!queue.isEmpty()) {
				sb.append(queue.poll());
				if (!queue.isEmpty()) { // 마지막 요소에는 공백 X
					sb.append(" ");
				}
			}
			System.out.println("#" + tc + " " + sb.toString());

			// sb 초기화
			sb.setLength(0);
		} // tc
	}

	public static void main(String[] args) throws Exception {
		new Solution().Solution();
	}
}
