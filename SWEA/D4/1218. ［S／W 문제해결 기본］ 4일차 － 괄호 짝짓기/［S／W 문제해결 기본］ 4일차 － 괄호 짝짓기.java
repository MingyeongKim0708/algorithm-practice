import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 10개 고정

		for (int tc = 1; tc <= 10; tc++) {
			// 테스트케이스의 길이
			int len = sc.nextInt();
			// 엔터
			sc.nextLine();

			// 문자열 입력
			String str = sc.nextLine();

			// 답
			int answer = 1;

			// Stack 생성
			Stack<Character> stack = new Stack<>();

			// 여는 괄호 stack에 넣기
			for (char ch : str.toCharArray()) {
				if (ch == '(' || ch == '[' || ch == '{' || ch == '<') {
					stack.push(ch);
				}
				// 닫는 괄호 stack 짝이랑 비교
				else if (ch == ')' || ch == ']' || ch == '}' || ch == '>') {
					// stack이 비어 있으면 짝이 맞지 않아 0
					if (stack.isEmpty()) {
						answer = 0;
						break; // 실패시 더 이상 검사 X
					} else {
						// stack이 있으면 top을 꺼내서 짝이 틀리다면 0
						char partner = stack.pop();
						if ((ch == ')' && partner != '(') || (ch == ']' && partner != '[')
								|| (ch == '}' && partner != '{') || (ch == '>' && partner != '<')) {
							answer = 0;
							break; // 실패시 더 이상 검사 X
						}
					}
				}
			}
			System.out.printf("#%d %d\n", tc, answer);
		}
		sc.close();
	}// main
}// class
