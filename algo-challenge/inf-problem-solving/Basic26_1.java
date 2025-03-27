package inf;

import java.io.*;
import java.util.*;

public class Basic26_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++)
			a[i] = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		int [] b = new int[m];
		st = new StringTokenizer(br.readLine());

		for (int j=0; j<m; j++)
			b[j] = Integer.parseInt(st.nextToken());
		ArrayList<Integer> ans = new ArrayList<>();

		int i = 0, j=0;
		while (i < n && j < m)
		{
			if (a[i] > b[j])
			{
				ans.add(b[j]);
				j++;
			}
			else
			{
				ans.add(a[i]);
				i++;
			}
		}
		while (i < n)
		{
			ans.add(a[i]);
			i++;
		}
		while (j < m)
		{
			ans.add(b[j]);
			j++;
		}
		for (int x: ans)
			System.out.print(x + " ");
	}
}
