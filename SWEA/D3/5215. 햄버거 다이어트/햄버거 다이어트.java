import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static int T, N, L;
	static int[] SCORE;
	static int[] CAL;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			L = sc.nextInt();

			SCORE = new int[N];
			CAL = new int[N];

			for (int i = 0; i < N; i++) {
				SCORE[i] = sc.nextInt();
				CAL[i] = sc.nextInt();
			}
			

			// 부분집합을 구해서 L 이하의 케이스를 구한 뒤 부분집합의 합(점수)가 제일 높은 것을 고른다
			int maxScore = 0;
			for (int i = 0; i < (1 << N); i++) {
				int sum = 0; // 해당 조합의 칼로리 합
				int sumScore = 0; // 해당 조합 점수의 합
				for (int j = 0; j < N; j++) {
					if ((i & (1 << j)) > 0) {
						sum += CAL[j];
						sumScore += SCORE[j];

						// 칼로리의 합이 L 이하이고 점수가 가장 높다면
						if (sum <= L && sumScore > maxScore) {
							maxScore = sumScore;
						}
					}

				}

			}
			
			System.out.printf("#%d %d\n", tc, maxScore);

		}

		sc.close();
	}// main

}
