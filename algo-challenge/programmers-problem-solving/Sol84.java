//하노이의 탑

import java.io.*;
import java.util.*;

class Sol84 {
	private int [][] answer;
	private int index = 0;

	private void honoi(int n, int s, int m, int e)
	{
		if (n == 1)
			answer[index++] = new int[]{s, e};
		else
		{
			honoi(n-1, s, e, m);
			answer[index++] = new int[]{s, e};
			honoi(n-1, m, s, e);
		}
	}


	public int[][] solution(int n) {
		int res = (int)Math.pow(2, n) - 1;
		answer = new int[res][2];
		honoi(n, 1, 2, 3);

		return answer;
	}
}
