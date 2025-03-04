package study;
// 게임맵최단거리
import java.io.*;
import java.util.*;

class Sol34 {

	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};


	public int solution(int[][] maps) {
		int n = maps.length;
		int m = maps[0].length;

		boolean[][] visited = new boolean[n][m];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{0, 0, 1});
		visited[0][0] = true;

		while (!queue.isEmpty())
		{
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];
			int dis = cur[2];

			if (x == n - 1 && y == m - 1)
				return dis;
			for (int i=0; i<4; i++)
			{
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && maps[nx][ny] == 1)
				{
					visited[nx][ny] = true;
					queue.offer(new int[]{nx, ny, dis + 1});
				}
			}
		}

		return -1;
	}
}
