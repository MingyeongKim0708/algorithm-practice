class Solution {
	public int solution(int a, int b, int c, int d) {
		int[] list = { a, b, c, d };
		int[] count = new int[7];

		for (int i = 0; i < 4; i++) {
			count[list[i]]++;
		}

		int answer = 0;
		int tmp = 1;
		int maxCount = 0;
		int minCount = 5;
		int maxNum = 0;
		int minNum = 7;

		for (int i = 1; i < count.length; i++) {
			if (count[i] > maxCount) {
				maxCount = count[i];
				maxNum = i;
			}
			if (count[i] != 0 && count[i] <= minCount) {
				minCount = count[i];
				minNum = i;
			}
		}

		if (maxCount == 4) {
			answer = 1111 * a;
		} else if (maxCount == 3) {
			answer = (int) Math.pow(10 * maxNum + minNum, 2);
		} else if (maxCount == 2 && minCount == 2) {
			answer = (maxNum + minNum) * Math.abs(maxNum - minNum);
		} else if (maxCount == 2 && minCount == 1) {
			for (int j = 1; j < 7; j++) {
				if (count[j] == 1) {
					tmp *= j;
				}
			}
			answer = tmp;
		} else {
			answer = Math.min(a, Math.min(b, Math.min(c, d)));
		}

		return answer;
	}
}