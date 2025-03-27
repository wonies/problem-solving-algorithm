package inf;

import java.io.*;
import java.util.*;

public class Basic14 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] numbers = new int[n];
		int taller = Integer.MIN_VALUE;
		int cnt = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++)
		{
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++)
		{
			if (numbers[i] > taller)
			{
				taller = numbers[i];
				cnt++;
			}

		}
		System.out.println(cnt);
	}
}
