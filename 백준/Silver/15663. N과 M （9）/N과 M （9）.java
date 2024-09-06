import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	// 순열
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] nums;
	static int[] result;
	static boolean[] visit;

	static int[][] count;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		nums = new int[N];
		result = new int[M];

		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}

		Arrays.sort(nums);

		// 방문 체크
		visit = new boolean[N];

		perm(0);

		sc.close();
		bw.flush();
		bw.close();

	}

	private static void perm(int idx) throws Exception {

		if (idx == M) {
			for (int i : result) {
				sb.append(i).append(" ");
			}
			sb.setLength(sb.length() - 1);
			bw.write(sb.toString() + "\n");
			sb.setLength(0);
			return;
		}

		int lastUsed = -1; // 직전 사용값 추적

		for (int i = 0; i < N; i++) {
			if (visit[i] || lastUsed == nums[i])
				continue;
			visit[i] = true;
			result[idx] = nums[i];
			lastUsed = nums[i];
			perm(idx + 1);
			visit[i] = false;
		}
	}

}

// map을 써서 풀어야하나 엄청 고민했는데 직전 값을 저장하기만 하면 되는 케이스였음
//static HashMap<Integer, Integer> map = new HashMap<>();
//for (int i = 0; i < N; i++) {
//if (!map.containsKey(nums[i])) {
//	map.put(nums[i], 1);
//} else {
//	map.put(nums[i], map.get(nums[i]) + 1);
//}
//}
// 숫자 개수 배열
//count = new int[map.size()][2];
//int index = 0;
//for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//    count[index][0] = entry.getKey();   // key 값 저장
//    count[index][1] = entry.getValue(); // value 값 저장
//    index++;
//}
//System.out.println(map);
//System.out.println(Arrays.deepToString(count));