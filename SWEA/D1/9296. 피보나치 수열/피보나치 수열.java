import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			int N = sc.nextInt();
			System.out.println(fibo(N));
		}
	}// main

	private static long fibo(int n) {

		long[] dp = new long[n + 1];
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
		}
		return dp[n];
	}

}
