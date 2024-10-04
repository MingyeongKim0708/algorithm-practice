import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[] moneyUnits = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };

	public static void main(String[] args) throws Exception {

		int T = stoi(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = stoi(br.readLine());
			sb.append("#").append(tc).append("\n");

			for (int unit : moneyUnits) {
				sb.append(N / unit).append(" ");
				N %= unit; // 나머지 금액으로 업데이트
			}

			sb.append("\n");

		} // tc

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}

}

////////////////////////// 안쓰는 코드
//String str = br.readLine();
//char[] moneyChar = str.toCharArray();
//
//String man = "";
//// 0번째부터 뒤에서 5번째까지는 하나로 합치기
//for (int i = 0; i < str.length() - 4; i++) {
//	man += moneyChar[i];
//}
//
//int manInt = 0;
//if(!man.isEmpty()) {
//	manInt = stoi(man);
//}
//
//// 5만원권
//sb.append(manInt / 5 + " ");
//
//// 1만원권
//sb.append(manInt % 5 + " ");
//
//// 천, 백, 십, 일자리
//for (int i = str.length() - 5; i < str.length(); i++) {
//
//	int check = moneyChar[i] - '0';
//	
//	// 5 단위
//	sb.append(check / 5 + " ");
//	
//	// 1 단위
//	sb.append(check % 5 + " ");
//}
