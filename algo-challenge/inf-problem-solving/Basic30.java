package inf;

import java.io.*;
import java.util.*;

public class Basic30 {
	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] arr = new int[n];
		for (int i=0; i<n; i++)
			arr[i] = i+1;
		// int l = 0, r = 0;
		int sum = 0;
		int cnt = 0;
		int l = 0;
		for (int i=0; i<n; i++)
		{
			if (arr[i] >= n)
				break ;
			sum += arr[i];
			// if (sum == n) {
			// 	System.out.print("check : " + i + " " + arr[i]);
			// 	cnt++;
			// }
			while (sum >= n)
			{
				if (sum == n)
					cnt++;
				sum -= arr[l++];
			}
		}
		System.out.println(cnt);
	}
}
