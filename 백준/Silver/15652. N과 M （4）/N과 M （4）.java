// 중복 조합

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

	static int[] nums;
	static int[] result;
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = i + 1;
		}

		result = new int[M];

		combi(0, 0);
		sc.close();
		
		bw.flush();
		bw.close();
	}

	static void combi(int idx, int sidx) throws Exception {
		if (sidx == M) {
			for (int i : result) {
				sb.append(i).append(" ");
			}
			sb.setLength(sb.length()-1);
			bw.write(sb.toString() + "\n");
			sb.setLength(0);
			return;
		}

		if (idx == N) {
			return;
		}
		result[sidx] = nums[idx];
		combi(idx, sidx + 1); // 중복조합 (idx+1이 아닌 idx)
		combi(idx + 1, sidx);

	}
}
