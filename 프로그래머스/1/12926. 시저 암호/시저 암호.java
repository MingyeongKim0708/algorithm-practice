class Solution {
	public String solution(String s, int n) {

		int length = s.length();
		int cycle = 26;

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < length; i++) {

			if (s.charAt(i) != ' ') {
				// 소문자
				if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
					if (s.charAt(i) + n > 122) {
						sb.append((char) ((int) s.charAt(i) + n - cycle));
					} else {
						sb.append((char) ((int) s.charAt(i) + n));

					}
				}
				// 대문자
				else if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
					if (s.charAt(i) + n > 90) {
						sb.append((char) ((int) s.charAt(i) + n - cycle));
					} else {
						sb.append((char) ((int) s.charAt(i) + n));
					}
				}

			} else {
				sb.append(' ');
			}
		}

		String answer = sb.toString();

		return answer;
	}
}