package study;
//행렬의 곱셈
import java.io.*;
import java.util.*;

class Sol22 {
	public int[][] solution(int[][] arr1, int[][] arr2) {

		int row = arr1.length;
		int col = arr2[0].length;
		int [][] ans = new int[row][col];
		int k_len = arr1[0].length;

		for (int i=0; i<row; i++)
		{
			for (int j=0; j<col; j++)
			{
				for (int k=0; k<k_len; k++)
					ans[i][j] += arr1[i][k] * arr2[k][j];
			}
		}

		return ans;
	}
}
