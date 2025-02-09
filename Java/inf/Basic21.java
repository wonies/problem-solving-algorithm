package inf;

import java.util.*;
import java.io.*;

public class Basic21 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] arr = new int[n];
		int [] ans = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		for (int i = 0 ; i < n; i++)
		{
			int score = arr[i];
			int temp = 0;
			for (int j = 0; j < n; j++)
				if (score < arr[j])
					temp++;
			ans[i] = temp;
		}

		for (int i : ans)
			System.out.print((i + 1)+ " ");
	}
}
