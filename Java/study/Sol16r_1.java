package study;

public class Sol16r_1 {
	public static int solution(int k, int[] numbers) {

		int max = Integer.MIN_VALUE;
		for (int size : numbers)
			max = Math.max(max, size);
		int [] tans = new int [max + 1];
		for (int i : numbers)
			tans[i]++;
		int[] counts = new int[tans.length + 1];
		for (int tan : tans){
			if (tan > 0)
				counts[tan]++;
		}

		int cnt = 0;
		int tot = 0;

		for (int i=counts.length-1; i>0; i--)
		{
			while (counts[i] > 0 && tot < k)
			{
				tot += i;
				cnt++;
				counts[i]--;
			}
			if (tot >= k) break;
		}

		return cnt;
	}

	public static void main(String[] args) {
		int[] tan = {1, 3, 2, 5, 4, 5, 2, 3};
		int[] tan2 = {1, 3, 2, 5, 4, 5, 2, 3};
		int[] tan3 = {1, 1, 1, 1, 2, 2, 2, 3};
		int[] tan4 = {1000, 2000, 2000, 1000};
		int[] tan5 = {1};
		System.out.println(solution(6, tan));
		System.out.println(solution(4, tan2));
		System.out.println(solution(2, tan3));
		System.out.println(solution(2, tan4));
		System.out.println(solution(1, tan5));
	}
}
