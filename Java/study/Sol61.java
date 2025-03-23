package study;

// 연속된 부분 수열의 합

import java.util.*;
import java.io.*;

class Sol61 {
	public int[] solution(int[] sequence, int k) {

		int lt = 0, rt = 0, sum = 0;
		int front = 0, rear = sequence.length - 1;
		int min = Integer.MAX_VALUE;

		while (rt < sequence.length)
		{
			sum += sequence[rt];
			while (sum > k)
				sum -= sequence[lt++];
			if (sum == k)
			{
				int len = rt - lt + 1;
				if (len < rear - front + 1)
				{
					front = lt;
					rear = rt;
				}
			}
			rt++;
		}

		return new int[]{front, rear};
	}
}
