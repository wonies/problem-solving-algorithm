// 디펜스게임

import java.io.*;
import java.util.*;

class Sol80 {
	public int solution(int n, int k, int[] enemy) {
		int answer = 0;

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		for (int i=0; i<enemy.length; i++)
		{
			n-=enemy[i];
			maxHeap.add(enemy[i]);
			if (n < 0)
			{
				if (k==0) return i;
				n += maxHeap.poll();
				k--;
			}
		}
		return enemy.length;
	}
}
