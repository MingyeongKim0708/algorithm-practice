import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, C;
	static int[] home;

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		C = stoi(st.nextToken());
		home = new int[N];
		for (int i = 0; i < N; i++) {
			home[i] = stoi(br.readLine());
		}

		Arrays.sort(home);

//		System.out.println(Arrays.toString(home));
		// 최소 거리 1, 최대 거리 home[N-1] - home[0]로 설정하여 함수 호출
		// 위치가 아니라 거리를 줄여나가면서 이진탐색을 한다
		binarySearch(home, 1, home[N - 1] - home[0]);

	}// main

	private static void binarySearch(int[] h, int left, int right) {
		int result = 0;

		while (left <= right) {
			int mid = (left + right) / 2;
			int cnt = 1; // 기본적으로 첫 번째 집에 설치된 한 개
			int front = h[0]; // 첫 번째 집에 설치

			// 현재 mid 거리로 공유기 설치하기
			for (int i = 1; i < N; i++) {
				if (h[i] >= front + mid) {
					cnt++;
					front = h[i];
				}
			}

			// 공유기 개수 체크
			if (cnt >= C) {
				result = mid; // 일단 가능한 케이스이므로 저장
				left = mid + 1; // 더 큰 간격 찾기
				// 공유기가 더 많이 설치된 경우일 수도 있으므로 >=
				// 이게 길이 최대치라는 보장이 없기 때문에 계속 길이의 최대치를 구해야함 -> left를 줄여서 가장 큰 값 찾기
			} else {
				right = mid - 1;
			}

		}
		System.out.println(result);

	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
