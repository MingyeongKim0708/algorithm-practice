import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[] nums;
	static int answer; // 두 용액의 합
	static int a, b; // 정답

	public static void main(String[] args) throws Exception {

		N = stoi(br.readLine());

		nums = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = stoi(st.nextToken());
		}

		int left = 0;
		int right = N - 1;
		int ans = Integer.MAX_VALUE;

		while (left < right) {
			// 합했을 때 0이 나오면 그대로 끝
			if (nums[left] + nums[right] == 0) {
				a = nums[left];
				b = nums[right];
				break;
			}

			// 아니라면 두개의 합이 0에 가까울 수록 갱신
			int sum = Math.abs(nums[left] + nums[right]);

			if (sum < ans) {
				ans = sum;
				a = nums[left];
				b = nums[right];
			}

			if (Math.abs(nums[left]) > Math.abs(nums[right])) {
				left++;
			} else {
				right--;
			}
		}

		sb.append(a).append(" ").append(b);
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	private static int stoi(String line) {
		return Integer.parseInt(line);
	}
}
