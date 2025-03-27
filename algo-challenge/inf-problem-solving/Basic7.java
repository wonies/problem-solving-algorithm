package inf;

import java.io.*;

public class Basic7 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine().toLowerCase();
		System.out.println(line);
		int len = line.length();
		int left = 0;
		int right = len - 1;
		while (left <= right)
		{
			if (line.charAt(left) != line.charAt(right))
			{
				System.out.println("NO");
				return ;
			}
			left++;
			right--;
		}
		System.out.println("YES");

	}
}
