package inf;

//후위식연산
import java.io.*;
import java.util.*;

public class Basic42 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Stack<Integer> stack = new Stack<>();

		for (int i=0; i<input.length(); i++)
		{
			Character c = input.charAt(i);
			if (c >= '0' && c <= '9')
				stack.push(c - '0');
			else
			{
				if (!stack.isEmpty()){
					int a = stack.pop();
					int b = stack.pop();
					int res = 0;
					if (c == '+')
						res = (a + b);
					else if (c == '-')
						res = (b - a);
					else if (c == '*')
						res = (a * b);
					else
					{
						if (a > 0)
							res = (b / a);
					}
					stack.push(res);
				}
			}
		}

		System.out.println(stack.pop());
	}
}
