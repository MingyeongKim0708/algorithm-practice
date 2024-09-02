import java.util.Arrays;
import java.util.Scanner;

public class Main {

	int[] nums;
	static int N, M;
	int[] result;

	public void Solution() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		nums = new int[N];
		result = new int[M];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = i + 1;
		}

		combi(0, 0);

		sc.close();
	}

	private void combi(int idx, int sidx) {
		// 기저
		if (sidx == M) {
//			System.out.println(Arrays.toString(result));
			for (int i : result) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}

		if (idx == N) {
			return;
		}
		// 재귀
		result[sidx] = nums[idx];
		combi(idx + 1, sidx + 1);
		combi(idx + 1, sidx);

	}

	public static void main(String[] args) {

		new Main().Solution();
	}

}
