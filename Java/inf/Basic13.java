package inf;

import java.io.*;
import java.util.*;

public class Basic13 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] numbers = new int [n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		System.out.print(numbers[0]);

		for (int i = 1; i < n; i++)
		{
			if (numbers[i] > numbers[i - 1])
				System.out.print(" " + numbers[i]);
		}
	}
}
