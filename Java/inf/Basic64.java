package inf;
//연속된 자연수의 합
import java.io.*;
import java.util.*;
public class  Basic64 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] arr = new int[n + 1];

		for (int i=0; i<n; i++)
			arr[i] = i + 1;

		int lt = 0, rt = 0;
		int sum = 0;
		int ans = 0;
		while (rt < n - 1)
		{
			sum += arr[rt];
			if (sum == n) {
				ans++;
			}
			while (sum >= n)
			{
				sum -= arr[lt++];
				if (sum == n) ans++;
			}
			rt++;
		}
		System.out.println(ans);


	}
}

