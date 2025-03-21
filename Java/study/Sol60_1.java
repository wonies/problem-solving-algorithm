package study;

//큰 수 만들기
import java.io.*;
import java.util.*;

class Sol60_1 {
	public String solution(String number, int k) {
		StringBuilder str = new StringBuilder();

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < number.length(); i++)
		{
			char c = number.charAt(i);
			while (!stack.isEmpty() && stack.peek() < c && k-- > 0)
			{
				stack.pop();
			}
			stack.push(c);
		}
		while (k-- > 0)
			stack.pop();

		for (char x : stack)
			str.append(x);


		return str.toString();
	}
}
