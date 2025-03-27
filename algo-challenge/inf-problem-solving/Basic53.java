package inf;

import java.io.*;
import java.util.*;

public class Basic53 {

	public static int count(int[] arr, int mid){
		int cnt = 1, sum = 0;

		return cnt;
	}


	public static int solution(int n, int m, int []arr)
	{
		int cnt = 0;



		return cnt;
	}

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
		System.out.print(solution(n, m, arr));
	}
}
