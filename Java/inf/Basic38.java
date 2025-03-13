package inf;

//올바른 괄호
import java.io.*;
import java.util.*;

public class Basic38 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Stack<Character> stack = new Stack<>();
		boolean valid = true;

		for (int i=0; i<input.length(); i++)
		{
			char c = input.charAt(i);
			if (c=='(')
				stack.push(c);
			else {
				if (stack.isEmpty()) {
					valid = false;
					break;
				}
				stack.pop();
			}
		}
		if (stack.isEmpty() && valid)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
