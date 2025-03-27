package inf;

import java.util.*;
import java.io.*;

public class Basic18 {
	public static int solution(int n) {
		int ans = 0;
		int[] ch = new int[n + 1];
		for (int i = 2; i < n; i++){
			if (ch[i] == 0)
			{
				ans++;
				for (int j=i; j<=n; j=j+i)
					ch[j] = 1;
			}
		}
		return ans;
	}


	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int num = solution(n);
		System.out.println(num);
	}
}
