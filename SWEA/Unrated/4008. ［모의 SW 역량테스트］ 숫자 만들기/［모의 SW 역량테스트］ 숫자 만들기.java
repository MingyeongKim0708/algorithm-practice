// 중복 순열

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Solution {

	static int N, max, min;
	static int[] cnt = new int[4]; // 연산자의 개수 - 방문배열의 역할
	static int[] nums;

//	static char[] op = { '+', '-', '*', '/' };
//	static char[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			nums = new int[N];

//			arr = new char[N - 1];

			for (int i = 0; i < 4; i++) {
				cnt[i] = sc.nextInt();
			}

			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}

			max = -100000001;
			min = 100000000;
			permutation(0, nums[0]);
			System.out.println("#" + tc + " " + (max - min));
		}
		sc.close();
	}// main

	static void permutation(int idx, int val) {
		if (idx == N - 1) {
//			System.out.println(Arrays.toString(arr));
			max = Math.max(val, max);
			min = Math.min(val, min);
			return;
		}
		// 연산자 나열
		if (cnt[0] > 0) { // + 연산자 카드가 남아있다면
			cnt[0]--;
			permutation(idx + 1, val + nums[idx + 1]);
			cnt[0]++;
		}
		if (cnt[1] > 0) { // - 연산자 카드가 남아있다면
			cnt[1]--;
			permutation(idx + 1, val - nums[idx + 1]);
			cnt[1]++;
		}
		if (cnt[2] > 0) { // * 연산자 카드가 남아있다면
			cnt[2]--;
			permutation(idx + 1, val * nums[idx + 1]);
			cnt[2]++;
		}
		if (cnt[3] > 0) { // / 연산자 카드가 남아있다면
			cnt[3]--;
			permutation(idx + 1, val / nums[idx + 1]);
			cnt[3]++;
		}

	}

}

// 메모
// 방문체크를 연산자가 남은 개수만큼 해주기