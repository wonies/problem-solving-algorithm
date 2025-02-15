package inf;

import java.io.*;
import java.util.*;

public class Basic32 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();
		char ans = ' ';

		HashMap<Character, Integer> map = new HashMap<>();
		for (char c :  input.toCharArray()){
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int max = Integer.MIN_VALUE;
		for (char c : map.keySet()){
			if (map.get(c) > max){
				max = map.get(c);
				ans =  c;
			}
		}
		System.out.println(ans);
	}
}
