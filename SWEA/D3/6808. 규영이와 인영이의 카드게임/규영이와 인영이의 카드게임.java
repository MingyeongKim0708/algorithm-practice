import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static int[] gyu;
	static int[] in;

	static boolean[] visited;
	static int[] result;

	static int winCount;
	static int loseCount;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		gyu = new int[9];
		in = new int[9];
		visited = new boolean[9];
		result = new int[9];

		for (int tc = 1; tc <= T; tc++) {
			// 규영이 카드
			for (int i = 0; i < 9; i++) {
				gyu[i] = sc.nextInt();
			}

			// 규영이가 가진 카드 확인
			int[] checkCard = new int[19]; // 0번 인덱스 사용 x
			for (int i = 0; i < 9; i++) {
				checkCard[gyu[i]] = 1;
			}

//			System.out.println(Arrays.toString(checkCard));

			// 인영이 카드
			int idxIn = 0;
			for (int i = 1; i <= 18; i++) {
				if (checkCard[i] != 1) {
					in[idxIn++] = i;
				}
			}

			// 인영이의 승리, 패배 횟수
			winCount = 0;
			loseCount = 0;

			perm(0);
			// 규영이의 승/패 (인영이의 패/승)
			System.out.println("#" + tc + " " + loseCount + " " + winCount);

		} // tc

		sc.close();
	}// main

	static void perm(int idx) {
		// 인영이의 카드 조합 완성
		if (idx == 9) {
			// 점수 계산
			calScore();
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (visited[i])
				continue;

			result[idx] = in[i];
			visited[i] = true;
			perm(idx + 1);
			visited[i] = false;

		}

	}

	// 점수 계산
	static void calScore() {
		int gyuScore = 0;
		int inScore = 0;

		// 높은 수가 적힌 카드를 낸 사람은 두 카드에 적힌 수의 합만큼 점수를 얻고,

		for (int i = 0; i < 9; i++) {
			if (gyu[i] > result[i]) {
				gyuScore += gyu[i] + result[i];
			} else {
				inScore += gyu[i] + result[i];
			}
		}

		if (inScore > gyuScore) {
			winCount++;
		} else if (inScore < gyuScore) {
			loseCount++;
		}
	}

}
