
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Integer> stack = new Stack<>();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String sentence = br.readLine();
			StringTokenizer st = new StringTokenizer(sentence);

			String order = st.nextToken();

			switch (order) {
			case "push": {
				int num = Integer.parseInt(st.nextToken());
				stack.push(num);
				break;
			}
			case "top": {
				if (!stack.isEmpty()) {
					System.out.println(stack.peek());
				} else {
					System.out.println(-1);
				}
				break;
			}
			case "size": {
				System.out.println(stack.size());
				break;
			}
			case "empty": {
				if (stack.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
			}
			case "pop": {
				if (stack.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.pop());
				}
				break;
			}
			}

		}

	}
}
