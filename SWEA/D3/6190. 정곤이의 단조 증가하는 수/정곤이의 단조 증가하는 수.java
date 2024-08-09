import java.io.BufferedReader;
//import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public void Solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input_danjo.txt"));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] number = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				number[i] = Integer.parseInt(st.nextToken());
			}

			// 두 수의 곱이 나오는 개수
			int len = 0;
			for (int i = 1; i <= N - 1; i++) {
				len += i;
			}

			// 두 수의 곱
			int[] value = new int[len];
			int count = 0;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					value[count] = number[i] * number[j];
					count++;
				}
			}

			// 각 숫자가 단조 증가하는 수인지 체크
			int max = -1;
				for (int i = 0; i < len; i++) {
					
					// 단조 증가수 여부
					boolean flag = true;
					
					// 검사하는 숫자
					int check = value[i];
					
					while(check >0) {
						int digitB = check % 10;
						int digitA = (check / 10) % 10;
						
						// 앞자리가 뒷자리보다 크다면 단조 증가 수가 아니다
						if (digitA > digitB) {
							flag = false;
							break;
						}
						check = check / 10;
					}
					
					// 단조 증가하는 수라면 max 체크
					if (max < value[i] && flag == true) {
						max = value[i];
					}
				}
			
			System.out.printf("#%d %d\n", tc, max);

		} // tc

	}// solution

	public static void main(String[] args) throws Exception {
		new Solution().Solution();
	}
}
