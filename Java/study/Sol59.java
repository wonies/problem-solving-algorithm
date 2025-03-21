package study;

//삼각달팽이
import java.io.*;
import java.util.*;

class Sol59 {
	public int[] solution(int n) {
		int size = (n * (n + 1)) / 2;
		int[][] tri = new int [n][n];
		int[] res = new int [size];
		int direction = 0;
		int num = 1;
		int row = 0, col = 0;

		for (int i = 0; i < n; i++)
			Arrays.fill(tri[i], -1);

		for (int i = 0; i < size; i++)
		{
			tri[row][col] = num++;
			if (direction == 0)
			{
				if (row + 1 < n && tri[row + 1][col] == -1)
					row++;
				else
				{
					direction = 1;
					col++;
				}
			}
			else if (direction == 1)
			{
				if (col + 1 < n && tri[row][col + 1] == -1)
					col++;
				else
				{
					direction = 2;
					col--;
					row--;
				}
			}
			else
			{
				if (col - 1 >= 0 && row - 1 >= 0 && tri[row - 1][col - 1] == -1)
				{
					row--;
					col--;
				}
				else
				{
					direction = 0;
					row++;
				}
			}
		}

		int k = 0;
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (tri[i][j] != -1)
					res[k++] = tri[i][j];
			}
		}


		return res;
	}
}
