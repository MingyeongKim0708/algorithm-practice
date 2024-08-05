import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			sc.nextInt();

			// 배열 입력
			int[][] matrix = new int[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}

			int answer = 0;

			// 가로줄, 세로줄 합
			for (int i = 0; i < 100; i++) {
				int rowSum = 0;
				int colSum = 0;
				for (int j = 0; j < 100; j++) {
					rowSum += matrix[i][j];
					colSum += matrix[j][i];
				}
				int tempMax = Math.max(rowSum, colSum);
				answer = Math.max(answer, tempMax);
			}

			// 대각선 2줄
			int rightSum = 0;
			int leftSum = 0;
			for (int k = 0; k < 100; k++) {
				rightSum += matrix[k][k];
				leftSum += matrix[k][99-k];
			}
			int tempMax2 = Math.max(rightSum, leftSum);
			answer = Math.max(answer, tempMax2);
			
			System.out.printf("#%d %d\n", tc, answer);
			
			
		}//tc
		sc.close();
	}// main
}// class Sum
