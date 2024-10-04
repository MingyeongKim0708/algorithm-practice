import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] arr;

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
				sb.append(1 + " ");
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
