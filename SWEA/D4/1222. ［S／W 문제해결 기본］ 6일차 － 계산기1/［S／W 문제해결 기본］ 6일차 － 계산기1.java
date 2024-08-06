import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 10개의 테스트 케이스
		for (int tc = 1; tc<=10; tc++) {
			sc.nextInt(); // 길이(딱히 저장 X)
			sc.nextLine(); // 줄바꿈
			String expression = sc.nextLine();
			int result = evaluate(expression);
			System.out.printf("#%d %d\n", tc, result);
		}
		
		sc.close();
	} //main
	
	// 한 번에 묶음
	static int evaluate(String expression) {
		String postfix = infixToPostfix(expression);
		return evalPostfix(postfix);
	}
	
	// 연산자 우선매핑 필요없음(연산자 + 뿐)
	
	// 중위 표기식 -> 후위 표기식
	static String infixToPostfix(String infix) {
		// 후위표기식으로 변환한 것을 담을 곳
		String postfix = "";

		Stack<Character> stack = new Stack<>();

		// 스택 넣기
		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);

			// 피연산자. 바로 출력. char 타입
			if ('0' <= c && c <= '9') {
				postfix += c;
			}

			// 괄호 처리
			else if (c == '(') {
				// 여는 괄호는 push
				stack.push(c);
			} else if (c == ')') {
				// 닫는 괄호는 여는 괄호가 나올 때까지 pop
				char popItem = stack.pop();
				while (popItem != '(') {
					postfix += popItem;
					popItem = stack.pop();
				}
			}

			// 나머지 연산자
			// 우선순위가 낮은 연산자가 올 때까지 pop
			// 우선순위 필요 -> 매핑 & static 변수로 설정
			else {
				while (!stack.isEmpty() && stack.peek() != '(') {
					char popItem = stack.pop();
					postfix += popItem;
				}
				// while 문 조건을 만족하지 못하면 push
				stack.push(c);
			}

		} // for

		// 새로 더 들어오는 것이 없이 스택에 연산자가 남아있으면
		// 스택에 있는 것들 다 빼내기
		while (!stack.isEmpty()) {
			postfix += stack.pop();

		}

		return postfix;

	}// infixToPostfix

	// 후위 표기식 계산
	static int evalPostfix(String postfix) {
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);
			
			// 스택에 숫자를 넣음
			if('0'<=c && c <= '9') {
				stack.push(c - '0'); // c -> int로 만들기
			}else {
				int num1 = stack.pop();
				int num2 = stack.pop();
				int result;
				// 먼저 꺼낸 값이 뒤로 감
				result = num2 + num1;
				stack.push(result);
			}
		}
		
		return stack.pop();
	}//evalPostfix

}//class
