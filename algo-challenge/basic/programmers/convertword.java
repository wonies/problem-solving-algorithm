import java.util.*;
import java.io.*;

class convertword {
	static boolean[] visited;

	public boolean to_target(String begin, String word) {
		int diff = 0;
		for (int i = 0; i < begin.length(); i++) {
			if (begin.charAt(i) != word.charAt(i)) {
				diff++;
			}
		}
		return diff == 1;
	}

	public int dfs(String begin, String target, String[] words, int cnt)
	{
		if (begin.equals(target))
		{
			return cnt;
		}

		int min_cnt = Integer.MAX_VALUE;
		int next;
		for(int i=0; i< words.length; i++)
		{
			if (!visited[i] && to_target(begin, words[i]))
			{
				visited[i] = true;
				next = dfs(words[i], target, words, cnt+1);
				if (next != Integer.MAX_VALUE)
				{
					min_cnt = Math.min(min_cnt, next);
				}
				visited[i] = false;
			}
		}

		return min_cnt;
	}

	public int solution(String begin, String target, String[] words) {
		int answer = 0;
		visited = new boolean[words.length];
		answer = dfs(begin, target, words, 0);
		return answer == Integer.MAX_VALUE ? 0 : answer;
	}
}