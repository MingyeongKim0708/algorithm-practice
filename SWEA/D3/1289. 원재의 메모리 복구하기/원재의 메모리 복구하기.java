import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	public void Solution() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			// 원본 메모리
			String str = br.readLine();
			int len = str.length();
			int[] complete = new int[len];
			
			for(int i = 0; i<len; i++) {				
				complete[i] = str.charAt(i) - '0';
			}
			
			int[] start = new int[len];
			int count = 0;

			for(int i = 0; i < len ; i++) {
				if(complete[i] == 1 && start[i] == 0) {
					count++;
					int temp = i;
					while(temp < len) {
						start[temp] = 1;
						temp++;
					}
				}
				else if (complete[i] ==0 && start[i] == 1) {
					count++;
					int temp = i;
					while(temp < len) {
						start[temp] = 0;
						temp++;
					}
				}
			}//for
			
			bw.write("#" + tc + " " + count + "\n");
		}//tc
		br.close();
		bw.close();
		
	}
	public static void main(String[] args) throws Exception {
		new Solution().Solution();
	}
}
