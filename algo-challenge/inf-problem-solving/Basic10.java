package inf;

import java.io.*;
import java.util.*;

public class Basic10 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] parts = line.split(" ");
		String word = parts[0];
		char target = parts[1].charAt(0);
		int[] ans = new int [word.length()];
		ArrayList<Integer> arr = new ArrayList<>();


		for (int i = 0; i < word.length(); i++)
		{
			if (word.charAt(i) == target)
				arr.add(i);
		}
		for (int i = 0; i < word.length(); i++)
		{
			int min = Integer.MAX_VALUE;
			for (int idx : arr)
			{
				min = Math.min(min, Math.abs(i - idx));
			}
			ans[i] = min;
		}
		for (int i = 0; i < word.length(); i++)
		{
			if (i == word.length() - 1)
				System.out.print(ans[i]);
			else
				System.out.print(ans[i] + " ");
		}

	}
}

