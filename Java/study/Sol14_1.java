package study;
//프로그래머스 : N개의 최소공배수_edit

public class Sol14_1 {
		private static int gcd(int a, int b)
		{
			return b == 0 ? a : gcd(b, a % b);
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
