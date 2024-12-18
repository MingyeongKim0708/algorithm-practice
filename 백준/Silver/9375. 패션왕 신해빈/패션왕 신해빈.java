import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			int clothes = Integer.parseInt(br.readLine());

			Map<String, Integer> set = new HashMap<String, Integer>();
			
			for (int c = 0; c < clothes; c++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				st.nextToken(); // 의상이름은 중요하지 않음 어차피 중복 X
				
				String parts = st.nextToken(); // 어떤 종류인지
				set.put(parts, set.getOrDefault(parts, 0) + 1);
			}
			
			int result = 1;

			// 착용 가능 수(Map의 value 값) + 착용 안하는 경우 1
			for(Map.Entry<String, Integer> entry : set.entrySet()) {
				result *= entry.getValue() + 1;
			}
			
			// 아무것도 착용하지 않는 경우 -1
			result--;
			
			System.out.println(result);
		}//tc

	}
}


// 의상 종류가 eyewear: 1, headgear: 2라면:
// eyewear 착용 가능 수: (1 + 1) (착용하지 않음 + 1개 착용).
// headgear 착용 가능 수: (2 + 1) (착용하지 않음 + 1개, 2개 중 하나 착용).
// 두 종류의 조합은 (1+1) * (2+1)입니다.
// 모든 종류에 대해 곱한 후, 최소 한 가지는 착용해야 하므로 아무것도 착용하지 않는 경우 1을 빼야 합니다.
