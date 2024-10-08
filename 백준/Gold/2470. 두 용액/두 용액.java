import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	static int N, R;
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
		
		Arrays.sort(nums);
		
		int left = 0;
		int right = nums.length-1;

		answer = Integer.MAX_VALUE;
		
		while(left<right) {
			// 바로 0이 나오면 더이상 탐색 필요 X
			if(nums[left] + nums[right] == 0) {
				a = nums[left];
				b = nums[right];
				break;
			}
			
			int sum = Math.abs(nums[left] + nums[right]);

			// 두 용액의 합이 0에 가까워질 수록 갱신
			if(sum<answer) {
				a = nums[left];
				b = nums[right];
				answer= sum;
			}
			
			// right의 절대값이 크다면 right 포인터를 줄인다
			if(Math.abs(nums[left]) < Math.abs(nums[right])) {
				right--;
			}else {
				left++;
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
