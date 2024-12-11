import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	static StringBuilder sb2;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		sb2 = new StringBuilder();
		
		while(true) {
			String s = br.readLine();
			sb = new StringBuilder(s);
			
			String reverse = sb.reverse().toString();
			
			if(s.equals("0")) {
				break;
			}
			
			if(s.equals(reverse)) {
				sb2.append("yes").append("\n");
			}else {
				sb2.append("no").append("\n");
			}
			
		}
		
		System.out.println(sb2);
		
	}
}
