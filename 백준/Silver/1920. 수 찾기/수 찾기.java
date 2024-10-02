import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] A;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = stoi(br.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = stoi(st.nextToken());
		}

		// 이진 탐색을 위해서는 정렬이 필수
		Arrays.sort(A);

		M = stoi(br.readLine());
		st = new StringTokenizer(br.readLine());
		// 들어오는 값마다 이진 탐색을 해서 있는지 확인하기
		for (int i = 0; i < M; i++) {
			binarySearch(A, stoi(st.nextToken()));
		}

	}

	private static void binarySearch(int[] arr, int target) {
		// 양쪽의 인덱스
		int left = 0;
		int right = N - 1; // 배열 A의 크기만큼 탐색해야 하므로 N - 1을 사용

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (A[mid] == target) {
				System.out.println(1);
				return;
			}

			// 만약 중앙값이 타겟값보다 작다면 왼쪽은 볼 필요 없음
			if (A[mid] < target) {
				left = mid + 1;
			} else { // 중앙값이 타겟값보다 크다면 오른쪽은 볼 필요 없음
				right = mid - 1;
			}
		}
		
		// 값이 없다면
		System.out.println(0);
		return;
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
