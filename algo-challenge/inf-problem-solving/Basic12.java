package inf;

import java.io.*;
import java.util.*;

public class Basic12 {

	public static int toBaseTen(String num)
	{
		int ans = 0;
		for (int i = 0; i < num.length(); i++)
		{
			if (num.charAt(num.length() -1 - i) == '1')
				ans += (1 << i);
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		StringBuilder res = new StringBuilder();

		for (char c : str.toCharArray())
		{
			if (c == '*')
				sb.append('0');
			else if (c == '#')
				sb.append('1');

			if (sb.length() == 7) {
				int ascii = toBaseTen(sb.toString());
				res.append((char)ascii);
				sb.setLength(0);
			}
		}
		System.out.println(res);
	}
}
