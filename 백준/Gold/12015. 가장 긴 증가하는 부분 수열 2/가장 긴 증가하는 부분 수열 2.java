import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N, answer;
	static int[] nums;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		nums = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		ArrayList<Integer> lis = new ArrayList<>(); // LIS를 저장할 리스트

		for (int i = 0; i < N; i++) {
			int num = nums[i];
			if (lis.isEmpty() || lis.get(lis.size() - 1) < num) {
				lis.add(num); // LIS가 비어있거나 현재 숫자가 가장 크다면 추가
			} else {
				// Lower Bound를 찾아서 그 위치에 현재 숫자를 넣음
				int idx = lowerBound(lis, num);
				lis.set(idx, num); // 기존 값을 현재 값으로 갱신
			}
		}

		answer = lis.size(); // LIS의 길이가 최장 증가 부분 수열의 길이
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
	}

	// 이진 탐색을 통해 LIS 리스트에서 num이 들어갈 위치를 찾음 (lower bound)
	private static int lowerBound(ArrayList<Integer> lis, int num) {
		int left = 0;
		int right = lis.size();

		while (left < right) {
			int mid = (left + right) / 2;
			if (lis.get(mid) < num) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return left;
	}
}

/*
 * 그 위치에 숫자를 넣는 이유는, **최장 증가 부분 수열(LIS)**의 길이를 구하는 데 초점을 맞추기 때문입니다. 여기서 중요한 점은,
 * LIS의 실제 원소들이 무엇인지는 구체적으로 중요하지 않고, LIS의 길이만이 중요하다는 점입니다.
 * 
 * 이 방식의 핵심 아이디어는 다음과 같습니다: 리스트에 숫자를 추가하거나 갱신하는 목적은 LIS의 길이를 유지하면서, 숫자를 최소한으로
 * 낮추는 것입니다. lis 리스트는 항상 "최장 증가 부분 수열"을 완성하는 것이 아니라, 길이를 유지하는 것을 목표로 합니다. 예를 들어,
 * 리스트에 들어간 값들은 현재까지 만들어진 LIS의 가능성을 열어두는 것뿐입니다. 그 위치에 넣는 이유는 무엇인가요? lis.set(idx,
 * num) 이 부분은, LIS에서 숫자를 낮추는 행위라고 볼 수 있습니다. 숫자를 바꿔치기하는 이유는, 더 큰 숫자로 이어지는 가능성을
 * 열어두기 위함입니다. 이렇게 하는 이유는, 이후에 더 큰 숫자들이 들어왔을 때, 그 숫자들이 더 긴 증가 부분 수열을 만들 수 있게 하기
 * 위함입니다.
 * 
 * 만약 lowerBound를 통해 찾은 위치에 현재 숫자를 넣는 로직(lis.set(idx, num))이 없다면, LIS(최장 증가 부분
 * 수열)를 올바르게 계산할 수 없게 됩니다. 그 결과, LIS의 길이가 잘못 계산될 가능성이 매우 큽니다.
 * 
 * 이 부분의 로직이 중요한 이유는, LIS의 길이를 효율적으로 유지하고 갱신하기 위함입니다. 만약 이 로직이 없을 경우, LIS의 길이를
 * 올바르게 계산하지 못하게 됩니다. 구체적으로 어떤 문제가 발생할지 살펴보겠습니다.
 * 
 * 주요 문제점: LIS 확장 불가:
 * 
 * lis.set(idx, num)는 더 작은 숫자로 갱신함으로써 이후에 더 큰 숫자가 들어올 수 있는 기회를 마련합니다. 이 갱신이 없으면,
 * 리스트의 크기만 커지지, 이후 들어오는 숫자들이 올바르게 리스트에 추가될 자리를 찾지 못하게 됩니다. 예를 들어, 만약 29가 30 자리에
 * 들어가야 하는데 이 갱신을 하지 않으면, 이후에 50이 들어올 때 올바른 위치에 추가될 수 없습니다. LIS의 길이 부정확성:
 * 
 * 이 부분이 없다면 LIS가 늘어날 때마다 리스트 끝에 무조건 값을 추가하게 됩니다. 하지만 LIS는 항상 오름차순이어야 하기 때문에, 값을
 * 갱신하지 않으면 잘못된 길이가 나옵니다. 갱신하지 않고 계속 추가만 하면, 최종적으로 증가하지 않는 수열도 LIS의 일부로 포함되어,
 * 길이가 실제보다 더 길게 계산될 수 있습니다. 최종 LIS 계산 실패:
 * 
 * 중간에 작은 값이 올바른 위치에 들어가지 않으면, 이후 숫자가 올바른 위치에 삽입되지 못하고, 결과적으로 LIS 길이가 잘못 계산됩니다.
 * 예시로 살펴보자: 입력: 6, 10 20 30 29 30 50
 * 
 * 이 로직이 없는 경우, 다음과 같은 문제가 발생합니다.
 * 
 * 첫 번째 숫자: 10
 * 
 * lis = [10] 두 번째 숫자: 20
 * 
 * lis = [10, 20] 세 번째 숫자: 30
 * 
 * lis = [10, 20, 30] 네 번째 숫자: 29
 * 
 * 이때 29는 30보다 작기 때문에, 원래는 30 자리에 29가 들어가야 합니다. 하지만 이 로직이 없으면 lis 리스트가 그대로 유지되고,
 * 29는 추가되지 못합니다. 올바른 처리: lis = [10, 20, 29]로 갱신되어야 하지만, 이 로직이 없으면 갱신되지 않음. 다섯
 * 번째 숫자: 30
 * 
 * lis는 [10, 20, 30] 상태로 계속 유지되며, 30이 추가됩니다. 그러나, 이전에 29가 갱신되지 않았기 때문에 LIS가 잘못
 * 계산됩니다. 결과적으로 길이가 잘못된 값이 유지됩니다. 여섯 번째 숫자: 50
 * 
 * 50이 lis 리스트 끝에 추가되지만, 앞선 과정에서 29가 들어가야 할 자리에 들어가지 못해 최종 길이도 올바르게 계산되지 않음. 최종
 * 결과 (로직이 없는 경우): lis = [10, 20, 30, 50] 잘못된 LIS 길이: 4 결론: 만약 이 로직이 없다면, **최장
 * 증가 부분 수열(LIS)**을 계산하는 도중 리스트에 값들이 제대로 갱신되지 않게 되어 LIS의 길이가 정확하지 않게 됩니다. 특히,
 * 숫자가 감소하는 경우에 제대로 처리되지 않아 최종 결과가 잘못 나옵니다.
 * 
 * 따라서 lowerBound로 값을 찾고, 해당 위치에 값을 갱신하는 로직은 필수적입니다. 이 로직이 없으면, 올바른 LIS 길이를 계산할
 * 수 없게 됩니다.
 */
