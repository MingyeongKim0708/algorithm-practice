import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static char[][] field;
	static int H, W, N;
	static int tankR, tankC, tankD; // 탱크의 위치(r,c), 탱크의 방향
	static int bombR, bombC; // 폭탄의 위치
	static int[] dir = { 0, 1, 2, 3 }; // 방향 (U D L R 순서)

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input_battle.txt"));
//		BufferedReader br = new BufferedReader(new FileReader("input_battle2.txt"));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			// 필드 만들기 + 탱크 위치 파악
			field = new char[H][W];

			for (int r = 0; r < H; r++) {
				sb.append(br.readLine());
				for (int c = 0; c < W; c++) {
					field[r][c] = sb.charAt(c);

					// 탱크 위치, 방향 기억하기

					if (field[r][c] == '^' || field[r][c] == 'v' || field[r][c] == '<' || field[r][c] == '>') {
						tankR = r;
						tankC = c;
						if (field[r][c] == '^') {
							tankD = dir[0];
						} else if (field[r][c] == 'v') {
							tankD = dir[1];
						} else if (field[r][c] == '<') {
							tankD = dir[2];
						} else if (field[r][c] == '>') {
							tankD = dir[3];
						}
					}
				}
				sb.setLength(0); // sb 초기화

			}

			sb.setLength(0); // sb 초기화

			N = Integer.parseInt(br.readLine());
			sb.append(br.readLine());

//			System.out.println(Arrays.deepToString(field));
//			System.out.println("처음 배열");
//			for (int i = 0; i < H; i++) {
//				System.out.println(Arrays.toString(field[i]));
//			}
//			System.out.println("==============");

			// 전차 명령 수행
			for (int i = 0; i < N; i++) {
				char order = sb.charAt(i);
				bombR = tankR;
				bombC = tankC;

				if (order == 'S') {
					if (tankD == dir[0]) {
						while (bombR >= 0 && bombR < H && field[bombR][bombC] != '#' && field[bombR][bombC] != '*') {
							bombR--;
						}
						if (bombR >= 0 && bombR < H && field[bombR][bombC] == '*') {
							field[bombR][bombC] = '.';
						}
					} else if (tankD == dir[1]) {
						while (bombR >= 0 && bombR < H && field[bombR][bombC] != '#' && field[bombR][bombC] != '*') {
							bombR++;
						}
						if (bombR >= 0 && bombR < H && field[bombR][bombC] == '*') {
							field[bombR][bombC] = '.';
						}
					} else if (tankD == dir[2]) {
						while (bombC >= 0 && bombC < W && field[bombR][bombC] != '#' && field[bombR][bombC] != '*') {
							bombC--;
						}
						if (bombC >= 0 && bombC < W && field[bombR][bombC] == '*') {
							field[bombR][bombC] = '.';
						}
					} else if (tankD == dir[3]) {
						while (bombC >= 0 && bombC < W && field[bombR][bombC] != '#' && field[bombR][bombC] != '*') {
							bombC++;
						}
						if (bombC >= 0 && bombC < W && field[bombR][bombC] == '*') {
							field[bombR][bombC] = '.';
						}
					}

					// 이동은 못하더라도 방향은 바뀐다는 것을 유념하자
				} else if (order == 'U') {
					tankD = dir[0];
					if (tankR - 1 >= 0 && tankR - 1 < H && field[tankR - 1][tankC] == '.') {
						field[tankR][tankC] = '.'; // 있던 위치 평지화
						tankR--; // 이동
						field[tankR][tankC] = '^';
					}

				} else if (order == 'D') {
					tankD = dir[1];
					if (tankR + 1 >= 0 && tankR + 1 < H && field[tankR + 1][tankC] == '.') {
						field[tankR][tankC] = '.'; // 있던 위치 평지화
						tankR++; // 이동
						field[tankR][tankC] = 'v';
					}
				} else if (order == 'L') {
					tankD = dir[2];
					if (tankC - 1 >= 0 && tankC - 1 < W && field[tankR][tankC - 1] == '.') {
						field[tankR][tankC] = '.'; // 있던 위치 평지화
						tankC--; // 이동
						field[tankR][tankC] = '<';
					}

				} else if (order == 'R') {
					tankD = dir[3];
					if (tankC + 1 >= 0 && tankC + 1 < W && field[tankR][tankC + 1] == '.') {
						field[tankR][tankC] = '.'; // 있던 위치 평지화
						tankC++; // 이동
						field[tankR][tankC] = '>';
					}
				}

				// 탱크 방향
				if (tankD == dir[0]) {
					field[tankR][tankC] = '^';
				} else if (tankD == dir[1]) {
					field[tankR][tankC] = 'v';
				} else if (tankD == dir[2]) {
					field[tankR][tankC] = '<';
				} else if (tankD == dir[3]) {
					field[tankR][tankC] = '>';
				}

//				System.out.println("---------------------------" + i);
//				for (int id = 0; id < H; id++) {
//					System.out.println(Arrays.toString(field[id]));
//				}
			}

			// 최종 출력 테스트용
//			System.out.println("최종");
//			for (int i = 0; i < H; i++) {
//				System.out.println(Arrays.toString(field[i]));
//			}

			System.out.print("#" + tc + " ");
			for (int i = 0; i < H; i++) {
				sb.setLength(0);
				for (int j = 0; j < W; j++) {
					sb.append(field[i][j]);
				}
				System.out.println(sb.toString());
			}

			sb.setLength(0);

		} // tc

	}// main
}
