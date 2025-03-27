package inf;

import java.io.*;
import java.util.*;

public class Basic27_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] A = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++)
			A[i] = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		int [] B = new int[m];
		st = new StringTokenizer(br.readLine());

		for (int i=0; i<m; i++)
			B[i] = Integer.parseInt(st.nextToken());
		int left =0, right =0;

		ArrayList<Integer> ans = new ArrayList<>();
		Arrays.sort(A);
		Arrays.sort(B);
		while(left < n && right <m)
		{
			if (A[left] == B[right])
			{
				ans.add(A[left]);
				left++;
				right++;
			}
			else if (A[left] > B[right])
				right++;
			else
				left++;
		}

		for (int x: ans)
			System.out.print(x + " ");
	}
}
