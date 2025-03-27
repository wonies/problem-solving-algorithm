package study;
//땅따먹기
import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

class Sol44 {

	int solution(int[][] land) {
		int n = land.length;

		int[][] dp = new int[n][4];
		for (int j=0; j<4; j++)
			dp[0][j] = land[0][j];

		for (int i=1; i<n; i++)
		{
			for (int j=0; j<4; j++)
			{
				int max = 0;
				for (int k=0; k<4; k++)
				{
					if (k == j) continue ;
					max = Math.max(max, dp[i-1][k]);
				}
				dp[i][j] = land[i][j] + max;
			}
		}

		int ans = 0;
		for (int j=0; j<4; j++)
		{
			ans = Math.max(ans, dp[n-1][j]);
		}

		return ans;
	}
}
