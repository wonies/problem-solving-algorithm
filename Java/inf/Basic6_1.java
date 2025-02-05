package inf;

import java.io.*;
import java.util.*;

public class Basic6_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		Set<Character> set = new LinkedHashSet<>();
		for (char c : line.toCharArray())
		{
			set.add(c);
		}
		StringBuilder sb = new StringBuilder();
		for (char c : set)
			sb.append(c);
		System.out.println(sb.toString());
	}
}
