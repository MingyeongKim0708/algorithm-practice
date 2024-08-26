class Solution {
	public int solution(String s) {
		StringBuilder sb = new StringBuilder();
		int len = s.length();

		char[] ch = s.toCharArray();
		int idx = 0;
		while (idx < len) {

			if (ch[idx] == 'z') {
				sb.append(0);
				idx = idx + 4; // zero
			} else if (ch[idx] == 'o') {
				sb.append(1);
				idx = idx + 3; // one
			} else if (ch[idx] == 't') {
				if (ch[idx + 1] == 'w') {
					sb.append(2);
					idx = idx + 3; // two
				} else {
					sb.append(3);
					idx = idx + 5; // three
				}
			} else if (ch[idx] == 'f') {
				if (ch[idx + 1] == 'o') {
					sb.append(4);
					idx = idx + 4; // four
				} else {
					sb.append(5);
					idx = idx + 4; // five
				}
			} else if (ch[idx] == 's') {
				if (ch[idx + 1] == 'i') {
					sb.append(6);
					idx = idx + 3; // six
				} else {
					sb.append(7);
					idx = idx + 5; // seven
				}
			} else if (ch[idx] == 'e') {
				sb.append(8);
				idx = idx + 5; // eight
			} else if (ch[idx] == 'n') {
				sb.append(9);
				idx = idx + 4; // nine
			} else {
				sb.append(ch[idx]); // 숫자
				idx++;
			}

		}

		int answer = Integer.parseInt(sb.toString());
		return answer;
	}
}