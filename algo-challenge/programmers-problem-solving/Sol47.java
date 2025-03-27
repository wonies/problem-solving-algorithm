package study;

import java.io.*;
import java.util.*;

class Sol47 {

	public int solution(int x, int y, int n) {

		Queue<int[]> queue = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();

		queue.offer(new int[]{x, 0});
		visited.add(x);

		while (!queue.isEmpty())
		{
			int[] cur = queue.poll();
			int val = cur[0];
			int cnt = cur[1];

			if (val == y)
			{
				return cnt;
			}

			int[] nextVal = {
				val * 2, val * 3, val + n
			};

			for (int next : nextVal)
			{
				if (next <= y && !visited.contains(next))
				{
					queue.offer(new int[]{next, cnt+1});
					visited.add(next);
				}
			}
		}
		return -1;
	}
}
