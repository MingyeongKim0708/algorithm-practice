import java.util.Arrays;

class Solution {
	public int[] solution(int[] arr, int[][] queries) {
		int[] answer = new int[queries.length];

		for (int i = 0; i < queries.length; i++) {
			int s = queries[i][0];
			int e = queries[i][1];
			int k = queries[i][2];

			int num = Integer.MAX_VALUE;
			for (int j = s; j <= e; j++) {
				if (arr[j] > k) {
					num = Math.min(num, arr[j]);
				}
			}

			if (num != Integer.MAX_VALUE) {
				answer[i] = num;
			} else {
				answer[i] = -1;
			}

		}

		return answer;
	}
}