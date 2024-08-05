import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			
			int[][] answer = new int[N][N];
			
			//(0,0)에 해당하는 값은 무조건 1
			answer[0][0] = 1;
			
			//현재좌표(시작점)
			int r = 0;
			int c = 0;
			
			//델타 사용
			//동-남-서-북
			int[] dr = {0, 1, 0, -1};
			int[] dc = {1, 0, -1, 0};
			
			int num = 2;
			int directionCase = 0; //시작 진행 방향 동쪽(0)
			
			while(num <= N*N) {
				int nr = r + dr[directionCase];
				int nc = c + dc[directionCase];
				
				//인덱스범위를 넘어나거나 0이 아님(이미 방문한곳)
				//방향 변경
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || answer[nr][nc] != 0) {
					directionCase = (directionCase + 1) % 4;
					continue;
				}
				
				//방향을 바꾸지 않는 경우
				//숫자를 넣어주고 +1
				answer[nr][nc] = num++;
				
				//좌표 이동
				r = nr;
				c = nc;
			}
			
			//출력
			System.out.println("#" + testCase);
			
			for (int row = 0; row < N; row++) {
				String line = "";
				for (int col = 0; col < N; col++) {
					line += answer[row][col] + " "; //이 경우 가장 마지막 공백이 들어감
				}
				// 양 끝 공백 제거(중간 공백은 유지)
				System.out.println(line.trim());
			}
		}
		
		sc.close();
	}
}
