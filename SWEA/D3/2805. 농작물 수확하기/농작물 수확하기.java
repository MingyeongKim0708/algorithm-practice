import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			/*
			 * 1 5 14054 44250 02032 51204 52212
			 */
			int N = sc.nextInt();
			int[][] board = new int[N][N];

			for (int r = 0; r < N; r++) {
				String line = sc.next();
				for (int c = 0; c < N; c++) {
					board[r][c] = line.charAt(c) - '0'; // line.charAt(c) : 아스키 코드값
				}
			}

			int sum = 0;
			int start = N / 2;
			int end = N / 2;
			for (int r = 0; r < N; r++) {
				for (int c = start; c <= end; c++) {

					sum += board[r][c];
				}
				if (r < N / 2) {
					start--;
					end++;
				} else {
					start++;
					end--;
				}
			}
			System.out.println("#" + tc + " " + sum);

		} // tc

	}// main

}// class
