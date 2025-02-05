package inf;

import java.io.*;
import java.util.*;

public class Basic6 {
	public static void main(String[] args)  throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String ans = "";
		// char [] line = input.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < line.length(); i++)
		{
			char c = line.charAt(i);
			if (line.indexOf(c) == i)
				sb.append(c);
		}
		System.out.println(sb);
	}
}
