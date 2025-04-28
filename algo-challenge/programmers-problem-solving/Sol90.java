//혼자놀기의 달인

import java.io.*;
import java.util.*;

class Solution {
	public int solution(int[] cards) {
		boolean[] visited = new boolean[cards.length];
		List<Integer> groups = new ArrayList<>();


		for (int i = 0; i < cards.length; i++) {
			if (!visited[i])
			{
				int cnt = 0;
				int idx = i;

				while (!visited[idx]) {
					visited[idx] = true;
					idx = cards[idx] - 1;
					cnt++;
				}
				groups.add(cnt);
			}
		}

		if (groups.size() < 2)
			return 0;

		Collections.sort(groups, Collections.reverseOrder());

		return groups.get(0) * groups.get(1);
	}
}
