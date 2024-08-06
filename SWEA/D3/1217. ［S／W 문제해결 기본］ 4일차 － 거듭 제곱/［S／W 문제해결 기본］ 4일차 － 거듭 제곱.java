import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 10개의 테스트 케이스
		for (int tc = 1; tc <= 10; tc++) {
			// 테스트 케이스 번호
			int T = sc.nextInt();

			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			int result = powerCal(num1, num2);
			System.out.printf("#%d %d\n", tc, result);
		} // tc

		sc.close();
	}// main

	static int powerCal(int num1, int num2) {
		// Base case
		if (num2 == 1)
			return num1;

		// 재귀 파트
		return num1 * powerCal(num1, num2 - 1);
	}// powerCal

}// class
