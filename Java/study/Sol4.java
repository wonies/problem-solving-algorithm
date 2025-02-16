package study;

import java.io.*;
import java.util.*;

//one
class Sol4 {
	boolean solution(String s) {
		boolean answer = true;
		int cnt = 0;

		for (int i = 0; i < s.length(); i++)
		{
			if (cnt < 0)
				return false;

			if (s.charAt(i) == '(')
				cnt++;
			else
				cnt--;
		}
		if (cnt != 0)
			answer = false;


		return answer;
	}
}

//two (using stack)
//
// import java.io.*;
// import java.util.*;
//
// class Solution {
// 	boolean solution(String s) {
// 		boolean answer = true;
// 		Stack<Character> stack = new Stack<>();
//
// 		for (char c : s.toCharArray())
// 		{
// 			if (c == '(')
// 				stack.push(c);
// 			else
// 			{
// 				if (stack.isEmpty()) return false;
// 				stack.pop();
// 			}
// 		}
// 		answer = stack.isEmpty();
//
// 		return answer;
// 	}
// }
