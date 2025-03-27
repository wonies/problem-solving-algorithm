package study;

// 가장 큰 수
import java.io.*;
import java.util.*;

class Sol53 {
	public String solution(int[] numbers) {

		String[] nums = new String[numbers.length];
		for (int i=0; i<nums.length; i++)
			nums[i] = String.valueOf(numbers[i]);

		Arrays.sort(nums, (a,b) -> (b + a).compareTo(a + b));
		if (nums[0].equals("0"))
			return "0";

		StringBuilder str = new StringBuilder();
		for (String num: nums)
		{
			str.append(num);
		}

		return str.toString();
	}
}
