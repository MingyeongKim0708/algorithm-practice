import java.util.Arrays;
import java.util.Scanner;

public class Main {

	int[] nums;
	static int N, M;
	int[] result;
	boolean[] visited;

	public void Solution() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		nums = new int[N];
		result = new int[M];
		visited = new boolean[N];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = i + 1;
		}

		perm(0);

		sc.close();
	}

	private void perm(int idx) {
		// 기저
		if (idx == M) {
			for (int i : result) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		// 재귀
		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			result[idx] = nums[i];
			visited[i] = true;
			perm(idx + 1);
			visited[i] = false;

		}

	}

	public static void main(String[] args) {

		new Main().Solution();
	}

}
