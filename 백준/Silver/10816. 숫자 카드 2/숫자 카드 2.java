import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;
	static Map<Integer, Integer> map;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		N = stoi(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = stoi(st.nextToken());
		}

		// 중복 값이 들어가는 경우가 있음
		// map으로 저장해두고 이진 탐색에서 타겟값 찾으면 map에서 바로 조회해서 개수 찾기
		map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			} else {
				map.put(arr[i], map.get(arr[i]) + 1);
			}
		}

		Arrays.sort(arr);

		M = stoi(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = stoi(st.nextToken());

			binarySearch(arr, num);

		}

		sb.setLength(sb.length() - 1);
		bw.write(sb.toString());
		sb.setLength(0);
		bw.flush();
		bw.close();

	}

	private static void binarySearch(int[] nums, int n) {

		int left = 0;
		int right = N - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] == n) {
				// 같아도 중복된 다른 값이 있을 수 있음
				// map에 저장된 값을 보고 개수 출력
				sb.append(map.get(n) + " ");
				return;
			}

			if (arr[mid] < n) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		sb.append(0 + " ");
		return;
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
