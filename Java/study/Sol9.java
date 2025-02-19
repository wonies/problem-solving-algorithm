package study;

import java.io.*;
import java.util.*;

class Sol9 {
	public int solution(String s) {
		if (s.length() % 2 != 0) return 0;
		char[] stack = new char[s.length()];
		int idx = 0;

		for(char c : s.toCharArray())
		{
			if (idx > 0 && stack[idx - 1] == c)
				idx--;
			else
				stack[idx++] = c;
		}
		return idx == 0 ? 1 : 0;
	}
}
