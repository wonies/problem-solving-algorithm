//아나그램

package inf;

import java.io.*;
import java.util.*;

public class Basic33 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		HashMap<Character, Integer> map = new HashMap<>();
		for (char c : a.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		for (char c : b.toCharArray()){
			if (!map.containsKey(c)){
				System.out.println("NO");
				return ;
			}
			map.put(c, map.get(c) - 1);
			if (map.get(c) == 0)
				map.remove(c);
		}
		System.out.println(map.isEmpty() ? "YES" : "NO");
	}
}
