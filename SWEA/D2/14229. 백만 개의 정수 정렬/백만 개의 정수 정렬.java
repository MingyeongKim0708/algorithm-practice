import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int[] arr;
	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new FileReader("input_mil.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input_mil2.txt"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[1000000];
//		arr = new int[10];
//		int[] arr2 = arr;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int N = arr.length;

		// 퀵정렬 
		quickSort(0, N - 1);
		System.out.println(arr[500000]);
//		System.out.println(arr[5]);

	}

	static void quickSort(int left, int right) {
		if (left < right) {
			int pivot = partition(left, right);
			quickSort(left, pivot - 1);
			quickSort(pivot + 1, right);
		}

	}

	static int partition(int left, int right) {
		int pivot = arr[left];
		int L = left + 1;
		int R = right;

		while (L <= R) {
			while (L <= R && arr[L] <= pivot)
				L++;
			while (arr[R] > pivot)
				R--;

			if (L < R) {
				int tmp = arr[L];
				arr[L] = arr[R];
				arr[R] = tmp;
			}
		}

		int tmp = arr[left];
		arr[left] = arr[R];
		arr[R] = tmp;
		return R;

	}

}
