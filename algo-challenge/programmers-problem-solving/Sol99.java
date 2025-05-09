import java.util.*;

class Sol99 {
	public int[] solution(int m, int n, int[][] picture) {
		boolean[][] visited = new boolean[m][n];
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		int[] dx = {-1, 1, 0, 0}; // 상하좌우
		int[] dy = {0, 0, -1, 1};

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && picture[i][j] != 0) {
					numberOfArea++;
					int size = bfs(i, j, picture, visited, m, n, dx, dy);
					maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
				}
			}
		}

		return new int[]{numberOfArea, maxSizeOfOneArea};
	}

	private int bfs(int x, int y, int[][] picture, boolean[][] visited, int m, int n, int[] dx, int[] dy) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{x, y});
		visited[x][y] = true;
		int color = picture[x][y];
		int size = 1;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cx = cur[0];
			int cy = cur[1];

			for (int dir = 0; dir < 4; dir++) {
				int nx = cx + dx[dir];
				int ny = cy + dy[dir];

				if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
					if (!visited[nx][ny] && picture[nx][ny] == color) {
						visited[nx][ny] = true;
						queue.offer(new int[]{nx, ny});
						size++;
					}
				}
			}
		}

		return size;
	}
}
