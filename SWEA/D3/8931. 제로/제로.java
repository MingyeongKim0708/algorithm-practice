import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int K = sc.nextInt();
			Stack<Integer> stack = new Stack<>();
			
			//0이 아닌 경우 stack에 쌓기
			for (int k = 0; k < K; k++) {
				int num = sc.nextInt();
				if (num != 0) {
					stack.push(num);
				}else {
					if(!stack.isEmpty()) stack.pop();
				}
			}
			
			// stack에 있는 값 합 구하기
			int sum = 0;
			for (int num:stack) {
				sum +=num;
			}
			System.out.printf("#%d %d\n", tc, sum);

		} // tc

		sc.close();
	}// main
}// class
