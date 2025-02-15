package inf;

import java.io.*;
import java.util.*;


// RunTimeError
public class Basic33_Wrong {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();



		HashMap<Character, Integer> map_a = new HashMap<>();
		HashMap<Character, Integer> map_b = new HashMap<>();


		for (char c : a.toCharArray()) {
			map_a.put(c, map_a.getOrDefault(c, 0) + 1);
		}
		for (char c : b.toCharArray()) {
			map_b.put(c, map_b.getOrDefault(c, 0) + 1);
		}

		if (map_a.size() != map_b.size()) {
			System.out.println("NO");
			return;
		}
		// boolean isEqual = map_a.equals(map_b);
		// // System.out.println(isEqual);
		// if (isEqual == true)
		// 	System.out.println("YES");
		// else
		// 	System.out.println("NO"); // RUNTIME ERROR!

		boolean isEqual = true;
		for (Map.Entry<Character, Integer> entry : map_a.entrySet())
		{
			char key = entry.getKey();
			int val = entry.getValue();

			if (!map_b.containsKey(key) || map_b.get(key) != val){
				isEqual = false;
				break;
			}
		}

		if (isEqual == true)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
