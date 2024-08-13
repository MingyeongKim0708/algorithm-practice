import java.util.Scanner;

public class Solution {

	public void Solution() {
		Scanner sc = new Scanner(System.in);

		int T = Integer.parseInt(sc.nextLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(sc.nextLine());
			// N의 배수를 계속 세어서 0~9의 모든 숫자가 나온다
			// 카운팅 배열
			int[] numLst = new int[10];
			int n = 0;
			while (numLst[0] == 0 || numLst[1] == 0 || numLst[2] == 0 || numLst[3] == 0 || numLst[4] == 0 || numLst[5] == 0 || numLst[6] == 0 || numLst[7] == 0 || numLst[8] == 0 || numLst[9] == 0) {
				
				n++;
				int num = N * n;

				while (num > 0) {
					int digit = num % 10;

					numLst[digit]++;
					num = num / 10;
				}
				
			}

			System.out.printf("#%d %d\n", tc, n*N);
		}//tc
	}

	public static void main(String[] args) {
		new Solution().Solution();
	}
}
