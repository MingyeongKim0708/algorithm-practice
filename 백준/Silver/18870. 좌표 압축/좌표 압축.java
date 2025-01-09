import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());

		int[] origin = new int[N];
		int[] sorted = new int[N];

		HashMap<Integer, Integer> rank = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			sorted[i] = origin[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(sorted);

		int ranking = 0;

		for (int i : sorted) {
			if (!rank.containsKey(i)) {
				rank.put(i, ranking);
				ranking++;
			}
		}

		sb = new StringBuilder();

		for (int i : origin) {
			int r = rank.get(i);
			
			sb.append(r).append(' ');
		}
		
		System.out.println(sb);

	}

}
