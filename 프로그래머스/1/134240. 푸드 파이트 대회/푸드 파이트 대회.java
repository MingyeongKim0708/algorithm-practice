class Solution {
	public String solution(int[] food) {
		StringBuilder sb = new StringBuilder();
		String answer = "";

		int length = food.length;

		// i = 0 : 물
		for (int i = 1; i < length; i++) {
			int num = food[i] / 2;
			for (int j = 0; j < num; j++) {
				sb.append(i);
			}
		}
		sb.append(0);
		for (int i = length - 1; i >= 0; i--) {
			int num = food[i] / 2;
			for (int j = 0; j < num; j++) {
				sb.append(i);
			}
		}

		answer = sb.toString();

		return answer;
	}
}