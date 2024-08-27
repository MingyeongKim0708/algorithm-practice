import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static int T;
	static int N, K;
	static int[] A;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();

			A = new int [N];
			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}
			
//			System.out.println(Arrays.toString(A));

			int answer = 0;

			// 부분 집합을 구해서 해당 부분 집합의 합이 K인 경우
			for (int i = 0; i < (1 << N); i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					if ((i & (1 << j)) > 0) {
						sum += A[j];
					}

				}
				if (sum == K) {
					answer++;
				}
			}

			System.out.printf("#%d %d\n", tc, answer);

		}

		sc.close();
	}// main
}
