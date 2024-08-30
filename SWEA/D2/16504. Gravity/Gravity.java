import java.util.Scanner;

public class Solution {

	static int N; // 방의 가로 길이
	static int[] arr; // 블럭
	static int[] diff; // 각 행의 낙차 기록
	static int max; // 가장 긴 블럭의 길이
	static int diffMax; // 가장 큰 낙차

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			arr = new int[N];
			max = 0;

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
				if (arr[i] >= max) {
					max = arr[i];
				}
			}

			diff = new int[N];
			for (int i = 0; i < N - 1; i++) {
				for (int j = 1; j < N - i; j++) {
					// 크기가 같거나 더 긴 블럭이 있다면 낙차가 발생하지 않는다.
					if (arr[i] > arr[i + j]) {
						diff[i]++;
					}
				}
			}

			diffMax = 0;
			for (int i = 0; i < N; i++) {

				if (diff[i] >= diffMax) {
					diffMax = diff[i];
				}
			}
			System.out.println("#" + tc + " " + diffMax);

		} // tc

		sc.close();
	}// main
}
