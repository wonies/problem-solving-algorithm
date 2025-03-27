package study;

//피로도 다시품
import java.util.*;
import java.io.*;

class Sol28_1 {
	static boolean visited[];
	static int ans;

	private static void dfs(int k, int[][] dungeons, int cnt)
	{
		ans = Math.max(ans, cnt);
		for (int i=0; i<dungeons.length; i++)
		{
			if (!visited[i] && k >= dungeons[i][0])
			{
				visited[i] = true;
				dfs(k - dungeons[i][1], dungeons, cnt + 1);
				visited[i] = false;
			}
		}
	}
	public static int solution(int k, int[][] dungeons) {
		ans = 0;
		visited = new boolean[dungeons.length];
		dfs(k, dungeons, 0);
		return ans;
	}

	public static void main(String[] args) {
		int[][] d = {
			{80, 20},
			{50, 40},
			{30, 10}
		};

		System.out.println(solution(80, d));
	}
}
