import java.util.Scanner;

public class Solution {
	static int N, M;
	static int[] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();

			parent = new int[N + 1];
			for (int i = 0; i < N; i++) {
				parent[i] = i;
			}

			System.out.print("#" + tc + " ");
			for (int i = 0; i < M; i++) {
				int op = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();

				if (op == 0) {
					// 두 집합 합치기
					union(a, b);
				} else {
					// 같은 집합인지 확인하기
					if (findSet(a) == findSet(b)) {
						System.out.print(1);
					} else {
						System.out.print(0);
					}
				}
			}
			System.out.println();

		} // tc
	}// main

	static void union(int a, int b) {
		// 최고 조상을 찾아서 바꿔줘야함 -> findSet
		a = findSet(a);
		b = findSet(b);
		parent[a] = b;
	}

	static int findSet(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = findSet(parent[x]);

	}

}
