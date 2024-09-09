import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	static int N, M;
	static int[] p; // 대표자를 넣어두는 배열
	static int A, B;

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			p = new int[N + 1]; // 1번사람부터 시작

			for (int i = 1; i <= N; i++) {
				p[i] = i;
			}

			sc.nextLine(); // 한줄 처리

			// 반례 : 무조건 한 줄에 2개의 값이 들어오지 않는 경우 고려
			for (int i = 0; i < M; i++) {

				String line = sc.nextLine();
				String[] tokens = line.split(" ");

				if (tokens.length == 2) {
					int first = Integer.parseInt(tokens[0]);
					int second = Integer.parseInt(tokens[1]);
					union(first, second);

//					System.out.print(first + " " + second + " : ");
//					System.out.println(Arrays.toString(p));

				}

			}

			// 대표자 번호 종류 세기
			Set<Integer> set = new HashSet<>();

			// set.add(p[i])가 아니라 set.add(findSet(p[i])
			// 두 그룹으로 진행되다가 마지막에 하나의 그룹으로 합쳐졌을 때 갱신되지 않는 케이스가 있을 수도 있다
			for (int i = 1; i <= N; i++) {
				set.add(findSet(p[i]));
			}

//			System.out.println(set.size());
//			System.out.println(Arrays.toString(p));

			System.out.println("#" + tc + " " + set.size());
		}

		sc.close();

	}

	private static void union(int a, int b) {
		p[findSet(b)] = findSet(a);

	}

	private static int findSet(int x) {
		if (x == p[x])
			return x;

		return p[x] = findSet(p[x]);
	}
}
