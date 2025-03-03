package study;
// 게임 맵 최딘거리 - 정확성 테스트 통과/ 효율성 테스트  실패
// (dfs로는 길찾기 문제를 못품다고함!)

import java.io.*;
import java.util.*;

class Sol34_1 {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int min;

	private void dfs(int x, int y, int[][] maps, boolean[][] visited, int dis)
	{

		if (x == maps.length-1 && y == maps[0].length-1)
		{
			min = Math.min(min, dis);
			return ;
		}
		if (dis >= min)
			return ;
		for (int i=0; i<4; i++)
		{
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length && !visited[nx][ny] && maps[nx][ny] == 1)
			{
				visited[nx][ny] = true;
				dfs(nx, ny, maps, visited, dis + 1);
				visited[nx][ny] = false;
			}
		}
	}

	public int solution(int[][] maps) {
		boolean[][] visited = new boolean[maps.length][maps[0].length];
		min = Integer.MAX_VALUE;
		dfs(0, 0, maps, visited, 1);
		if (min == Integer.MAX_VALUE)
			return -1;
		return min == Integer.MAX_VALUE ? -1 : min;
	}
}
