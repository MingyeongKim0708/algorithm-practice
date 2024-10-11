import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int K, N;
	static int[] line;

	public static void main(String[] args) throws Exception {

		StringTokenizer st = new StringTokenizer(br.readLine());
		K = stoi(st.nextToken());
		N = stoi(st.nextToken());

		line = new int[K];

		long left = 1;
		long right = line[0];

		for (int i = 0; i < K; i++) {
			line[i] = stoi(br.readLine());
			if (line[i] > right) {
				right = line[i];
			}
		}

		long max = 0;
		while (left <= right) {
			int cnt = 0;
			long mid = (left + right) / 2;

			for (int i = 0; i < K; i++) {
				cnt += (line[i] / mid);
			}

			if (cnt >= N) {
				max = mid; // 일단 max에 값을 저장해둔다. mid가 길어질 수록 갱신 될 것임
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		bw.write(max + "\n");
		bw.flush();
		bw.close();
	}// main

	private static int stoi(String nextToken) {
		return Integer.parseInt(nextToken);
	}
}
