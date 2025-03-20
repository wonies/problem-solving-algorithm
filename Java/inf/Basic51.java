package inf;

import java.io.*;
import java.util.*;

public class Basic51 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int lt =0, rt=n-1;
		int ans = 0;

		while (lt <= rt)
		{
			int mid = (lt + rt) / 2;
			if (arr[mid] == m)
			{
				ans = mid + 1;
				break ;
			}
			if (arr[mid] > m) rt = mid-1;
			else lt = mid + 1;
		}
		System.out.println(ans);
	}
}
