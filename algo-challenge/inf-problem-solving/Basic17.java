package inf;

import java.io.*;
import java.util.*;

public class Basic17 {

	public static int [] fibo(int num)
	{
		int [] dp = new int[num];
		dp[0] = 1;
		dp[1] = 1;

		for(int i = 2; i < num; i++)
			dp[i] = dp[i-1] + dp[i-2];
		return dp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] dp = new int[n];
		dp = fibo(n);
		for (int i = 0; i < n; i++){
			if (i == n - 1)
				System.out.print(dp[i]);
			else
				System.out.print(dp[i] + " ");

		}
	}

}
