package inf;

//괄호문자제거

import java.io.*;
import java.util.*;

public class Basic39 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Stack<Character> stack = new Stack<>();
		ArrayList<Character> arr = new ArrayList<>();

		for (int i=0; i<input.length(); i++)
		{
			char c = input.charAt(i);
			if (c=='(')
				stack.push(c);
			else if (c==')')
			{
				stack.pop();
				continue ;
			}
			if(stack.isEmpty())
				arr.add(c);
		}
		for (char c : arr)
			System.out.print(c);

	}
}
