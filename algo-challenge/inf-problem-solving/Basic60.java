package inf;

// 투 포인트 알고리즘:  두 배열 합치기
import java.io.*;
import java.util.*;

public class Basic60 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(br.readLine());
		int [] arr_comp = new int[m];

		st = new StringTokenizer(br.readLine());
		for (int i=0; i<m; i++)
			arr_comp[i] = Integer.parseInt(st.nextToken());

		int [] ans = new int[n + m];

		int p1 = 0, p2 = 0, k = 0;

		while (p1 < n && p2 < m)
		{
			if (arr[p1] < arr_comp[p2])
				ans[k++] = arr[p1++];
			else
				ans[k++] = arr_comp[p2++];
		}

		while (p1 < n)
			ans[k++] = arr[p1++];
		while (p2 < m)
			ans[k++] = arr_comp[p2++];

		for (int i=0; i<n+m; i++) {
			System.out.print(ans[i] + " ");
		}
	}
}
