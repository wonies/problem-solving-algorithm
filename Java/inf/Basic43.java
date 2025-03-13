package inf;

import java.util.*;
import java.io.*;

public class Basic43 {
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		String input  = br.readLine();
		int cnt = 0;

		for (int i=0; i<input.length();i++)
		{
			char c = input.charAt(i);
			if (c=='(')
				stack.push(c);
			else if (!stack.isEmpty() && c == ')' && stack.peek() == '(')
			{
				stack.pop();
				if (input.charAt(i-1) == '(')
					cnt += stack.size();
				else
					cnt += 1;
			}
		}
		System.out.println(cnt);
	}
}
