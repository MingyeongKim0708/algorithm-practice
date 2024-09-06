import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static int[] nums;
	static int[] result;
	static int N, M;

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

	private static void combi(int idx, int sidx) throws Exception {

		if (sidx == M) {
			for (int i : result) {
				sb.append(i).append(" ");
			}
			sb.setLength(sb.length() - 1);
			bw.write(sb.toString() + "\n");
			sb.setLength(0);
			return;
		}

		int lastUsed = -1;

		// i<=N-R+sidx 가 아니라 i<N이어야한다
		// 조합을 만들 때 아직 선택되지 않은 요소의 수를 계산하여 M의 길이를 맞추려고 하였으나,
		// 인덱스가 제한됨에 따라 모든 경우의 수를 다루지 못하게 되는 문제가 발생
		for (int i = idx; i < N; i++) {
			if (lastUsed == nums[i])
				continue;
			result[sidx] = nums[i];
			lastUsed = nums[i];
			combi(i, sidx + 1);
		}
	}
}
