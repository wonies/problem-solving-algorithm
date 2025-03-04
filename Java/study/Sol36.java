package study;

class Sol36 {
	public int solution(String dirs) {
		int cnt = 0;
		int len = dirs.length();
		int x = 5;
		int y = 5;
		boolean[][][][] visited = new boolean[11][11][11][11];

		for (int i=0; i<len; i++)
		{
			int nx = x;
			int ny = y;

			if (dirs.charAt(i) ==  'U')
				y++;
			else if (dirs.charAt(i) == 'D')
				y--;
			else if (dirs.charAt(i) == 'L')
				x--;
			else if (dirs.charAt(i) == 'R')
				x++;
			if (x < 0 || x > 10 || y > 10 || y < 0)
			{
				x = nx;
				y = ny;
				continue;
			}

			if (!visited[nx][ny][x][y] && !visited[x][y][nx][ny])
			{
				cnt++;
				visited[x][y][nx][ny] = true;
				visited[nx][ny][x][y] = true;
			}
		}

		return cnt;
	}
}
