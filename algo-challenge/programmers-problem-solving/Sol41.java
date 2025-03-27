package study;
// 더맵게
import java.io.*;
import java.util.*;

class Sol41 {
	public int solution(int[] scoville, int K) {
		int cnt = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int s: scoville)
			pq.add(s);
		while (pq.peek() < K)
		{
			if (pq.size() < 2)
				return -1;

			int f = pq.poll();
			int s = pq.poll();

			int mix = f + (s * 2);
			pq.add(mix);
			cnt++;
		}
		return cnt;
	}
}
