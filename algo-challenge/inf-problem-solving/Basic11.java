package inf;

import java.io.*;
import java.util.*;

public class Basic11 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char cur = str.charAt(0);
		int cnt = 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < str.length(); i++)
		{
			if (cur == str.charAt(i))
				cnt++;
			else
			{
				sb.append(str.charAt(i-1));
				if (cnt > 1)
					sb.append(cnt);
				cnt = 1;
				cur = str.charAt(i);
			}
		}
		sb.append(cur);
		if(cnt > 1) sb.append(cnt);
		System.out.println(sb);
	}
}
