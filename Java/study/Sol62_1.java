package study;


//마법의 엘레베이터
import java.util.*;
import java.io.*;

class Sol62_1 {
	public int solution(int storey) {
		int num = String.valueOf(storey).length();
		int [] arr = new int [num];
		int cnt = 0;

		while (storey > 0)
		{
			int temp = storey % 10;
			int next = (storey / 10) % 10;

			if ((next >= 5 && temp >= 5) || (temp > 5))
			{
				cnt += (10 - temp);
				storey += (10 - temp);
			}
			else
				cnt += temp;

			storey /= 10;
		}


		return cnt;
	}
}
