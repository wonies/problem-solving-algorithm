package study;

import java.io.*;
import java.util.*;
// n^2 배열자르기
class Sol21 {
	public int[] solution(int n, long left, long right) {
		int size = (int)(right - left + 1);
		int[] res = new int[size];

		for (int i=0; i<size;i++)
		{
			long idx = left + i;
			int row = (int)(idx / n);
			int col = (int)(idx % n);
			res[i] = Math.max(row, col) + 1;
		}
		return res;
	}
}
