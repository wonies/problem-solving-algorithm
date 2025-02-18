package study;

import java.io.*;
import java.util.*;

class Sol7 {
	public int solution(int n) {
		int answer = 0;
		int target = Integer.bitCount(n);
		int next = n;
		while (true)
		{
			++next;
			if (Integer.bitCount(next) == target)
				return next;
		}
	}
}
