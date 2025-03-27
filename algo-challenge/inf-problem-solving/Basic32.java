//학급회장

package inf;

import java.io.*;
import java.util.*;

public class Basic32 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();
		char ans = ' ';
		HashMap<Character, Integer> hash = new HashMap<>();
		for (char c : input.toCharArray())
		{
			hash.put(c, hash.getOrDefault(c, 0) + 1);
		}
		int max = Integer.MIN_VALUE;
		for (char c : hash.keySet()){
			int val = hash.get(c);
			if (max < val) {
				max = val;
				ans = c;
			}
		}
		System.out.println(ans);
	}
}
