import java.io.File;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
		// 연산1 : 삽입
		// 연산2 : 최댓값 출력 후 해당 키값 삭제

		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("heap_input.txt"));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(sc.nextLine());

		// 내림차순 - 최대힙

		for (int tc = 1; tc <= T; tc++) {
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			int N = Integer.parseInt(sc.nextLine());
			for (int n = 0; n < N; n++) {
				String str = sc.nextLine();
				String[] strList = str.split(" ");
				int[] s = new int[strList.length];

				for (int i = 0; i < strList.length; i++) {
					s[i] = Integer.parseInt(strList[i]);
				}

				if (s[0] == 1) {
					pq.add(s[1]);
				} else {
					if (pq.isEmpty()) {
						sb.append(-1).append(" ");
					} else {
						int popItem = pq.poll();
						sb.append(popItem).append(" ");
					}
				}
			}

			sb.setLength(sb.length() - 1);

			System.out.println("#" + tc + " " + sb.toString());

			sb.setLength(0);

		} // tc

		sc.close();
	}// main
}
