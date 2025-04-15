
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		int N = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < N; tc++) {

			String s = br.readLine();

			int len = s.length();

			if (len % 2 != 0) {
				sb.append("NO");
			} else {
				sb.append(calc(s, len));
			}

			sb.append("\n");

		}

		System.out.println(sb);

	}

	private static String calc(String s, int len) {
		String answer = "NO";

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(1);
			} else {
				if (stack.isEmpty()) {
					return "NO";
				} else {
					stack.pop();
				}
			}
		}

		if (stack.isEmpty()) {
			answer = "YES";
		} else {
			answer = "NO";
		}

		return answer;
	}

}
