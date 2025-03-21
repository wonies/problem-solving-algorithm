package study;


import java.io.*;
import java.util.*;
// 큰 수 만들기

class Sol60 {
	public String solution(String number, int k) {
		StringBuilder sb = new StringBuilder();
		int len = number.length();
		int rlen = len - k;
		int startIdx = 0;

		while (rlen > 0)
		{
			char c = number.charAt(0);
			char maxDigit = '0';
			int maxIdx = startIdx;
			int endIdx = len - rlen;

			for (int i = startIdx; i <= endIdx; i++)
			{
				if (number.charAt(i) > maxDigit)
				{
					maxDigit = number.charAt(i);
					maxIdx = i;
				}
			}
			sb.append(maxDigit);
			startIdx = maxIdx + 1;

			rlen--;
		}
		return sb.toString();
	}
}
