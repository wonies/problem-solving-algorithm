package basic;

import static java.lang.Math.*;

public class basic_3 {
	public static void prodivisor(int n)
	{
		int sum = 1;
		System.out.print(sum);
		for (int i = 2; i <= (n / 2 + 1); i++)
		{
			if (n % i == 0)
			{
				System.out.print(" + " + i);
				sum += i;
			}
		}
		System.out.print(" = " + sum);
	}

	public static void main(String[] args) {
		prodivisor(20);
	}
}
