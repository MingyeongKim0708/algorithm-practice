import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
//import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public void Solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 명령 횟수
		int N = Integer.parseInt(br.readLine());

		// 스택
		ArrayDeque<Integer> stack = new ArrayDeque<>();

		for (int trial = 1; trial <= N; trial++) {
			// 1 은 정수 x가 들어오니까 한 줄에 2개의 값을 입력받게됨
			// 나머지는 정수 하나만 입력 받음

			// 입력 받는 것
			String line = br.readLine();

			// 명령 구분
			char command = line.charAt(0);
			
			switch(command) {
			case '1': // stack.push(x)
				StringTokenizer st = new StringTokenizer(line);
				st.nextToken(); // 명령1이 들어가는 위치
				int x = Integer.parseInt(st.nextToken());
				stack.push(x);
				break;
			case '2': // stack.pop()
				if(stack.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(stack.pop()).append("\n");
				}
				break;
			case '3': // stack.size()
				sb.append(stack.size()).append("\n");
				break;
			case '4': // stack.isEmpty()
				if(stack.isEmpty()) {
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
				break;
			case '5':
//				 System.out.println("스택이 있다면 peek");
				if(stack.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(stack.peek()).append("\n");
				}
				break;
			}//swtich
		}//trial
		
		sb.setLength(sb.length() -1);
		System.out.println(sb.toString());
	}// solution

	public static void main(String[] args) throws Exception {
		new Main().Solution();

	}// main
}
