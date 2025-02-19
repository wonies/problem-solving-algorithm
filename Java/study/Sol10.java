package study;

import java.io.*;
import java.util.*;

class Sol10 {
	public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		int capet = brown + yellow;
		for (int i=3; i<=capet; i++)
		{
			if (capet % i == 0)
			{
				int j = capet / i;
				if ((i-2) * (j-2) == yellow)
				{
					answer[0] = Math.max(i, j);
					answer[1] = Math.min(i, j);
					return answer;
				}
			}
		}
		return answer;
	}
}
