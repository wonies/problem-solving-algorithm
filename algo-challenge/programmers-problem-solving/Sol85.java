// 우박수열 정적분

import java.io.*;
import java.util.*;

class Sol85 {
	private int[] sequence(int k)
	{
		ArrayList<Integer> seq = new ArrayList<>();
		seq.add(k);
		while (k != 1)
		{
			k = (k % 2 == 0) ? k / 2 : k * 3 + 1;
			seq.add(k);
		}
		return seq.stream().mapToInt(i->i).toArray();
	}

	private double dintegral(int s, int e, int[] seq)
	{
		double area = 0;
		for (int i=s; i<e; i++)
		{
			area += (seq[i] + seq[i + 1]) / 2.0;
		}
		return area;
	}

	public double[] solution(int k, int[][] ranges) {
		int[] seq = sequence(k);
		int n = seq.length - 1;
		double []ans = new double[ranges.length];

		int idx = 0;
		for (int [] range : ranges)
		{
			int start = range[0];
			int end = n + range[1];
			if (start > end)
			{
				ans[idx++] = -1;
				continue ;
			}
			double d = dintegral(start, end, seq);
			ans[idx++] = d;
		}
		return ans;
	}
}
