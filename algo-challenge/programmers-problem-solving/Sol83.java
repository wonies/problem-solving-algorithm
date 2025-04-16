//가장 큰 정사각형찾기

import java.io.*;
import java.util.*;

class Sol83
{
	public int solution(int [][]board)
	{
		int row = board.length;
		int col = board[0].length;
		int[][] matrix = new int[row][col];

		int cnt = 0;
		for (int i=0; i<row; i++)
		{
			for (int j=0; j<col; j++)
			{
				if (i==0)
				{
					matrix[i][j] = board[i][j];
					cnt = Math.max(cnt, matrix[i][0]);
				}

				if (j==0) {
					matrix[i][j] = board[i][j];
					cnt = Math.max(cnt, matrix[0][j]);
				}
			}
		}
		// for (int i=0; i<row; i++)
		// {
		//     for (int j=0; j<col; j++)
		//     {
		//         System.out.print(matrix[i][j]);
		//     }
		//     System.out.println("");
		// }

		for (int i=1; i<row; i++)
		{
			for (int j=1; j<col; j++)
			{
				if (board[i][j] > 0)
				{
					int left = matrix[i-1][j];
					int up = matrix[i][j-1];
					int diagonal = matrix[i-1][j-1];

					int cur = Math.min(Math.min(left, up), diagonal) + 1;
					cnt = Math.max(cnt, cur);
					matrix[i][j] = cur;
				}
				else if (board[i][j] == 0)
					matrix[i][j] = 0;
			}
		}

		return cnt * cnt;
	}
}
