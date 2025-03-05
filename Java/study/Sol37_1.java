package study;

// K진수에서 소수개수구하기 - split 함수써서 구현

import java.io.*;
import java.util.*;

public class Sol37_1 {

	private static String toBase(int n, int k) {
		StringBuilder res = new StringBuilder();

		while (n > 0)
		{
			res.append(n % k);
			n /= k;
		}
		return res.reverse().toString();
	}

	private static boolean isPrime(long num)
	{
		if (num < 2) return false;
		for (long i=2; i*i <= num; i++)
		{
			if (num % i == 0)
				return false;
		}
		return true;
	}


	private static int findPrime(String numbers)
	{
		int cnt = 0;
		String[] splitNums = numbers.split("0");

		for(String num: splitNums)
		{
			if (!num.isEmpty()){
				long number = Long.parseLong(num);
				if (isPrime(number))
					cnt++;
			}
		}
		return cnt;
	}

	public static int solution(int n, int k)
	{
		String res = toBase(n, k);
		return findPrime(res);
	}

	public static void main(String[] args) throws IOException {
		System.out.println(solution(437674, 3));
		System.out.println(solution(110011, 10));
	}
}
