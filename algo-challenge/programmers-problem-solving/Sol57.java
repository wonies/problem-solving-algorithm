package study;

// 소수찾기
import java.io.*;
import java.util.*;

class Sol57 {
	static Set<Integer> Set;
	static int []numbs;
	static boolean []visited;
	static Set<Integer> set;

	private static boolean isPrime(int num)
	{
		if (num < 2)
			return false;
		for (int i = 2; i * i <= num; i++)
		{
			if (num % i == 0)
				return false;
		}
		return true;
	}

	private static void dfs(int[] nums, int len, int res, int depth)
	{
		if (isPrime(res))
			set.add(res);
		if (depth >= len)
			return ;

		for (int i = 0; i < len; i++)
		{
			if (visited[i] == true) continue ;

			int newRes = res * 10 + nums[i];
			visited[i] = true;
			dfs(nums, len, newRes, depth + 1);
			visited[i] = false;
		}
	}

	public static int solution(String numbers) {
		int answer = 0;
		int len = numbers.length();
		numbs = new int[len + 1];
		visited = new boolean[len + 1];
		set = new HashSet<>();

		for (int i = 0; i < len; i++)
		{
			numbs[i] = Integer.parseInt(String.valueOf(numbers.charAt(i)));
		}

		dfs(numbs, len, 0, 0);
		return set.size();
	}

	public static void main(String[] args) {
		String str = "011";
		int res = Sol57.solution(str);
		System.out.println("res : " + res);
	}
}
