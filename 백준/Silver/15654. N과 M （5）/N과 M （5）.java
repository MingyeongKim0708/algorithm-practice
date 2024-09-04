import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

// 순열문제 -> visited, for문
public class Main {

	static int N, M;
	static int[] nums;
	static int[] result;
	static boolean[] visit;

	static StringBuilder sb = new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

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

	static void perm(int idx) throws Exception {

		if (idx == M) {
			for (int i : result) {
				sb.append(i).append(" ");
			}
			sb.setLength(sb.length() - 1);
			bw.write(sb.toString() + "\n");
			sb.setLength(0);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			result[idx] = nums[i];
			perm(idx + 1);
			visit[i] = false;

		}
	}

}
