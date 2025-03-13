package inf;

// 모든 아나그램 찾기

import java.io.*;
import java.util.*;

public class Basic35 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String firstLine = br.readLine();
		String secondLine = br.readLine();
		int len = secondLine.length();
		int leng = firstLine.length();
		int cnt = 0;

		HashMap<Character, Integer> ana = new HashMap<>();
		HashMap<Character, Integer> str = new HashMap<>();

		for (Character c : secondLine.toCharArray())
		{
			ana.put(c, ana.getOrDefault(c, 0) + 1);
		}

		for (int i=0; i<len; i++)
		{
			str.put(firstLine.charAt(i), str.getOrDefault(firstLine.charAt(i), 0) + 1);
			if (str.equals(ana))
				cnt++;
		}

		for (int i=1; i<leng-len+1; i++)
		{
			Character left = firstLine.charAt(i - 1);
			// System.out.println("left : " + left);
			str.put(left, str.get(left) - 1);
			if (str.get(left) == 0)
				str.remove(left);
			Character right = firstLine.charAt(i + len - 1);
			str.put(right, str.getOrDefault(right, 0) + 1);
			System.out.println(str);
			if (str.equals(ana))
			{
				// System.out.println("str equals : " + cnt);
				cnt++;
			}
		}


		System.out.println("cnt : " + cnt);
	}

}
