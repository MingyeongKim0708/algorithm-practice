class Solution {
	public int solution(int[] number) {
		int length = number.length;

		int answer = 0;
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				for (int k = j + 1; k < length; k++) {
					int three = 0;
					three += number[i] + number[j] + number[k];

					if (three == 0) {
						answer++;
					}

				}
			}
		}

		return answer;
	}
}