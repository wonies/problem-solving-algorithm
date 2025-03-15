package study;

import java.io.*;
import java.util.*;
// 2개 이하의 다른 비트

class Sol52 {
	public long[] solution(long[] numbers) {
		long[] ans = new long[numbers.length];
		int k =0;
		for (int i=0; i<numbers.length; i++)
		{
			if (numbers[i] % 2 == 0)
				ans[k++] = numbers[i] + 1;
			else
			{
				long bit = 1;
				long temp = numbers[i];
				while (true)
				{
					if ((temp & bit) == 0)
						break ;
					bit *= 2;
				}
				bit /= 2;
				ans[k++] = temp + bit;
			}
		}
		return ans;
	}
}
