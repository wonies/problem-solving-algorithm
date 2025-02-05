package inf;

import java.io.*;

public class Basic9 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringBuilder sb = new StringBuilder();
		for (char c : line.toCharArray())
		{
			if (Character.isDigit(c))
				sb.append(c);
		}
		int ans = Integer.parseInt(sb.toString());
		System.out.println(ans);
	}
}
