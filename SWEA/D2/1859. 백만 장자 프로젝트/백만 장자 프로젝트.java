import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public void Solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			// N일간의 가격 저장 배열
			int[] price = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}

			// 현재 가격이 미래보다 싸다면 구매, 현재 가격이 미래보다 비싸다면 판매
			// 구매한 것을 Queue에 저장
			// 판매시 (현재가격 - Queue에 있는 값)의 합

			Queue<Integer> queue = new LinkedList<>();
			long gain = 0;

			// i는 현재 가격 위치
			for (int i = 0; i < N - 1; i++) {
				// 그날의 구매 여부
				boolean buy = false;

				// j는 탐색하는 미래 가격 위치
				for (int j = i + 1; j < N; j++) {
					if (price[i] < price[j]) {
						queue.add(price[i]);
						buy = true;
						break;
					}
				} // j
				
				// 현재 가격 기준 미래를 다 돌아봤지만 구매할 게 없음.
				// queue에 사둔 것이 있다면 팔기.
				// 구매한 날은 판매하면 안됨
				if (!buy) {
					while (!queue.isEmpty()) {
						int sell = queue.poll();
						gain += price[i] - sell;
					}
				}
			} // i
			
			// 마지막날은 무조건 판매
			while (!queue.isEmpty()) {
				int sell = queue.poll();
				gain += price[N - 1] - sell;
			}

			System.out.printf("#%d %d\n", tc, gain);

		} // tc

	}// Solution

	public static void main(String[] args) throws Exception {
		new Solution().Solution();
	}// main

}// class
