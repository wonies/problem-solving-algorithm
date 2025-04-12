// 거리두기 확인하기
import java.io.*;
import java.util.*;

class Sol81 {

	static int [] dx = {0, 0, -1, 1};
	static int [] dy = {-1, 1, 0, 0};


	public boolean check(char[][] room, int x, int y)
	{
		boolean [][] visited = new boolean[5][5];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y, 0});
		visited[x][y] = true;

		while (!q.isEmpty())
		{
			int [] cur = q.poll();
			int curX = cur[0];
			int curY = cur[1];
			int dist = cur[2];

			for (int i=0; i<4; i++)
			{
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				int nd = dist + 1;

				if (nx < 0 || nx >= 5 || ny <0 || ny >= 5)
					continue ;
				if (nd > 2)
					continue ;
				if (room[nx][ny] == 'X') continue;
				if (!visited[nx][ny])
				{
					visited[nx][ny] = true;
					if (room[nx][ny] == 'P' && nd <= 2)
						return false;
				}
				q.add(new int[]{nx, ny, nd});
			}
		}
		return true;
	}

	public int checkRoom(String[] place)
	{
		char [][] room = new char[5][5];
		for (int i=0; i<5; i++)
		{
			for (int j=0; j<5; j++)
				room[i][j] = place[i].charAt(j);
		}

		for (int i=0; i<5; i++)
		{
			for (int j=0; j<5; j++)
			{
				if (room[i][j] == 'P')
				{
					if (!check(room, i, j))
						return 0;
				}
			}
		}
		return 1;
	}

	public int[] solution(String[][] places) {
		int[] answer = new int [5];
		for (int i=0; i<5; i++)
			answer[i] = checkRoom(places[i]);
		return answer;
	}
}
