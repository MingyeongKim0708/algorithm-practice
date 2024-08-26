import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
	public int[] solution(int[] numbers) {
		ArrayList<Integer> arr = new ArrayList<>();

		for (int i = 0; i < numbers.length; i++) {
			for (int j = 1 + i; j < numbers.length; j++) {
				arr.add(numbers[i] + numbers[j]);

			}
		}

		// set으로 중복 제거
		Set<Integer> set = new HashSet<>();

		for (int i : arr) {
			set.add(i);
		}

		// set-> array
		int[] answer = new int[set.size()];

		int idx = 0;
		for (int i : set) {
			answer[idx] = i;
			idx++;
		}

		// set은 정렬을 보장하지 않음. 정렬 필수
		Arrays.sort(answer);

		return answer;
	}
}