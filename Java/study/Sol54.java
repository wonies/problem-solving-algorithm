package study;

//쿼드 압축 후 개수 세기

import java.io.*;
import java.util.*;

class Sol54 {
	static int zero;
	static int one;

	private static void compress(int x, int y, int size, int[][] arr)
	{
		int init = arr[x][y];
		boolean isSame = true;

		for (int i = x; i < x + size; i++)
		{
			for (int j = y; j < y + size; j++)
			{
				if (arr[i][j] != init)
				{
					isSame = false;
					break ;
				}
			}
			if (!isSame) break;
		}

		if (isSame)
		{
			if (init == 0)
				zero++;
			else
				one++;
		}
		else
		{
			int newsize = size / 2;
			compress(x, y, newsize, arr);
			compress(x, y + newsize, newsize, arr);
			compress(x + newsize, y, newsize, arr);
			compress(x + newsize, y + newsize, newsize, arr);

		}
	}

	public static int[] solution(int[][] arr) {
		int[] answer = {};

		compress(0, 0, arr[0].length, arr);
		return new int[] {zero, one};
	}

	public static void main(String[] args) throws IOException {
		int[][] arr = {
			{1, 1, 0, 0},
			{1, 0, 0, 0},
			{1, 0, 0, 1},
			{1, 1, 1, 1}
		};
		int[] result = Sol54.solution(arr);

		// 결과 출력
		System.out.println("zero: " + result[0] + ", one: " + result[1]);
	}
}
