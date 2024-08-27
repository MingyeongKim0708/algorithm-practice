import java.util.Arrays;

class Solution {
	public String[] solution(int n, int[] arr1, int[] arr2) {

		char[][] map = new char[n][n];

		for (int i = 0; i < n; i++) {
			int wall = arr1[i] | arr2[i];
			for (int j = 0; j < n; j++) {
				if ((wall & 1) == 1) {
					map[i][n - 1 - j] = '#';
				} else {
					map[i][n - 1 - j] = ' ';
				}

				wall >>= 1;

			}

		}
		String[] answer = new String[n];

		for (int i = 0; i < n; i++) {
			String str = "";
			for (int j = 0; j < n; j++) {
				str += map[i][j];
			}
			answer[i] = str;
		}

		return answer;
	}
}