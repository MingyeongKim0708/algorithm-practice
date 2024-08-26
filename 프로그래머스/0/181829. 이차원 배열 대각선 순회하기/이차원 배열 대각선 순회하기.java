class Solution {
	public int solution(int[][] board, int k) {
		int answer = 0;
		int R = board.length;

		for (int i = 0; i < R; i++) {
			int C = board[i].length;
			for (int j = 0; j < C; j++) {
				if (i + j <= k) {
					answer += board[i][j];

				}

			}
		}

		return answer;
	}
}