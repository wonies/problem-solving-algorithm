package inf;

import java.io.*;
import java.util.*;

public class Basic19 {

	public static boolean isPrime(int num)
	{
		if (num <= 1) return false;
		for (int i = 2; i < num; i++)
			if (num % i == 0)
				return false;
		return true;
	}

	public static ArrayList<Integer> reverse(int [] arr, int len)
	{
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i=0; i<len; i++)
		{
			int temp = arr[i];
			int res = 0;
			while (temp > 0)
			{
				int t = temp % 10;
				res = res * 10 + t;
				temp = temp / 10;
			}
			if (isPrime(res)) ans.add(res);
		}
		return ans;
	}

	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer sb = new StringTokenizer(br.readLine());
		int [] arr = new int[n + 1];
		for (int i = 0; i < n; i++)
		{
			arr[i] = Integer.parseInt(sb.nextToken());
		}
		int length = arr.length - 1;
		// ArrayList<Integer> res = reverse(arr, length);
		// for (int i = 0; i < res.size(); i++) {
		// 	if (i == res.size() - 1)
		// 		System.out.print(res);
		// 	else
		// 		System.out.print(res + " ");
		// }
		for (int x : reverse(arr, length))
			System.out.print(x + " ");
	}
}
