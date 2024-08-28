import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);


		for (int tc = 1; tc <= 10; tc++) {
			sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();

			int answer = power(N, M);
			System.out.println("#" + tc + " " + answer);

		}
	}

	private static int power(int n, int m) {
		if (m == 1) {
			return n;
		}

		if (m == 0) {
			return 1;
		}

		if (m % 2 == 0) {
			int tmp = power(n, m / 2);
			return tmp * tmp;
		} else {
			int tmp = power(n, (m - 1) / 2);
			return tmp * tmp * n;
		}

	}

}
