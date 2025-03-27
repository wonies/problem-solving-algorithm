package basic;


import java.util.*;

public class basic_4 {

	public static int diffres(int n, int[] numbers)
	{
		int res = 0;
		Arrays.sort(numbers);
		res = numbers[n-1] - numbers[0];
		return res;
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int numbers[] = new int[n];
		int res;
		for (int i = 0; i < n; i++)
		{
			numbers[i] = sc.nextInt();
 		}
		res = diffres(n, numbers);
		System.out.println(res);
	}
}
