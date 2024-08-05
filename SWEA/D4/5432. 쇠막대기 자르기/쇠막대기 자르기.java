import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// testcase
		int T = sc.nextInt();
		sc.nextLine();

		for (int tc = 1; tc <= T; tc++) {
			// 문자열 입력
			String str = sc.nextLine();

			// 나눠진 막대기 수의 합
			int answer = 0;

			// Stack
			Stack<Character> stack = new Stack<>();

			for (int i = 0; i < str.length(); i++) {
				// 현재 문자가 '('인 경우 stack에 넣음
				if (str.charAt(i) == '(')
					stack.push('(');

				// 현재 문자가 ')'인 경우
				else if (str.charAt(i) == ')') {
					// 이전 문자가 '(' 이라면 레이저 포인트
					if (str.charAt(i - 1) == '(') {
						stack.pop();
						// 레이저를 만났으므로 '('의 개수만큼 잘린 막대기가 나올 것이다.
						answer += stack.size();
					} else {
						// 이전 문자가 '('이 아니라면 이 ')'는 막대기의 끝을 의미한다.
						stack.pop();
						answer += 1;
					}
				}
			}

			System.out.printf("#%d %d\n", tc, answer);

		} // tc

		sc.close();
	}// main
}// class
