import java.util.*;

class Sol94 {
	static int n, m;
	static char[][] board;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public int solution(String[] storage, String[] requests) {
		n = storage.length;
		m = storage[0].length();
		board = new char[n][m];

		// storage 문자열을 2차원 char 배열로 변환
		for (int i = 0; i < n; i++) {
			board[i] = storage[i].toCharArray();
		}

		for (String req : requests) {
			char target = req.charAt(0);
			if (req.length() == 2) {
				// 크레인: 모든 해당 알파벳 제거
				removeAll(target);
			} else {
				// 지게차: 외부 접근 가능한 것만 제거
				visited = new boolean[n][m];
				Queue<int[]> queue = new LinkedList<>();

				// 외곽에서부터 탐색 시작
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

	// 크레인으로 모든 target 제거
	private void removeAll(char target) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == target) {
					board[i][j] = '.';
				}
			}
		}
	}

	// 경계(외부) 위치인지 판단
	private boolean isBorder(int i, int j) {
		return i == 0 || i == n - 1 || j == 0 || j == m - 1;
	}

	// 유효한 좌표인지 판단
	private boolean isValid(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < m;
	}

	// 남은 컨테이너 수 세기
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
