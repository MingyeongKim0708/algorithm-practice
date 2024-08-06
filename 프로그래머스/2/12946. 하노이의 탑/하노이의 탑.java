class Solution {
    
    private int index = 0;
    
    // 하노이의 탑은 2^N -1 번이 최소 횟수
	public int[][] solution(int n) {
		int[][] answer = new int[(int) Math.pow(2, n) - 1][2];
		// n개의 원판, 출발, 도착, 거쳐가는곳, 경로저장배열
		hanoi(n, 1, 3, 2, answer);
		return answer;
	}

	public void hanoi(int n, int start, int end, int via, int[][] answer) {
		// 원판이 1개면 바로 도착지로 이동
		if (n == 1) {
			answer[index++] = new int[] { start, end }; // 배열 초기화
		}
		// 원판이 여러 개일 때
		else {
			// 가장 큰 것을 제외한 것(n-1)은 다른 기둥에 있어야 함
			// 이 전체를 옮기는 것도 결국 또 한 기둥에서 다른 기둥을 거쳐 목적지 기둥으로 이동하는 것
			// 목적지 기둥은 가장 큰 것이 갈 것이므로 여기서는 최종 목적지 기둥을 거쳐가는 포인트로 써야하니 via와 end를 바꿔준다
			// 재귀호출
			hanoi(n - 1, start, via, end, answer);
			
			// 가장 큰 링을 목적지 기둥으로 옮긴다.
			answer[index++] = new int[] { start, end };
			
			// 아까 via에 두었던 n-1개의 기둥도 결국 목적지로 다시 이동시켜야한다.
			// 재귀호출
			hanoi(n - 1, via, end, start, answer);
		}
	}
}