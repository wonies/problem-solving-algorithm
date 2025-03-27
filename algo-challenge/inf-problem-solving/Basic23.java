package inf;

import java.io.*;
import java.util.*;

public class Basic23 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [][] arr = new int [n + 2][n + 2];

		for (int i = 1; i < n + 1; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n + 1; j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int top = 0;
		for (int i =1; i<n+1; i++)
		{
			for (int j=1; j<n+1; j++)
			{
				if (arr[i][j] > arr[i-1][j] && arr[i][j] > arr[i][j-1] && arr[i][j] > arr[i][j+1] && arr[i][j] > arr[i+1][j])
					top++;
			}
		}
		System.out.print(top);
	}
}
