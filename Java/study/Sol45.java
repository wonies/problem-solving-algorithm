package study;

//택배상자
import java.io.*;
import java.util.*;

class Sol45 {
	public int solution(int[] order) {
		int ans = 0;
		Queue<Integer> queue = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		int max = order.length;
		int idx = 0;

		for (int i=0; i<max; i++)
			queue.offer(i + 1);

		while (idx < max)
		{
			int target = order[idx];

			if (!queue.isEmpty() && queue.peek() == target)
			{
				queue.poll();
				ans++;
				idx++;
			}
			else if (!stack.isEmpty() && stack.peek() == target)
			{
				stack.pop();
				ans++;
				idx++;
			}
			else if (!queue.isEmpty())
				stack.push(queue.poll());
			else
				break ;
		}
		return ans;
	}
}
