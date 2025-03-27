package study;

// K진수에서 소수개수구하기 - 1번만 시간초과가 났었는데 int->long으로 변경하고 통과

import java.io.*;
import java.util.*;

class Sol37 {

	private String toBase(int n, int k)
	{
		String res = "";

		while (n > 0)
		{
			res = String.valueOf(n % k) + res;
			n /= k;
		}
		return res;
	}

	private boolean isPrime(long prime)
	{
		if (prime < 2)
			return false;
		for (long i=2; i*i<= prime; i++)
		{
			if (prime % i == 0)
				return false;
		}
		return true;
	}



	private int findPrime(String numbers)
	{
		int cnt = 0;
		long dummy = 0;

		for (int i=0; i < numbers.length(); i++)
		{
			if (numbers.charAt(i) == '0')
			{
				if(dummy > 1 && isPrime(dummy))
				{
					cnt++;
				}
				dummy = 0;
			}
			else
				dummy = dummy * 10 + Character.getNumericValue(numbers.charAt(i));
		}
		if (dummy > 1 && isPrime(dummy)) {
			cnt++;
		}
		return cnt;
	}


	public int solution(int n, int k) {
		String res = toBase(n, k);
		int ans = findPrime(res);

		return ans;
	}
}
