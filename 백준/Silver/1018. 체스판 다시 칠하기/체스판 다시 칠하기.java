import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static char[][] map;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 행
		int M = Integer.parseInt(st.nextToken()); // 열

		int result = Integer.MAX_VALUE; // 최소로 칠해야하는 수

		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				int change = check(i, j);
				int change2 = check2(i, j);
				
				result = Math.min(Math.min(change, result), change2);
			}
		}

		System.out.println(result);
	}

	// w 시작
	private static int check(int i, int j) {
		int count = 0;
		int status = 0; // W시작
		for (int r = i; r < i + 8; r++) {
			for (int c = j; c < j + 8; c++) {
				// 0이어야하는데 0이 아님
				if (status == 0 && map[r][c] != 'W') {
					count++;
				}
				// 1이어야하는데 1이 아님
				else if (status == 1 && map[r][c] != 'B') {
					count++;
				}

				// status 변경
				status = (status + 1) % 2;
			}
			// 행 바꿀 때 status 변경
			status = (status + 1) % 2;
		}
		return count;
	}

	// B 시작
	private static int check2(int i, int j) {
		int count = 0;
		int status = 1; // B시작
		for (int r = i; r < i + 8; r++) {
			for (int c = j; c < j + 8; c++) {
				// 0이어야하는데 0이 아님
				if (status == 0 && map[r][c] != 'W') {
					count++;
				}
				// 1이어야하는데 1이 아님
				else if (status == 1 && map[r][c] != 'B') {
					count++;
				}
				// status 변경
				status = (status + 1) % 2;
			}
			// 행 바꿀 때 status 변경
			status = (status + 1) % 2;
		}
		return count;
	}

}
