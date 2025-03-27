package inf;

import java.io.*;
import java.util.*;

public class Basic2 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		StringBuilder res = new StringBuilder();

		for (int i = 0; i < len; i++)
		{
			char c = str.charAt(i);
			if (Character.isUpperCase(c))
				res.append(Character.toLowerCase(c));
			else
				res.append(Character.toUpperCase(c));
		}
		System.out.println(res);
	}
}
