import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public void Solution() {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();

			// 로봇의 현재 위치
			int locB = 1;
			int locO = 1;
			
			// 명령 시행 횟수
			int time = 0;
			int timeB = 0;
			int timeO = 0;

			// 명령을 저장할 배열
			// 0 : 명령 없음
			int[] orderB = new int[N];
			int[] orderO = new int[N];

			for (int n = 0; n < N; n++) {
				String robot = sc.next();
				int button = sc.nextInt();
				if (robot.equals("B")) {
					orderB[n] = button;
				} else if (robot.equals("O")) {
					orderO[n] = button;
				}
			}

			// 명령 수행
			for (int n = 0; n < N; n++) {
				// B의 명령 수행
				if (orderB[n] != 0) {
					timeB += Math.abs(orderB[n] - locB) + 1;
					// B가 명령하는 수행 시간이 기존 시간 보다 길다면 갱신
					if (time < timeB) {
						time = timeB;
					}else { // 아니라면 미리 이동해서 대기하고 있었으므로 button push만 하면 됨
						time++; // push
						timeB = time;
					}
					locB = orderB[n];
				}
				else {
					// O의 명령 수행
					timeO += Math.abs(orderO[n] - locO) + 1;
					if (time < timeO) {
						time = timeO;
					}else {
						time++;
						timeO = time;
					}
					locO = orderO[n];
				}
			}//명령수행
			
			System.out.printf("#%d %d\n", tc, time);

		} // tc

	}

	public static void main(String[] args) {
		new Solution().Solution();
	}

}
