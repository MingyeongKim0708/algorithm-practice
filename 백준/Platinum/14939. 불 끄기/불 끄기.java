import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int N = 10; // 10*10칸
	static int[][] bulbs = new int[N][N]; // 전구 상태 0: 꺼짐, 1: 켜짐

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {

		// 전구 상태 입력 받기
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				bulbs[i][j] = (line.charAt(j) == 'O') ? 1 : 0; // (조건) ? 참일 때의 값 : 거짓일 때의 값;
			}
		}

		int min = Integer.MAX_VALUE; // 최소로 스위치를 누르는 횟수

		// 첫번째 행의 경우의 수 2^10(1024)가지 모두 시도하기
		for (int mask = 0; mask < 1 << N; mask++) { // 비트마스킹 1을 10번 << 하기 (1024)
			int[][] temp = new int[N][N];
			for (int i = 0; i < N; i++) {
				System.arraycopy(bulbs[i], 0, temp[i], 0, N); // 깊은 복사로 임시 배열에 저장하기
				// 원본 배열의 i번째 행의 0번 인덱스에서 부터 temp의 i번째 행의 0번째 인덱스를 N개만큼 복사함
			}

			// 첫번째 행 스위치 조작하기
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if ((mask & (1 << j)) != 0) {
					// 이진수로 해서 헷갈리는데 이게 만약 String으로 들어온 것이었다면 charAt(j)를 하면서 해당 자리가 1인지 판단하고 1이면
					// 스위치를 눌렀다는 것이므로 스위치 눌렀을 때 배열 바뀌는 함수 실행하고 누른 횟수 cnt를 1 증가 시킨다는 의미!
					pressSwitch(temp, 0, j);
					cnt++;
				}
			}

			// 나머지 행 처리하기
			for (int i = 1; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (temp[i - 1][j] == 1) { // 바로 위 전구가 켜져 있으면!! -> 왜 위 전구만 확인할까? 아래에 설명
						pressSwitch(temp, i, j);
						cnt++;
					}
				}
			}

			// 왜 바로 위 전구만 확인할까?
			// 어차피 for문을 돌면서 행을 하나씩 내려가므로 좌, 우, 아래는 십자 모양 중 위쪽 부분이 계속 on/off여부를 파악해서 처리할 것이기
			// 때문에 다른 곳은 체크할 필요가 없다.
			// 전구 상태 변환 함수로 계속 상태만 잘 변화시켜주자

			// 마지막 행까지 전부 꺼졌는지 확인
			boolean allOff = true;
			for (int j = 0; j < N; j++) {
				if (temp[N - 1][j] == 1) { // 마지막행 순회 중에 1이 있으면 켜진 것
					allOff = false;
					break;
				}
			}

			// 모두 꺼졌다면 최소 스위치 횟수 갱신
			if (allOff) {
				min = Math.min(min, cnt);
			}
		}

		// 결과 출력
		int answer = 0;

		if (min == Integer.MAX_VALUE) {
			// 갱신이 되질 않았다는 뜻 = 불가능함
			answer = -1;
		} else {
			answer = min;
		}

		bw.write(answer + "");
		bw.flush();

	}

	// 스위치를 눌렀을 때 전구 상태 변경
	static void pressSwitch(int[][] bulbs, int i, int j) {
		bulbs[i][j] ^= 1; // 현재 전구의 상태 변경
		if (i > 0)
			bulbs[i - 1][j] ^= 1; // 위쪽 전구 변경
		if (i < N - 1)
			bulbs[i + 1][j] ^= 1; // 아래쪽 전구 변경
		if (j > 0)
			bulbs[i][j - 1] ^= 1; // 왼쪽 전구 변경
		if (j < N - 1)
			bulbs[i][j + 1] ^= 1; // 오른쪽 전구 변경
	}

}
