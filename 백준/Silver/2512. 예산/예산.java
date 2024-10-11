import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N, M;
	static int[] city;
	static long answer;

	public static void main(String[] args) throws Exception {

		N = stoi(br.readLine());
		city = new int[N];

		long left = 1;
		long right = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			city[i] = stoi(st.nextToken());
			if (city[i] > right) {
				right = city[i];
			}
		}

		M = stoi(br.readLine());

		while (left <= right) {
			long mid = (left + right) / 2;
			long sum = 0;
			// 예산 총합
			for (int i = 0; i < N; i++) {
				if (city[i] > mid) {
					sum += mid;
				} else {
					sum += city[i];
				}
			}
			// 총예산 다씀
			if (sum == M) {
				answer = mid;
				break;
			}

			// 예산 다 쓰지 않았지만 범위 내
			if (sum < M) {
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		bw.write(answer + "");
		bw.flush();

	}

	private static int stoi(String line) {
		return Integer.parseInt(line);
	}
}
