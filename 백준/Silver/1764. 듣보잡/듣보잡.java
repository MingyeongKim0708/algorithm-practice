import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, Integer> word = new HashMap<String, Integer>();

		// 듣도 못한
		for (int i = 0; i < N; i++) {
			word.put(br.readLine(), 1);
		}

		// 보도 못한
		for (int i = 0; i < M; i++) {
			String name = br.readLine();  // 읽어온 이름을 저장
			word.put(name, word.getOrDefault(name, 0) + 1); // 없으면 0+1, 있으면 1+1
		}
		
		// TreeMap 정렬
		TreeMap<String, Integer> sort = new TreeMap<>(word);
		
		sb = new StringBuilder();
		
		// 출력
		int answer = 0;
        for (Map.Entry<String, Integer> entry : sort.entrySet()) {
        	if(entry.getValue() > 1) {
            	answer++;
        		sb.append(entry.getKey()).append("\n");
            }
        }

        System.out.println(answer + "\n" + sb);
	}
}
