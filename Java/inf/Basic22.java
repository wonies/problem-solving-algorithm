package inf;

import java.util.*;
import java.io.*;

public class Basic22 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [][] arr = new int[n][n];

		for (int i = 0; i < n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int sum = 0;
		int tmp = 0;
		for (int i = 0; i < n; i++)
		{
			int temp = 0;
			for (int j = 0; j < n; j++)
			{
				temp += arr[i][j];
				if (i == j)
					tmp += arr[i][j];
			}
			sum = Math.max(sum, temp);
			sum = Math.max(sum, tmp);
		}
		for (int i = 0; i < n; i++)
		{
			int temp = 0;
			for (int j = 0; j < n; j++)
			{
				temp += arr[j][i];
			}
			sum = Math.max(sum, temp);
		}

		System.out.println(sum);
	}
}
