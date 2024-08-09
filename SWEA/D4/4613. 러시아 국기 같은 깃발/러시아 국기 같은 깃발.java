import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	public void Solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			// 모든 경우의 수를 구해서 최솟값을 구함
			// W가 나올 수 있는 행 1~N-2
			// B가 나올 수 있는 행 2~N-1
			// R가 나올 수 있는 행 3~N
			
			// 각 행에서의 색상 개수
			int[] W = new int[N];
			int[] B = new int[N];
			int[] R = new int[N];

			// 1. 각 행의 W, B, R 개수 저장
			for(int i =0; i<N; i++) {
				String flagRow = br.readLine();
				for(int j = 0; j<M; j++) {
					char c = flagRow.charAt(j);
					if (c == 'W') W[i]++;
					else if (c == 'B') B[i]++;
					else R[i]++;
				}
			}
			
			// 2. 모든 경우의 수를 확인하여 최솟값 구하기
			int sum = 0;
			for(int i =1; i<=N-2; i++) {
				for (int j = i; j<N-1; j++) {
					int wCnt = 0 ;
					int bCnt = 0 ;
					int rCnt = 0 ;
					
					for(int k =0; k<i; k++) wCnt += W[k]; // W가 나올 수 있는 행에서 W의 개수
					for(int k =i;  k<=j; k++) bCnt += B[k]; // W가 나올 수 있는 행에서 B의 개수
					for(int k=j+1; k<N; k++) rCnt += R[k];
										
					sum = Math.max(sum, wCnt+bCnt+rCnt); // sum이 높을 수록 새로 칠해야 하는 칸의 개수 적음
				}
			}
			
			sum = N*M - sum;
			
			bw.write("#" + tc + " " + sum + "\n");
		} // tc
		br.close();
		bw.close();
	}// solution

	public static void main(String[] args) throws Exception {
		new Solution().Solution();
	}
}
