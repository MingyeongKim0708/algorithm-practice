
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

// 자기 스스로도 고르는 중복 순열. idx
public class Main {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] nums;
	static int[] result;
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

		bw.flush();
		bw.close();
		sc.close();

	}// main

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

//			if (visit[i])
//				continue;
			visit[i] = true;
			result[idx] = nums[i];
			perm(idx + 1);
			visit[i] = false;

		}

	}

}
