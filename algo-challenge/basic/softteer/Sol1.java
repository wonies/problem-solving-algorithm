package softteer;

//level3. 성적평균

import java.io.*;
import java.util.*;

public class Sol1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int [] arr = new int [n];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		for (int j=0; j<m; j++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			double ans = 0;
			for (int i = a - 1; i<= (b - 1); i++)
			{
				ans += arr[i];
			}
			double avg = ans / (b-a+1);
			System.out.printf("%.2f\n", avg);
		}
	}
}
