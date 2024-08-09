import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 손님 수
			int M = sc.nextInt(); // 붕어빵 만드는데 걸리는 시간
			int K = sc.nextInt(); // M초당 만들 수 있는 붕어빵

			// 손님별 도착시간 배열
			int[] client = new int[N];

			for (int i = 0; i < N; i++) {
				client[i] = sc.nextInt();
			}
			
			//순서대로 온다는 보장이 없으므로 정렬
			Arrays.sort(client);
			String answer = "Possible";
			
			for(int i =0; i< N; i++) {
				int time = client[i];
				
				// time / M  : 지금까지 붕어빵 만드는 사이클 몇 번 돌았는가?
				// (time / M) * K : 지금까지 만들어진 붕어빵 개수
				if((time/M) * K <  i + 1) {
					answer = "Impossible";
				}
			}
			
			System.out.println("#" + tc + " " + answer);

		}
	}
}
