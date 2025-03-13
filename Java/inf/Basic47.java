package inf;

//LRU-캐시변형
import java.io.*;
import java.util.*;

public class Basic47 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[m];
		int[] ans = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i=0; i<m; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		for (int x : arr)
		{
			int pos = -1;
			for (int i=0; i<n; i++) {
				if (ans[i] == x)
					pos = i;
			}
				if (pos == -1)
				{
					for (int j=n-1; j>=1; j--)
					{
						ans[j] = ans[j-1];
					}
				}
				else
				{
					for (int k=pos; k>=1; k--)
					{
						ans[k] = ans[k-1];
					}
				}
				ans[0] = x;

		}

		for (int x : ans)
			System.out.print(x + " ");
	}
}
