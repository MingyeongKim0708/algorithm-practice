class Solution {
	static int[] sel;
	static int answer;

	public int solution(int[] nums) {
		// 서로 다른 3개를 골라 더했을 때 소수
		sel = new int[3];

		answer = 0;
		combination(nums, 0, 0);

		return answer;
	}

	public static void combination(int[] nums, int idx, int sidx) {
		// 기저 조건
		if (sidx == sel.length) {
			int sum = 0;
			for (int i : sel) {
				sum += i;
			}

			// 소수 여부 확인
			if(isPrime(sum)) {
				answer++;
			}

			return;
		}

		// 재귀 부분
		for (int i = idx; i < nums.length; i++) {
			sel[sidx] = nums[i];
			combination(nums, i + 1, sidx + 1);
		}

	}

	// 소수 확인
	public static boolean isPrime(int sum) {
		if (sum < 2) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(sum); i++) {
			if (sum % i == 0) {
				return false;
			}
		}
		return true;
	}
}