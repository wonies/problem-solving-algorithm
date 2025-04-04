// 프로그래머스 74. 무인도여행
import java.io.*;
import java.util.*;

class Sol74 {
	static int cols;
	static int rows;
	static int max;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public int dfs(int[][] maps, boolean[][] visited, int x, int y)
	{
		visited[x][y] = true;
		int sum = maps[x][y];
		for (int i=0; i<4; i++)
		{
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if (nx >= 0 && ny >= 0 && nx < maps.length && ny < maps[0].length)
			{
				if (!visited[nx][ny] && maps[nx][ny] != -1)
					sum += dfs(maps, visited, nx, ny);
			}
		}
		return sum;
	}

	public int[] solution(String[] maps) {
		ArrayList<Integer> list = new ArrayList<>();
		int rows = maps.length;
		int cols = maps[0].length();
		int[][] map = new int[rows][cols];
		int max = -2;

		for (int i=0; i<rows; i++)
		{
			for (int j=0; j<cols; j++)
			{
				if (maps[i].charAt(j) == 'X')
					map[i][j] = -1;
				else
					map[i][j] = maps[i].charAt(j) - '0';
			}
		}
		boolean[][] visited = new boolean[rows][cols];

		for (int i=0; i<rows; i++)
		{
			for (int j=0; j<cols; j++)
			{
				if (!visited[i][j] && map[i][j] != -1)
				{
					int sum = dfs(map, visited, i, j);
					list.add(sum);
				}
			}
		}
		Collections.sort(list);
		if (list.size() == 0)
			return new int[] {-1};

		return list.stream().mapToInt(i->i).toArray();
	}
}
