import java.util.ArrayList;
import java.util.Arrays;

class Solution {
	public int[] solution(int[] answers) {

		// 1, 2, 3번 수포자 점수
		int[] stuScore = new int[3];

		int[] stu1Answer = new int[answers.length];
		int[] stu2Answer = new int[answers.length];
		int[] stu3Answer = new int[answers.length];

		// 1번 학생의 답지
		stu1Answer[0] = 1;
		int idx = 1;
		while (idx < answers.length) {
			stu1Answer[idx] = (stu1Answer[idx - 1] + 5) % 5 + 1;
			idx++;
		}

		// 2번 학생의 답지
		stu2Answer[0] = 2;
		int idx2 = 1;
		// 홀수 번째 찍는 사이클
		int[] stu2Cycle = { 1, 3, 4, 5 };
		// 홀수 번째 인덱스 체크용
		int idxc = 0;

		while (idx2 < answers.length) {
			if (idx2 % 2 == 0) {
				stu2Answer[idx2] = 2;
			} else {
				stu2Answer[idx2] = stu2Cycle[(idxc + 4) % 4];
				idxc++;
			}
			idx2++;
		}

		// 3번 학생의 답지
		stu3Answer[0] = 3;
		int idx3 = 1;
		while (idx3 < answers.length) {
			if (idx3 % 10 >= 0 && idx3 % 10 < 2) {
				stu3Answer[idx3] = 3;
				idx3++;
			} else if (idx3 % 10 >= 2 && idx3 % 10 < 4) {
				stu3Answer[idx3] = 1;
				idx3++;
			} else if (idx3 % 10 >= 4 && idx3 % 10 < 6) {
				stu3Answer[idx3] = 2;
				idx3++;
			} else if (idx3 % 10 >= 6 && idx3 % 10 < 8) {
				stu3Answer[idx3] = 4;
				idx3++;
			} else {
				stu3Answer[idx3] = 5;
				idx3++;
			}
		}

		// 점수 계산
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == stu1Answer[i]) {
				stuScore[0]++;
			}
			if (answers[i] == stu2Answer[i]) {
				stuScore[1]++;
			}
			if (answers[i] == stu3Answer[i]) {
				stuScore[2]++;
			}
		}

		// 최대 점수를 구한 뒤 각 학생 번호와 대조해서 최대값과 같은 인덱스만 배열에 출력
		int result = Math.max(Math.max(stuScore[0], stuScore[1]), stuScore[2]);

		ArrayList<Integer> arr = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			if (stuScore[i] == result) {
				arr.add(i + 1); // 학생의 번호는 1번부터
			}
		}

		// Arraylist -> Array
		int[] answer = new int[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			answer[i] = arr.get(i);
		}
		return answer;
	}
}