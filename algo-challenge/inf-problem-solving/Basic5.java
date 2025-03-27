package inf;

import java.io.*;
import java.util.*;

public class Basic5 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char [] line = str.toCharArray();
		int len = line.length;
		int left = 0;
		int right = len - 1;
		while (left < right)
		{
			if (!Character.isAlphabetic(line[left]))
				left++;
			else if (!Character.isAlphabetic(line[right]))
				right--;
			else
			{
				char temp = line[left];
				line[left] = line[right];
				line[right] = temp;
				left++;
				right--;
			}
		}
		String ans = new String(line);
		System.out.println(ans);
	}
}
