import java.util.Scanner;

public class Solution {

	static int N;
	static int[] board;
	static int count;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			board = new int[N]; // 인덱스 번호 : 행
			count = 0;

			nQueen(0);
			System.out.println("#" + tc + " " + count);

		}

	}

	static void nQueen(int idx) {
		// 기저 조건
		if (idx == N) {
			count++; // 조건에 해당하는 개수 증가
			return;
		}

		// 재귀 부분
		for (int i = 0; i < N; i++) {
			board[idx] = i; // 이러면 한 행에 하나 밖에 못 놓는 구조여서 행은 검사 하지 않아도 된다

			// 놓을 수 있다면
			if (Promising(idx)) {
				nQueen(idx + 1);
			}
		}
	}

	static boolean Promising(int idx) {

		for (int i = 0; i < idx; i++) {
			if (board[idx] == board[i]) {
				return false; // 같은 열에 존재하면 안됨
			}

			else if (Math.abs(idx - i) == Math.abs(board[idx] - board[i])) {
				return false; // 대각선 상에 존재하면 안됨
			}
		}
		return true;
	}
}
