import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static int N, answer;
	static int[] num, dp;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			num = new int[N];
			for (int i = 0; i < N; i++) {
				num[i] = sc.nextInt();
			}
            
			answer = 1;
			dp = new int[N];
			Arrays.fill(dp, 1); // 기본적으로 가장 첫번째 있는 값 하나만으로도 길이는 1이상
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < i; j++) {
					if (num[j] < num[i]) {
						dp[i] = Math.max(dp[i], dp[j] + 1);
						// dp 마지막 값이 가장 길이가 긴 경우는 아닐 수 있으므로 최대값을 따로 찾아야한다
						answer = Math.max(answer, dp[i]);
					}
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		} // tc

		sc.close();
	}

}
