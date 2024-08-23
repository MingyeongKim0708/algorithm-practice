import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
	public int[] solution(int l, int r) {


		ArrayList<Integer> arr = new ArrayList<>();

		for (int i = l; i <= r; i++) {
			String str = Integer.toString(i);
			// 정규식 사용
			if (str.matches("[05]+")) { // []안에 들어간 문자를 하나 또는 많이 가지고 있다면
				arr.add(i);
			}

		}

		if (arr.isEmpty()) {
			return new int[] { -1 };
		}

		// arr 정렬
		// Collections.sort(arr);

		// ArrayList -> Array
		int[] answer = new int[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			answer[i] = arr.get(i);
		}

		return answer;
	}
}