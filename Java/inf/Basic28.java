package inf;


import java.io.*;
import java.util.*;

public class Basic28 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int [] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int sum = -1;
		for (int i=0; i<= arr.length - m; i++)
		{
			int temp = 0;
			for (int j=i; j<i+m; j++)
			{
				temp += arr[j];
			}
			if (temp > sum)
				sum = temp;
		}
		System.out.println(sum);
	}
}
