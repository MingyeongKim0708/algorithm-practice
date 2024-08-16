import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("input_ancestor.txt"));

		int T = sc.nextInt();

		/*
		 * 각 케이스의 첫 번째 줄에는 정점의 개수 V(10 ≤ V ≤ 10000)와 간선의 개수 E, 공통 조상을 찾는 두 개의 정점 번호가
		 * 주어진다.
		 * 
		 * 각 케이스의 두 번째 줄에는 E개 간선이 나열된다. 간선은 항상 “부모 자식” 순서로 표기된다.
		 * 
		 * 위에서 예로 든 트리에서 정점 5와 8을 잇는 간선은 “5 8”로 표기된다.
		 * 
		 * 정점의 번호는 1부터 V까지의 정수이며, 루트 정점은 항상 1번이다.
		 * 
		 * 13 12 8 13 // 1 2 1 3 2 4 3 5 3 6 4 7 7 12 5 9 5 8 6 11 6 10 11 13 간선 개수의 2배?
		 */

		for (int tc = 1; tc <= T; tc++) {
			int V = sc.nextInt(); // 정점의 개수 13
			int E = sc.nextInt(); // 간선의 개수 12
			int nodeA = sc.nextInt(); // 정점A 8
			int nodeB = sc.nextInt(); // 정점B 13

			// 노드 리스트
			int[][] nodeList = new int[V + 1][2];

			// i = 부모 번호
			for (int i = 1; i <= E; i++) {
				int parent = sc.nextInt();
				int child = sc.nextInt();

				// leftNode가 비어있으면 leftNode에 child
				if (nodeList[parent][0] == 0) {
					nodeList[parent][0] = child;
				} else {
					nodeList[parent][1] = child;
				}

			}
			
//			System.out.println(Arrays.deepToString(nodeList));

			// 왼쪽, 오른쪽 노드 보관 배열에서 8, 13을 가진 i를 찾아야함
			// nodeA, B에 대한 부모를 모두 배열리스트에 저장하고
			// 반복문을 돌려서 배열리스트에 해당 값이 존재하면 break
			
			// nodeA의 모든 부모 노드를 arr1에 저장
			ArrayList<Integer> arr1 = new ArrayList<>();
			int temp = nodeA;
			while (temp != 1) {
				for (int i = 1; i <= V; i++) {
					if (nodeList[i][0] == temp || nodeList[i][1] == temp) {
						arr1.add(i);
						temp = i;
						break;
					}
				}
			}
			// nodeB의 모든 부모 노드를 arr2에 저장
			ArrayList<Integer> arr2 = new ArrayList<>();
			temp = nodeB;
			while (temp != 1) {
				for (int i = 1; i <= V; i++) {
					if (nodeList[i][0] == temp || nodeList[i][1] == temp) {
						arr2.add(i);
						temp = i;
						break;
					}
				}
			}

			// 공통 조상 찾기
			int answer = 0;
			for (int node : arr1) {
				if (arr2.contains(node)) {
					answer = node;
					break;
				}
			}

			// subtree 크기 구하기 - 재귀
			int subtreeSize = subtreeSize(nodeList, answer);

			System.out.printf("#%d %d %d\n", tc, answer, subtreeSize);

		} // tc

		sc.close();

	}// main
	
	
	public static int subtreeSize(int[][] nodeList, int currentNode) {
		int size = 1;
		
		// 왼쪽 서브트리 계산
		if(nodeList[currentNode][0] != 0) {
			size += subtreeSize(nodeList, nodeList[currentNode][0]);
		}
		// 오른쪽 서브트리 계산
		if(nodeList[currentNode][1] != 0) {
			size += subtreeSize(nodeList, nodeList[currentNode][1]);
		}
		
		return size;
	}
}
