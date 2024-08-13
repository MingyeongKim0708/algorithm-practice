import java.util.Scanner;

public class Solution {
	public void Solution() {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			
			int len = str.length();
			int answer = 0;
			
			for (int i = 0; i < len; i++) {
				if(str.charAt(i) == '(') {
					answer++;
				}else if(str.charAt(i) == ')') {
					answer++;
				}
			}
			
			// () 인 경우 중복 빼기
			for (int i = 0; i < len-1; i ++) {
				if(str.charAt(i) == '(' && str.charAt(i+1) == ')') {
					answer--;
				}
			}
			
			System.out.printf("#%d %d\n", tc, answer);

		}// tc
	}

	public static void main(String[] args) {
		new Solution().Solution();
	}

}
