import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());

		int answer = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int ch = Integer.parseInt(st.nextToken());

			answer += isDecimal(ch);
		}
		
		System.out.println(answer);

	}

	private static int isDecimal(int ch) {
		double num = Math.sqrt(ch);

		if(ch == 1) return 0;
        
        if(ch == 2) return 1;
		
		for (int i = 2; i < num + 1; i++) {
			if (ch % i == 0) {
				return 0;
			}
		}
		return 1;

	}
}
