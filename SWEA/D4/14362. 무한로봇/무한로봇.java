	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.OutputStreamWriter;
	import java.util.StringTokenizer;
	
	public class Solution {
	
		static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		static StringBuilder sb;
	
		static int T;
		static char[] order;
		static int max;
	
		// dir : 0 상, 1 우, 2 하, 3 좌
		static int[] dr = { 1, 0, -1, 0 };
		static int[] dc = { 0, 1, 0, -1 };
	
		public static void main(String[] args) throws NumberFormatException, IOException {
			T = Integer.parseInt(br.readLine());
			sb = new StringBuilder();
	
			for (int tc = 1; tc <= T; tc++) {
				sb.append("#").append(tc).append(" ");
	
				order = br.readLine().toCharArray();
	
				int len = order.length;
				int s = 0, l = 0, r = 0; // 각 명령의 수
	
				for (int i = 0; i < len; i++) {
					if (order[i] == 'S') {
						s++;
					} else if (order[i] == 'L') {
						l++;
					} else if (order[i] == 'R') {
						r++;
					}
				}
	

				// 최대거리 계산
				int maxDistance = getMaxDistance(order);
				if(maxDistance == -1) {
					sb.append("oo\n");
				}else {
					sb.append(maxDistance).append("\n");
				}

			} // tc
	
			System.out.println(sb);
		}// main
	
		private static int getMaxDistance(char[] order) {
			int x = 0, y = 0, dir = 1; // 초기 방향 : 오른쪽
			int maxDistance = 0;
	
			// 최대 4번 반복하여 루프 체크
			for (int i = 0; i < 4; i++) {
				for (char c : order) {
					if (c == 'S') {
						x += dr[dir];
						y += dc[dir];
					} else if (c == 'L') {
						dir = (dir + 3) % 4;
					} else if (c == 'R') {
						dir = (dir + 1) % 4;
					}
	
					int distance = x * x + y * y;
					maxDistance = Math.max(maxDistance, distance);
				}
				
				// 명령 한 번 다 돌았는데 원점에 도착하면 그냥 종료해도 됨
				if(x==0 && y ==0) {
					return maxDistance;
				}
			}
			
//			System.out.println(x +" " + y);
			if(x!=0 || y!=0) {
				return maxDistance =-1;
			}
	
			return maxDistance;
		}
	}
