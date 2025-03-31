// Sol70
// 미로탈출


import java.io.*;
import java.util.*;

class Solution {
	int loc;
	int []dx = {-1, 1, 0, 0};
	int []dy = {0, 0, -1, 1};
	int x;
	int y;

	public int bfs(char [][]map, int startX, int startY, char target)
	{
		int n = map.length;
		int m = map[0].length;
		boolean [][]visited = new boolean[n][m];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {startX, startY, 0});
		visited[startX][startY] = true;

		while(!queue.isEmpty())
		{
			int [] cur = queue.poll();
			int x = cur[0], y = cur[1], time = cur[2];

			if (map[x][y] == target)
				return time;
			for (int i=0; i<4; i++)
			{
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && map[nx][ny] != 'X')
				{
					visited[nx][ny] = true;
					queue.add(new int[]{nx, ny, time + 1});
				}
			}

		}
		return -1;
	}



	public int solution(String[] maps) {
		char [][] map = new char[maps.length][maps[0].length()];
		int startX = 0, startY = 0;
		int leverX = 0, leverY = 0;
		int endX = 0, endY = 0;


		for (int i=0; i<maps.length; i++)
		{
			map[i] = maps[i].toCharArray();
		}

		for (int i=0; i<map.length; i++)
		{
			for (int j=0; j<map[0].length; j++)
			{
				if (map[i][j] == 'S')
				{
					startX = i;
					startY = j;
				}
				else if (map[i][j] == 'L')
				{
					leverX = i;
					leverY = j;
				}
				else if (map[i][j] == 'E')
				{
					endX = i;
					endY = j;
				}
			}
		}

		int timeLever = bfs(map, startX, startY, 'L');
		if (timeLever == -1) return -1;
		int timeExit = bfs(map, leverX, leverY, 'E');
		if (timeExit == -1) return -1;

		return timeLever + timeExit;
	}
}
