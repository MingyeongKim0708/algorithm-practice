import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	// 중복 순열

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static int[] nums;
	static int[] result;
	static int N, M;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		nums = new int[N];
		result = new int[M];
		visit = new boolean[N];

		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}

		Arrays.sort(nums);
		perm(0);

		sc.close();
		bw.flush();
		bw.close();
	}

	private static void perm(int idx) throws Exception {

		if (idx == M) {
			for(int i : result) {
				sb.append(i).append(" ");
			}
			sb.setLength(sb.length()-1);
			bw.write(sb.toString() + "\n");
			sb.setLength(0);
			return;
		}

		int lastUsed = -1;

		for (int i = 0; i < N; i++) {
			if (lastUsed == nums[i])
				continue;
			result[idx] = nums[i];
			visit[i] = true;
			lastUsed = nums[i];
			perm(idx + 1);
			visit[i] = false;
		}

	}

}
