class Solution {
	public int solution(String my_string, String is_suffix) {
		int answer = 0;

		int length = my_string.length();

		char[] suf = new char[is_suffix.length()];
		int index = 0;
		for (int i = is_suffix.length() - 1; i >= 0; i--) {
			suf[index] = is_suffix.charAt(i);
			index++;
		}

		char[] str = new char[my_string.length()];
		int index2 = 0;
		for (int i = my_string.length() - 1; i >= 0; i--) {
			str[index2] = my_string.charAt(i);
			index2++;
		}

		// 접미사 확인
		// 모두 일치한다면 is_suffix의 길이만큼 나오도록 합을 구함
		// is_suffix가 my_string보다 길다면 절대로 접미사가 될 수 없음
		if (is_suffix.length() > my_string.length()) {
			return answer;
		} else {
			int check = 0;
			for (int i = 0; i < is_suffix.length(); i++) {
				if (suf[i] == str[i]) {
					check++;
				}
			}

			if (check == is_suffix.length()) {
				answer = 1;
			}

			return answer;

		}
	}
}