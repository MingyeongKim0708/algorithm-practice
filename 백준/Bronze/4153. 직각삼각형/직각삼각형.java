import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();

		int[] nums = { -1, -1, -1 };

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			nums[0] = Integer.parseInt(st.nextToken());
			nums[1] = Integer.parseInt(st.nextToken());
			nums[2] = Integer.parseInt(st.nextToken());

			if(nums[0] == 0 && nums[1] == 0 && nums[2] == 0) break;
			
			Arrays.sort(nums);
			

			if (Math.pow(nums[2], 2) == Math.pow(nums[0], 2) + Math.pow(nums[1], 2)) {
				sb.append("right").append("\n");
			} else {
				sb.append("wrong").append("\n");
			}

		}

		System.out.println(sb);

	}

}
