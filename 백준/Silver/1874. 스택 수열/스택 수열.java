
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();

		int N = Integer.parseInt(br.readLine());
		int count = 1; // push할 다음 숫자

		boolean possible = true;

		for (int i = 0; i < N; i++) {
			int target = Integer.parseInt(br.readLine());

			// target까지 push
			while (count <= target) {
				stack.push(count++);
				sb.append("+\n");
			}

			// stack의 top이 target인지 확인
			if (stack.peek() == target) {
				stack.pop();
				sb.append("-\n");
			} else {
				possible = false;
				break;
			}

		}
		
		if (possible) {
			System.out.print(sb.toString());
		} else {
			System.out.println("NO");
		}
	}

	// 일단 생각 중인 풀이 적어놓기
	// 1부터 n까지 올라가는 숫자 count
	// 숫자가 가리키는 값 point 이거 필요한가 머리가 안돌아가네
	// stack에 count 하나씩 증가하는 값 넣기
	// br.readline으로 읽은 숫자가 pop이 가능한지 보기
	// 이미 빠져나가버린 값이면 NO
	// 예를 들어 5, 1 2 5 3 4면
	// 1 : push pop // point 1 다음 count 2
	// 2 : push pop // point 2 다음 count 3
	// 5 : push push push pop // point 5 다음 count 6
	// 3 : pop pop // point3 다음 count 6
	// 4 : push 해야하는데 다음 count가 6이라서 안됨
	// 결론 : push하려는데 다음 count가 point(br.readline) 값 보다 크다면 NO가 출력 된다
}
