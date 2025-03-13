package study;

//프렌즈 4블록

import java.io.*;
import java.util.*;

class Sol50 {
	public static int solution(int m, int n, String[] board) {
		int cnt = 0;
		boolean check = false;
		char [][] blocks = new char[m][n];

		for (int i=0; i<m; i++)
			blocks[i] = board[i].toCharArray();

		for (int x=0; x<m*n; x++)
		{
			boolean [][] toRemove = new boolean[m][n];
			for (int i=0; i<m-1; i++)
			{
				for (int j=0; j<n-1; j++)
				{
					char cur = blocks[i][j];

					if (cur != 'X' && cur == blocks[i+1][j] && cur == blocks[i][j+1]
						&& cur == blocks[i+1][j+1])
					{
						toRemove[i][j] = toRemove[i+1][j] = toRemove[i][j+1] = toRemove[i+1][j+1] = true;
						check = true;
					}
				}
			}
			if (!check)
				break ;

			for (int i=0; i<m; i++)
			{
				for (int j=0; j<n; j++)
				{
					if (toRemove[i][j])
					{
						blocks[i][j] = 'X';
						cnt++;
					}
				}
			}

			for (int j=0;  j<n; j++)
			{
				for (int i=m-1; i > 0; i--)
				{
					if (blocks[i][j] == 'X')
					{
						for (int k=i-1; k>=0; k--)
						{
							if (blocks[k][j] != 'X')
							{
								blocks[i][j] = blocks[k][j];
								blocks[k][j] = 'X';
								break ;
							}
						}
					}
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		int m = 4;
		int n = 5;
		String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		System.out.println(solution(m, n, board));
	}
}
