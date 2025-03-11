
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());

		int num = A * B * C;
		int[] cnt = new int[10];

		String nums = num + "";
		int len = nums.length();

		for (int i = 0; i < len; i++) {
			int n = nums.charAt(i) - 48; // '0' = 48
			cnt[n]++;
		}

		for (int i = 0; i < 10; i++) {
			System.out.println(cnt[i]);
		}

	}

}
