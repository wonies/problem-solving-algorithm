import java.util.*;

class Sol95 {
	static int n, m;
	static char[][] board;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public int solution(String[] storage, String[] requests) {
		n = storage.length;
		m = storage[0].length();
		board = new char[n][m];

		for (int i = 0; i < n; i++) {
			board[i] = storage[i].toCharArray();
		}

		for (String req : requests) {
			char target = req.charAt(0);
			if (req.length() == 2) {
				removeAll(target);
			} else {
				visited = new boolean[n][m];
				Queue<int[]> queue = new LinkedList<>();

				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						if (isBorder(i, j) && board[i][j] != '.' && !visited[i][j]) {
							queue.offer(new int[]{i, j});
							visited[i][j] = true;
						}
					}
				}

				while (!queue.isEmpty()) {
					int[] curr = queue.poll();
					int x = curr[0], y = curr[1];
					if (board[x][y] == target) board[x][y] = '.';

					for (int d = 0; d < 4; d++) {
						int nx = x + dx[d];
						int ny = y + dy[d];
						if (isValid(nx, ny) && !visited[nx][ny] && board[nx][ny] != '.') {
							visited[nx][ny] = true;
							queue.offer(new int[]{nx, ny});
						}
					}
				}
			}
		}

		return countRemaining();
	}


	private void removeAll(char target) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == target) {
					board[i][j] = '.';
				}
			}
		}
	}

	private boolean isBorder(int i, int j) {
		return i == 0 || i == n - 1 || j == 0 || j == m - 1;
	}

	private boolean isValid(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < m;
	}

	private int countRemaining() {
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] != '.') count++;
			}
		}
		return count;
	}
}
