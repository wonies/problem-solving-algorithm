package study;

import java.io.*;
import java.util.*;

public class Sol11 {
	public int solution(int[] people, int limit) {
		Arrays.sort(people);
		int left = 0, right = people.length - 1;
		int cnt = 0;

		while (left <= right) {
			cnt++;
			if (left != right && people[left] + people[right] <= limit) {
				left++;
			}
			right--;
		}
		return cnt;
	}
}
