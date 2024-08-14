import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

// Tree Node
class Node {
	int index;
	String data;
	Node leftNode;
	Node rightNode;

	// 생성자
	public Node(int index) {
		this.index = index;
		this.data = "";
		leftNode = null;
		rightNode = null;
	}

	@Override
	public String toString() {
		return "Node [index=" + index + ", data=" + data + ", leftNode=" + leftNode + ", rightNode=" + rightNode + "]";
	}
}


public class Solution {

	static Node[] tree;
	static Stack<Double> stack;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// tc = 10
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt(); // 노드 수
			tree = new Node[N+1];

			for (int n = 0; n < N; n++) {
				int nodeNum = sc.nextInt();
				String data = sc.next();
				Node node = new Node(nodeNum);
				node.data = data;
				
				// 자식 노드 불러오기
				String str = sc.nextLine();
				str = str.trim();
				
				// 만약 자식 노드가 있다면
				if(str.length() != 0) {
					String[] LR = str.split(" ");
					int[] LR2 = new int[LR.length];
//					System.out.println(Arrays.toString(LR));
					
					// 형변환
					for(int i=0; i<LR.length; i++) {
						LR2[i] = Integer.parseInt(LR[i]);
					}
//					System.out.println(Arrays.toString(LR2));
					
					if(LR2.length == 2) {
						node.leftNode = new Node(LR2[0]);
						node.rightNode = new Node(LR2[1]);
					}else if(LR.length == 1) {
						node.leftNode = new Node(LR2[0]);
					}
					
//					System.out.println(LR2[0] + " " + LR[1]);
					
				}
				
				
				tree[nodeNum] = node;

			}

			stack = new Stack<>();
			
			postorder(1);
			int answer = (int) (double) stack.pop(); // Double 객체 -> double 기본형 -> int 캐스팅
			System.out.printf("#%d %d\n", tc, answer);

		} // tc
		sc.close();
	}// main

	// 후위 순회
	public static void postorder(int root) {
		if (root >= tree.length || tree[root] == null) {
			return;
		}
		Node node = tree[root];
		
		if (node.leftNode != null) {
			postorder(node.leftNode.index);
		}
		if (node.rightNode != null) {
			postorder(node.rightNode.index);
		}
		
		operation(node.data);
	}

	// 연산
	public static void operation(String letter) {
		// 연산자가 아닌 경우
		if (!letter.equals("+") && !letter.equals("-") && !letter.equals("*") && !letter.equals("/")) {
			stack.push(Double.parseDouble(letter));
			return;
		}

		// 연산자인 경우
		Double b = stack.pop(); // stack 위에 있는 것이 뒤에 있는 숫자
		Double a = stack.pop();

		switch (letter) {
		case "+":
			stack.push(a + b);
			break;
		case "-":
			stack.push(a - b);
			break;
		case "*":
			stack.push(a * b);
			break;
		case "/":
			stack.push(a / b);
			break;
		}

	}
}
