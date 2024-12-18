import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;

	public static void main(String[] args) throws Exception{
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<Integer, String> poke = new LinkedHashMap<Integer, String>();
		Map<String, Integer> poke2 = new LinkedHashMap<String, Integer>();
		


		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			poke.put(i, s);
			poke2.put(s, i);
		}

		sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String q = br.readLine();
			
			if(isNumeric(q)) {
				sb.append(poke.get(Integer.parseInt(q))).append("\n");
			}
			else {
				sb.append(poke2.get(q)).append("\n");
			}
			
		}
		
		System.out.println(sb);
	}

	// 숫자 판별 함수
	private static boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false; // 변환 실패 -> 문자가 포함된 경우
		}
	}
}
