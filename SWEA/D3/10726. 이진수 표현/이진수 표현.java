import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			String answer = "ON";
			String binary = Integer.toBinaryString(M);
			String prev = "";

			// N개 만큼의 2진수 길이가 만들어지지 않을 때 0을 앞에 붙인다
			for (int i = 0; i < N - binary.length(); i++) {
				prev += "0";
			}

			String str = prev + binary;

//			System.out.println(str);

			for (int i = 0; i < N; i++) {
				if (str.charAt(str.length() - 1 - i) != '1') {
					answer = "OFF";
					break;
				}
			}

			System.out.printf("#%d %s\n", tc, answer);

		}

		sc.close();
	}
}
