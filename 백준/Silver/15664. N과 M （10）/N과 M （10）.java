import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static int[] nums;
	static int[] result;
	static int N, M;

	// 조합
	// for문을 쓸때 idx는 처음 i의 시작값으로만 지정하고 그 후로는 i를 쓴다는 것을 기억하기
	// for문의 범위 i<=N-M+sidx. <= 라는 것 잊지 말기

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

	}// main

	private static void combi(int idx, int sidx) throws Exception {
		if (sidx == M) {
			for(int i : result) {
				sb.append(i).append(" ");
			}
			sb.setLength(sb.length()-1);
			bw.write(sb.toString() + "\n");
			sb.setLength(0);
			return;
		}

		int lastUsed = -1;

		// 같은 레벨에서 중복을 체크해야하므로 for문 사용
		for (int i = idx; i <= N - M + sidx; i++) {
			if (lastUsed == nums[i]) {
				continue;
			}
			result[sidx] = nums[i];
			lastUsed = nums[i];
			combi(i + 1, sidx + 1);
		}

	}

}
