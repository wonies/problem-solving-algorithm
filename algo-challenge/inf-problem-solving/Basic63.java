package inf;

//투포인터 알고리즘: 최대매출

import java.io.*;
import java.util.*;


public class Basic63 {

	public static int solution(int[] arr, int n, int k)
	{
		int sum = 0;
		int answer = 0;

		for(int i=0; i<k; i++)
			sum += arr[i];
		answer = sum;
		for (int i=k; i<n-k; i++){
			sum += (arr[i] - arr[i-k]);
			answer = Math.max(answer, sum);
		}
		return answer;
	}



	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int [] arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int ans = solution(arr, n, k);
		System.out.println(ans);
	}
}

