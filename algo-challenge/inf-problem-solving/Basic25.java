package inf;

import java.io.*;
import java.util.*;

public class Basic25 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] arr = new int[m][n];
		int[][] pos = new int[m][n+1];

		for (int i=0; i<m; i++)
		{
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++)
			{
				int stu = arr[i][j] = Integer.parseInt(st.nextToken());
				pos[i][stu] = j;
			}
		}
		int ans = 0;
		for (int i=1; i<=n; i++)
		{
			for (int j=1; j<=n; j++)
			{
				if (i==j) continue;
				boolean valid = true;
				for (int k=0; k<m; k++)
				{
					if (pos[k][i] > pos[k][j])
					{
						valid = false;
						break ;
					}
				}
				if (valid == true)
					ans++;
			}
		}
		System.out.println(ans);
	}
}

