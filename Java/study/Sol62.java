package study;

// 마법의 엘레베이터

import java.util.*;
import java.io.*;

class Sol62 {
	public int solution(int storey) {
		int answer = 0;
		int digit = find_digit(storey);
		int[] numbers = new int[digit + 1];
		int temp = storey;

		while (storey > 0)
		{
			int curr = storey % 10;
			int next = (storey / 10) % 10;

			if (curr > 5)
			{
				answer += (10 - curr);
				storey += (10 - curr);
			}
			else if(curr == 5 && next >= 5)
			{
				answer += (10 - curr);
				storey += (10 - curr);
			}
			else
			{
				answer += curr;
			}
			storey /= 10;
		}

		return answer;
	}


	private int find_digit(int num)
	{
		int digit = 0;
		while (num > 0)
		{
			++digit;
			num /= 10;
		}
		return digit;
	}
}
