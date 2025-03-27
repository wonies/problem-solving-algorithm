package basic;

import java.util.*;

public class basic_one {

	public static int basic_one(int n, int m)
	{
		int sum = 0;
		for (int i = 1; i <= n; i++)
		{
			if (i % m == 0)
				sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {
		int res = basic_one(15, 3);
		System.out.println(res);
	}
}
