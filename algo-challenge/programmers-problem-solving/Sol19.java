package study;

// 괄호회전하기

import java.io.*;
import java.util.*;

class Sol19 {
	private boolean isValid(Deque<Character> deque)
	{
		Stack<Character> stack = new Stack<>();
		for (char c : deque)
		{
			if (c=='(' || c=='{' || c=='[')
				stack.push(c);
			else
			{
				if (stack.isEmpty()) return false;
				char top = stack.pop();
				if ((c ==')' && top != '(') ||
					(c == '}' && top != '{') ||
					(c == ']' && top != '['))
				{
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	public int solution(String s) {
		int cnt = 0;
		Stack<Character> stack = new Stack<>();
		Deque<Character> deque = new LinkedList<>();

		for (char c : s.toCharArray())
			deque.addLast(c);
		for (int i=0; i< s.length(); i++)
		{
			if (isValid(deque)) cnt++;
			char first = deque.removeFirst();
			deque.addLast(first);
		}
		return cnt;
	}

}
