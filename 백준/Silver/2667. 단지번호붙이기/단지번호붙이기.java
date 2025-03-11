
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int N;
	static char[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] == '1') {
					list.add(dfs(i, j));
				}
			}
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for(int count : list) {
			System.out.println(count);
		}
		
	}

	

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	
	private static int dfs(int r, int c) {
		visited[r][c] = true;
		int count = 1;
		
		for(int i =0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == '1' && !visited[nr][nc]) {
				count += dfs(nr, nc);
			}
		}
		return count;
	}



}
