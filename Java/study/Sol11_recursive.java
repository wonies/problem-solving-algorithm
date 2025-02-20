package study;

import java.util.*;
import java.io.*;

public class Sol11_recursive {
	static boolean isLimit;
	static int cnt;

	public static int boat(int[] people, int limit, int left, int right)
	{
		if (left > right)
			return 0;
		if (left == right)
			return 1;
		if (people[left] + people[right] <= limit)
			return 1 + boat(people, limit, left+1, right-1);
		return 1 + boat(people, limit, left, right-1);
	}


	public int solution(int[] people, int limit) {
		Arrays.sort(people);
		cnt = boat(people, limit, 0, people.length-1);
		return cnt;
	}
}
