import java.util.*;

class Sol103 {
	static int[] dx = {-1, 0, 1, 0}; // 상우하좌
	static int[] dy = {0, 1, 0, -1};
	static boolean[][][] visited;
	static int n, m;

	public List<Integer> solution(String[] grid) {
		List<Integer> result = new ArrayList<>();
		n = grid.length;
		m = grid[0].length();
		visited = new boolean[n][m][4];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int d = 0; d < 4; d++) {
					if (!visited[i][j][d]) {
						int len = move(grid, i, j, d);
						result.add(len);
					}
				}
			}
		}

		Collections.sort(result);
		return result;
	}

	static int move(String[] grid, int x, int y, int dir) {
		int count = 0;
		while (!visited[x][y][dir]) {
			visited[x][y][dir] = true;
			count++;

			char c = grid[x].charAt(y);
			if
