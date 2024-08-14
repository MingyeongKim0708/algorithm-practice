import java.util.Scanner;

public class Solution {
	
	static char[] tree;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// tc = 10
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			sc.nextLine();

			tree = new char[N + 1];

			for (int n = 0; n < N; n++) {
				int idx = sc.nextInt();
				String str = sc.nextLine();

//				System.out.println("idx: " + idx);
//				System.out.println("str: " + str);
//				System.out.println("str.charAt(1) : " + str.charAt(1));

				tree[idx] = str.charAt(1);
				
			}
			
//			System.out.println(Arrays.toString(tree));
			
			System.out.printf("#%d ", tc);
			inorder(1);
			System.out.println();

		} // tc
	}
	
	// 중위 순회 L V R
	public static void inorder(int root) {
		if(root >= tree.length || tree[root] == 0) {
			return;
		}
		inorder(root * 2);
		System.out.print(tree[root]);
		inorder(root * 2 + 1);
		
		
	}

}
