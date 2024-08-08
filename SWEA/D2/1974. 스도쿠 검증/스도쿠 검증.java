import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	public void Solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			// 이차원 배열으로 풀기
			int[][] matrix = new int[9][9];

			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int answer = 1;
			// Set으로 중복 거르고 그 라인 길이랑 비교했을 때 달라지면 중복 값 있다는 뜻
			Set<Integer> set = new HashSet<>();
			
			// label을 설정해서 중복이 발생하면 바로 탈출
			outer:{
				// 가로 중복 검사
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						set.add(matrix[i][j]);
					}
					if (set.size() != matrix[i].length) {
						answer = 0;
						break outer;
					}
					set.clear();
				}
				
				// 세로 중복 검사
				for (int j = 0; j < 9; j++) {
					for (int i = 0; i < 9; i++) {
						set.add(matrix[i][j]);
					}
					if (set.size() != matrix[j].length) {
						answer = 0;
						break outer;
					}
					set.clear();
				}
				
				// 3*3 중복 검사
				for(int r = 0; r < 7; r = r+3) {
					for(int c = 0; c<7; c = c +3) {
						for(int i = 0; i < 3; i++) {
							for(int j = 0; j < 3; j ++) {
								set.add(matrix[r+i][c+j]);
							}
						}
						if(set.size() != 9) {
							answer = 0;
							break outer;
						}
						set.clear();
					}//c
				}//r
			}

			System.out.printf("#%d %d\n", tc, answer);

		} // tc
	}// solution

	public static void main(String[] args) throws Exception {
		new Solution().Solution();
	}// main
}// class
