package inf;

import java.io.*;
import java.util.*;

public class example3 {

	// public static long[] solution(long[] numbers)
	// {
	//
	// }


	public static void main(String[] args) throws IOException {
		// int[] num = {2, 7};
		int bit = 1;
		int temp = 7;
		int ans = 0;
		while (true)
		{
			if (((temp & bit) == 0))
			{
				System.out.println("temp : " + temp);
				System.out.println("bit : " + bit);
				break;
			}
			bit *= 2;
		}
		bit /= 2;

		ans = temp + bit;
		System.out.println("ans :  " + ans);
	}
}
