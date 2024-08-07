import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public void Solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int big = Math.max(N, M);

			// 항상 두 그룹의 합을 나열했을 때 2 ~ N+M의 중앙값이 가장 빈도수가 높음
			// 작은 그룹을 모두 포함하는 값이라면 중앙값과 동일한 빈도수만큼 등장함
			// 중앙값을 기준으로 점점 크기를 키워가며 검사

			// 중앙값이 1개일 때
			if ((N + M) % 2 == 0) {
				int median = (2 + N + M) / 2;
				int check_num = median;
				while (true) {
					if (check_num - big > 1) {
						break;
					} else {
						sb.append(check_num).append(" ");
						if (check_num != median * 2 - check_num) {
							sb.insert(0, median * 2 - check_num + " ");
						}
						check_num++;
					}
				}
			}
			// 중앙값이 2개일 때
			// check_num을 점점 키우면서 검사 중이므로 중앙값 중 큰 쪽을 채택
			else {
				int median2 = 2 + (N + M) / 2;
				int check_num = median2;
				while (true) {
					if (check_num - big > 1) {
						break;
					} else {
						sb.append(check_num).append(" ");
						int partner = 2 + N + M - check_num;
						sb.insert(0, partner + " ");
						check_num++;
					}
				}
			}

			// 마지막 공백 제거
			sb.setLength(sb.length() - 1);
			System.out.println("#" + tc + " " + sb);
			
			// sb 초기화
			sb.setLength(0);
		}

	}

	public static void main(String[] args) throws Exception {
		new Solution().Solution();
	}
}
