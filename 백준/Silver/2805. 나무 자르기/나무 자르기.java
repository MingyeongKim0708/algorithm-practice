import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N, M;
	static int[] tree;

	public static void main(String[] args) throws Exception {

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());

		int maxTree = 0;
		tree = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tree[i] = stoi(st.nextToken());
			if (tree[i] > maxTree) {
				maxTree = tree[i];
			}
		}

		// 길이 0부터 maxTree까지가 H의 범위
		binarySearch(tree, 0, maxTree);

	}

	private static void binarySearch(int[] tr, int left, int right) {

		int result = 0; // H의 값

		while (left <= right) {
			int mid = (left + right) / 2;
			long sum = 0; // 합계 범위가 int형을 넘어갈 수 있음
			// mid높이에서 잘랐을 때 얻을 수 있는 나무의 길이 총합
			for (int i = 0; i < N; i++) {
				if (tr[i] >= mid)
					sum += tr[i] - mid;
			}

			// 나무길이의 합이 M보다 큰지 작은지 확인
			if (sum >= M) {
				result = mid; // 일단 원하는 길이 이상으로 얻었으니 높이 저장
				// 더 적은 범위를 얻을 수 있는지 검사 필요함
				left = mid + 1;
			} else { // 원하는 만큼의 나무를 못얻었으므로 높이를 좀 더 낮춘다
				right = mid - 1;
			}
		}
		System.out.println(result);
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
