package inf;

import java.util.*;
import java.io.*;

public class Basic4 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++)
		{
			String word = br.readLine();
			int wordLen = word.length();
			for (int j = wordLen - 1; j >= 0; j--)
			{
				System.out.print(word.charAt(j));
			}
			System.out.print("\n");
		}
	}
}
