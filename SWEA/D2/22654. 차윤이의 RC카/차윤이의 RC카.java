import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	static int N; // 필드 크기
	static char[][] field; // 필드
	static int Q; // 조종 횟수
	// 커맨드 길이, 커맨드 내용

	public static void main(String[] args) throws Exception {
		int T = stoi(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			sb.append("#").append(tc).append(" ");

			N = stoi(br.readLine());
			field = new char[N][N];

			for (int i = 0; i < N; i++) {
				field[i] = br.readLine().toCharArray();
			}

			// 현재 탱크, 탱크 방향
			int tankR = 0;
			int tankC = 0;
			int tankDir = 0; // 0북 / 1동 / 2남 / 3서
		
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (field[i][j] == 'X') {
						tankR = i;
						tankC = j;
					}
				}
			}
			
			// 탱크 위치 초기화 하기 위해 저장
			int baseR = tankR;
			int baseC = tankC;

			Q = stoi(br.readLine());

			for (int c = 0; c < Q; c++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				int m = stoi(st.nextToken()); // 커맨드 개수
				char[] com = new char[m];
				com = st.nextToken().toCharArray(); // 커맨드 배열
				
				// Q 커맨드 실행마다 탱크 위치, 방향 초기화
				tankR = baseR;
				tankC = baseC;
				tankDir = 0;

				for (int move = 0; move < m; move++) {
					if (com[move] == 'A') { // 전진
						if (tankDir == 0) { // 북쪽
							int nextR = tankR - 1;
							int nextC = tankC;

							// 이동 가능
							if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && field[nextR][nextC] != 'T') {
								tankR = nextR;
								tankC = nextC;
							}
						} else if (tankDir == 1) { // 동쪽
							int nextR = tankR;
							int nextC = tankC + 1;

							// 이동 가능
							if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && field[nextR][nextC] != 'T') {
								tankR = nextR;
								tankC = nextC;
							}
						} else if (tankDir == 2) { // 남쪽
							int nextR = tankR + 1;
							int nextC = tankC;

							// 이동 가능
							if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && field[nextR][nextC] != 'T') {
								tankR = nextR;
								tankC = nextC;
							}
						} else { // 서쪽
							int nextR = tankR;
							int nextC = tankC - 1;

							// 이동 가능
							if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && field[nextR][nextC] != 'T') {
								tankR = nextR;
								tankC = nextC;
							}
						}

					} // A

					else if (com[move] == 'L') {
						tankDir = (tankDir + 4 - 1) % 4;
					}

					else {
						tankDir = (tankDir + 4 + 1) % 4;
					}
				} // move

				// 모든 이동이 끝나고 Y 에 도착했는가?
				if (field[tankR][tankC] == 'Y') {
					sb.append(1).append(" ");
				} else {
					sb.append(0).append(" ");
				}

			} //Q
			
			sb.append("\n");

		} // tc
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}//main

	private static int stoi(String line) {
		return Integer.parseInt(line);
	}
}
