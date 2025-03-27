package inf;

import java.io.*;
import java.util.*;

public class Basic15 {

	public static char getWinner(int a, int b)
	{
		if (a == b) return 'D';
		if ((a == 1 && b == 3) ||
			(a == 2 && b == 1) ||
			(a == 3 && b == 2)) {
			return 'A';
		}
		return 'B';
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] A = new int [n];
		int [] B = new int [n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
		{
			A[i] = Integer.parseInt(st.nextToken());
		}
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
		{
			B[i] = Integer.parseInt(st2.nextToken());
		}

		for (int i = 0; i < n; i++)
		{
			if (i == n - 1)
				System.out.print(getWinner(A[i], B[i]));
			else
				System.out.println(getWinner(A[i], B[i]));
		}

	}
}
