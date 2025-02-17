package study;

import java.io.*;
import java.util.*;

class Sol5 {
	public int[] solution(String s) {
		int[] answer = {};
		int cnt = 0;
		int remove = 0;
		answer = new int[2];
		while(!s.equals("1"))
		{
			StringBuilder temp = new StringBuilder();
			// for (int i=0; i<s.length(); i++)
			// {
			//     if (s.charAt(i) == '1')
			//         temp += s.charAt(i);
			//     else
			//         remove++;
			// }
			// s = Integer.toBinaryString(temp.length());
			// cnt++;
			for (char c: s.toCharArray())
			{
				if (c=='1')
					temp.append(c);
				else
					remove++;
			}
			s = Integer.toBinaryString(temp.length());
			cnt++;
		}

		answer[0] = cnt;
		answer[1] = remove;

		return answer;
	}
}
