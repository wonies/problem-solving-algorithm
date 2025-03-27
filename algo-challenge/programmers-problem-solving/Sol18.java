package study;
// 연속 부분 수열 합의 개수
import java.io.*;
import java.util.*;

class Sol18 {
	public int solution(int[] elements) {
		int answer = 0;

		Set<Integer> unique = new HashSet<>();
		int len = elements.length;
		int part = 1;
		for (int idx=1; idx<=len; idx++)
		{
			for (int start=0; start<len; start++)
			{
				int cnt = 0;
				for (int i = start; i < start + part; i++)
					cnt += elements[i % len];
				unique.add(cnt);
			}
			part++;
		}
		return unique.size();
	}
}
