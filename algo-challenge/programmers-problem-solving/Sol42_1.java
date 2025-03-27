package study;


//주식가격 - stack
import java.util.*;

class Sol42_1 {
	public int[] solution(int[] prices)
	{
		int n = prices.length;
		int[] ans = new int[n];
		Stack<Integer> stack = new Stack<>();

		for (int i=0; i<n; i++)
		{
			while (!stack.isEmpty() && prices[stack.peek()] > prices[i])
			{
				int idx = stack.pop();
				ans[idx] = i - idx;
			}
			stack.push(i);
		}
		while(!stack.isEmpty())
		{
			int idx = stack.pop();
			ans[idx] = n - 1 - idx;
		}
		return ans;
	}

}
