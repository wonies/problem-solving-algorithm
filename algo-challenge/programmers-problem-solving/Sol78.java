// 리코쳇 로봇
import java.io.*;
import java.util.*;

class Sol78 {
	public static int route(char[][] game, boolean[][] visited, int startX, int startY) {
		int cnt = 0;
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{startX, startY});
		visited[startX][startY] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int j = 0; j < size; j++) {
				int[] cur = queue.poll();
				int x = cur[0];
				int y = cur[1];

				if (game[x][y] == 'G') {
					return cnt;
				}

				for (int i = 0; i < 4; i++) {
					int nx = x;
					int ny = y;

					while (true) {
						nx += dx[i];
						ny += dy[i];

						if (nx < 0 || ny < 0 || nx >= game.length || ny >= game[0].length || game[nx][ny] == 'D') {
							nx -= dx[i];
							ny -= dy[i];
							break;
						}
					}

					if ((nx == x && ny == y) || visited[nx][ny]) {
						continue;
					}

					visited[nx][ny] = true;
					queue.offer(new int[]{nx, ny});
				}
			}
			cnt++;
		}
		return -1;
	}

	public int solution(String[] board) {
		int col = board[0].length();
		int row = board.length;
		char[][] game = new char[row][col];
		int s = 0;
		int e = 0;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				char c = board[i].charAt(j);
				game[i][j] = c;
				if (c == 'R') {
					s = i;
					e = j;
				}
			}
		}
		boolean[][] visited = new boolean[row][col];

		return route(game, visited, s, e);
	}
}
