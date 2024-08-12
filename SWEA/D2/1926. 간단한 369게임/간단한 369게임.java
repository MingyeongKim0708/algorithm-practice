import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	public void Solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		// 0번쨰 인덱스는 사용하지 않음
		// 3, 6, 9를 확인하기 위해 String으로 받음
		String[] s_num = new String[N + 1];
		for (int n = 1; n < N + 1; n++) {
			s_num[n] = String.valueOf(n);

			// 3, 6, 9 포함 확인
			if (s_num[n].contains("3") || s_num[n].contains("6") || s_num[n].contains("9")) {
				s_num[n] = s_num[n].replace("3", "-");
				s_num[n] = s_num[n].replace("6", "-");
				s_num[n] = s_num[n].replace("9", "-");
			}

			// 3,6,9가 들어가고 다른 숫자가 있다면 박수 한 번
			if (s_num[n].contains("-") && s_num[n].contains("0")) {
				s_num[n] = "-";
			} else if (s_num[n].contains("-") && s_num[n].contains("1")) {
				s_num[n] = "-";
			} else if (s_num[n].contains("-") && s_num[n].contains("2")) {
				s_num[n] = "-";
			} else if (s_num[n].contains("-") && s_num[n].contains("4")) {
				s_num[n] = "-";
			} else if (s_num[n].contains("-") && s_num[n].contains("5")) {
				s_num[n] = "-";
			} else if (s_num[n].contains("-") && s_num[n].contains("7")) {
				s_num[n] = "-";
			} else if (s_num[n].contains("-") && s_num[n].contains("8")) {
				s_num[n] = "-";
			}
		}

		// 결과
		for (int n = 1; n < N + 1; n++) {
			bw.write(s_num[n] + " ");
		}
		bw.newLine();

		br.close();
		bw.close();
	}// solution

	public static void main(String[] args) throws Exception {
		new Solution().Solution();
	}

}
