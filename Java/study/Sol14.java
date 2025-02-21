package study;
//프로그래머스 : N개의 최소공배수

import java.io.*;
import java.util.*;
public class Sol14 {
		private static int gcd(int a, int b)
		{
			int temp;
			while (b != 0)
			{
				temp = b;
				b = a % b;
				a = temp;
			}
			return a;
		}

		private static int lcm(int a, int b){
			return (a * b) / gcd(a, b);
		}

		public static int solution(int[] arr) {
			int size = arr.length;
			if (size == 1) return 1;

			int ans = arr[0];
			for (int i=1; i<arr.length; i++)
			{
				ans = lcm(ans, arr[i]);
			}

			return ans;
		}
}
