package study;

// 시소짝꿍
// sort하고 계산하니 시간이 엄청 단축됨!! *** => 정답

import java.io.*;
import java.util.*;

class Sol63_1 {
	public long solution(int[] weights) {
		long cnt = 0;

		Arrays.sort(weights);
		Map<Integer, Integer> counts = new HashMap<>();
		for (int w: weights)
			counts.put(w, counts.getOrDefault(w, 0) + 1);

		for (int count : counts.values())
		{
			if (count >= 2)
				cnt += (long)count * (count - 1) / 2;
		}

		for (int x : counts.keySet())
		{
			for (int y : counts.keySet())
			{
				if (x >= y) continue ;
				if (x * 2 == y || x * 3 == y * 2 || x * 4 == y * 3)
					cnt += (long)counts.get(x) * counts.get(y);
			}
		}
		return cnt;
	}
}
