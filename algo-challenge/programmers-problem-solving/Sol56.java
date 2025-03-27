package study;

// 두 큐 합 같게 만들기!

import java.io.*;
import java.util.*;

class Sol56 {
	public int solution(int[] queue1, int[] queue2) {
		int answer = -1;
		long sum = 0;
		long oneSum = 0;
		long twoSum = 0;

		for (int i=0; i < queue1.length; i++)
		{
			sum += (queue1[i] + queue2[i]);
			oneSum += queue1[i];
			twoSum += queue2[i];
		}

		if (sum % 2 != 0)
			return answer;

		Queue<Integer> one = new LinkedList<>();
		Queue<Integer> two = new LinkedList<>();

		for (int i=0; i < queue1.length; i++)
		{
			one.offer(queue1[i]);
			two.offer(queue2[i]);
		}

		int opt = 0;
		boolean isValid = false;
		int tot = queue1.length * 4;
		int cnt = 0;


		while (oneSum != twoSum && cnt < tot)
		{
			//             System.out.println("temp one : " + oneSum + " temp two: " + twoSum);

			if (twoSum > oneSum && !two.isEmpty())
			{
				int pollTwo = two.poll();
				one.offer(pollTwo);
				oneSum += pollTwo;
				twoSum -= pollTwo;
				opt++;
			}
			else if (oneSum > twoSum && !one.isEmpty())
			{
				int pollOne = one.poll();
				two.offer(pollOne);
				twoSum += pollOne;
				oneSum -= pollOne;
				opt++;
			}
			cnt++;
		}

		if (oneSum == twoSum)
			answer = opt;

		return answer;
	}
}

