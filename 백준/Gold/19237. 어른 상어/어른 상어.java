import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K;
	static Water[][] sea; // 냄새를 남긴 상어의 번호, 냄새가 남아있는 시간이 저장
	static Shark[] sList;
	// 상하좌우
	static int[] dr = { 0, -1, 1, 0, 0 }; // y좌표
	static int[] dc = { 0, 0, 0, -1, 1 }; // x좌표

	// Water[][] : 냄새를 남긴 상어의 번호, 냄새가 남아있는 시간이 저장됨
	// Shark : 상어의 현재 x,y 좌표, 보고 있는 방향, 보고 있는 방향 별 이동우선순위, 생존여부
	// 상어를 관리할 리스트
	// 상어 한 마리가 남을 때까지 반복문을 돌리고 1000 초과시 상어가 한마리가 되지 않는다면 -1 리턴

	static class Water {
		int num; // 상어 번호
		int time; // 냄새 시간

		public Water(int num, int time) {
			this.num = num;
			this.time = time;
		}

	}

	static class Shark {
		int r; // y좌표
		int c; // x좌표
		int dir; // 현재 보는 방향
		int[][] pDir; // 방향 우선순위
		boolean isAlive; // 생존여부

		public Shark(int r, int c) {
			this.r = r;
			this.c = c;
			this.dir = 0;
			this.pDir = new int[5][5];
			this.isAlive = true;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		K = stoi(st.nextToken());

		sea = new Water[N][N];
		sList = new Shark[M + 1]; // 상어 번호 1번부터 시작

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				sea[i][j] = new Water(stoi(st.nextToken()), -1); // 각 영역에 상어가 없으면 0, water에 시간 : -1
				if (sea[i][j].num != 0) { // 상어 번호가 있다면
					sList[sea[i][j].num] = new Shark(i, j);
					sea[i][j].time = K;
				}
			}
		} // 해역 입력 완료

		// 각 상어의 보는 방향
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			sList[i].dir = stoi(st.nextToken());
		}

		// 각 상어의 방향 우선순위
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= 4; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 1; k <= 4; k++) {
					sList[i].pDir[j][k] = stoi(st.nextToken());
				}
			}
		}
		/////////// 입력 끝 ///////////

		solve();
	}

	private static void solve() {
		int t = 0; // 시간
		while (true) {
			if (t >= 1001) { // 1001초가 넘으면
				System.out.println(-1);
				break;
			}

			if (countShark() == 1) { // 상어가 한 마리 남으면
				System.out.println(t);
				break;
			}

			// 1초가 지날 때마다 모든 해역의 냄새시간 -1
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sea[i][j].time--;
				}
			}

			// 상어 이동
			sMove();

			// 시간 증가
			t++;
		}
	}

	private static void sMove() {
		outer: for (int i = M; i > 0; i--) {

			// 첫번째 : 냄새 없는 칸으로 이동
			int nowDir = sList[i].dir;
			for (int j = 1; j <= 4; j++) {
				int pDir = sList[i].pDir[nowDir][j]; // 방향 정하기
				int nr = sList[i].r + dr[pDir];
				int nc = sList[i].c + dc[pDir];

				// 이동할 수 없다면 다시 방향 바꿔서 탐색하기
				if (!isValid(nr, nc)) {
					continue;
				}

				// 냄새 시간이 0보다 작으면 아무런 냄새가 없다는 뜻
				if (sea[nr][nc].time < 0) {
					sList[i].r = nr;
					sList[i].c = nc;
					sList[i].dir = pDir;
					continue outer;
				}
			}

			// 첫번째에서 이동을 못했다면 자신의 냄새가 있는 칸으로 이동
			nowDir = sList[i].dir;
			for (int j = 1; j <= 4; j++) {
				int pDir = sList[i].pDir[nowDir][j]; // 방향 정하기
				int nr = sList[i].r + dr[pDir];
				int nc = sList[i].c + dc[pDir];

				// 이동할 수 없다면 다시 방향 바꿔서 탐색하기
				if (!isValid(nr, nc)) {
					continue;
				}

				// 내 냄새가 있고 시간이 0 이상인 곳
				if (sea[nr][nc].num == i && sea[nr][nc].time >= 0) {
					sList[i].r = nr;
					sList[i].c = nc;
					sList[i].dir = pDir;
					continue outer;
					// 상어 이동 했으니 i번 상어는 더이상 볼 필요 없음. 이중 for문 밖으로 나가기
				}
			}
		} // outer

		// 상어가 이동했다면 냄새 시간 갱신 필요
		for (int i = M; i > 0; i--) {
			if (!sList[i].isAlive) { // 죽었다면 갱신 필요 없음
				continue;
			}

			sea[sList[i].r][sList[i].c].time = K; // 최대값으로 갱신
			sea[sList[i].r][sList[i].c].num = i; // 이동한 i번 상어 번호 넣기
		}
	}

	// 이동 가능한 해역 안인지 판단
	private static boolean isValid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

	private static int countShark() {
		int cnt = 0;
		for (int i = M; i > 0; i--) { // 가장 숫자가 큰 상어가 우선적으로 잡아먹힐테니까 거꾸로 검사
			if (!sList[i].isAlive) {
				continue;
			}

			// 만약 현재 위치에 i번 상어가 있어야 하는데 그렇지 않다면 이미 다른 상어가 있다는 뜻
			if (sea[sList[i].r][sList[i].c].num != i) {
				sList[i].isAlive = false;
				continue;
			}

			// 여기까지 오면 i번 상어는 살아있다는 뜻
			cnt++;
		}
		return cnt;
	}

	// String -> Int (Integer.parseInt)
	private static int stoi(String string) {
		return Integer.parseInt(string);
	}

}
