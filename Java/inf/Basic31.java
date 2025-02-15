package inf;

import java.io.*;
import java.util.*;

public class Basic31 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int [] arr = new int[n];

		int lt = 0, rt =0;
		int sum = 0;
		int ans = 0;
		int convert = m;
		while (rt < n)
		{
			if (arr[rt++] == 1)
				sum++;
			else if (arr[rt] == 0 && convert > 0)
			{
				sum++;
				convert--;
			}
			else {
				if (sum > ans)
					ans = sum;
				while (arr[lt] > sum)
				{
					sum -= arr[lt];
					lt++;
				}
				convert = m;
			}
		}
		System.out.println(ans);

	}
}
