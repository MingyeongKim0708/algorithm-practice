import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 10개의 테스트 케이스
		for (int tc = 1; tc <= 10; tc++) {
			// 길이입력(안씀)
			sc.nextInt();
			// 줄바꿈
			sc.nextLine();
			// 계산식
			String expression = sc.nextLine();
			
			int result = evaluate(expression);
			System.out.printf("#%d %d\n", tc, result);
		}
		sc.close();
	}// main

	// 1, 2 한번에 합치는 함수
	static int evaluate(String expression) {
		String infix = infixToPostfix(expression);
		return evalPostfix(infix);
	}

	// 연산자 우선순위 매핑 static
	static Map<Character, Integer> map = new HashMap<>();
	static {
		map.put('+', 1);
		map.put('*', 2);
	}

	// 1. 중위 표기식 -> 후위 표기식 (연산자 스택에 저장)
	static String infixToPostfix(String infix) {
		String postfix = "";
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			
			// 숫자
			if('0'<=c && c<='9') {
				postfix += c;
			}
			
			// 괄호
			else if(c == '('){
				stack.push(c);
			}else if(c == ')') {
				char popItem = stack.pop();
				while (popItem != '(') {
					postfix += popItem;
					popItem = stack.pop();
				}
			}
			
			// 나머지 연산자
			else {
				while(!stack.isEmpty() &&
						stack.peek() != '(' &&
						map.get(stack.peek()) >= map.get(c)) {
					char popItem = stack.pop();
					postfix += popItem;
				}
				stack.push(c);
			}
			
		}
		
		// 남은 연산자 다 빼기
		while(!stack.isEmpty()) {
			postfix += stack.pop();
		}
		
		
		return postfix;
	}//1번 끝
	
	// 2. 후위 표기식 계산 (숫자 스택에 저장)
	static int evalPostfix(String postfix) {
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);
			
			if('0'<= c && c <= '9') {
				stack.push(c - '0');
			}else {
				int num1 = stack.pop();
				int num2 = stack.pop();
				int result;
				if(c =='+') {
					result = num2 + num1;
				}else {
					result = num2 * num1;
				}
				stack.push(result);
			}
		}
		
		return stack.pop();
	}
	
}// class
