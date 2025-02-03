//프로그래머스 - 피로도
package programmers;

import java.util.*;
import java.io.*;

class fatigue {
	static int num_dun;
	static boolean[] visited;

	public static int dfs(int[][] dungeons, int fatigue, int cnt)
	{
		int max_cnt = cnt;
		for (int i=0; i < num_dun; i++)
		{
			if (!visited[i] && fatigue >= dungeons[i][0])
			{
				visited[i] = true;
				max_cnt = Math.max(max_cnt, dfs(dungeons, fatigue -dungeons[i][1] , cnt + 1));
				visited[i] = false;
			}
		}
		return max_cnt;
	}

	public int solution(int k, int[][] dungeons) {
		int answer = -1;
		num_dun = dungeons.length;
		visited = new boolean[num_dun];
		System.out.print("num_dun : " +  num_dun);
		answer = dfs(dungeons, k, 0);


		return answer;
	}
}