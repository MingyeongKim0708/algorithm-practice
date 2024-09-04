import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

// 조합. idx, sidx. for문 x combi두번
public class Main {

	static StringBuilder sb = new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N, M;
	static int[] nums;
	static int[] result;

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		nums = new int[N];
		result = new int[M];

		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}

		Arrays.sort(nums);

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
			sb.setLength(sb.length() - 1);
			bw.write(sb.toString() + "\n");
			sb.setLength(0);
			return;
		}

		if (idx == N) {
			return;
		}

		result[sidx] = nums[idx];
		combi(idx + 1, sidx + 1);
		combi(idx + 1, sidx);

	}
}
