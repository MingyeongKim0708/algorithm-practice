import java.util.Scanner;

public class Solution {

	public void Solution() {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[] Aj = new int[N];
			for (int i = 0; i < N; i++) {
				Aj[i] = sc.nextInt();
			}
			int[] Bj = new int[M];
			for (int i = 0; i < M; i++) {
				Bj[i] = sc.nextInt();
			}

			int answer = Integer.MIN_VALUE;
			
			if (N < M) { // N이 M보다 작은 경우
				// M-N+1번 반복
				for (int idx = 0; idx < M - N + 1; idx++) {
					int sum = 0;
					for (int i = 0; i < N; i++) {
						sum += Aj[i] * Bj[idx+i];
					}
					if (sum > answer) {
						answer = sum;
					}
				}
			}else {
				// N-M+1번 반복
				for (int idx = 0; idx < N - M + 1; idx++) {
					int sum = 0;
					for (int i = 0; i < M; i++) {
						sum += Aj[idx+i] * Bj[i];
					}
					if (sum > answer) {
						answer = sum;
					}
				}
			}

			System.out.printf("#%d %d\n", tc, answer);

		} // tc

	}

	public static void main(String[] args) {
		new Solution().Solution();
	}
}
