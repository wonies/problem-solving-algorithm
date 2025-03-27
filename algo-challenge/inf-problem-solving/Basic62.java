package inf;

// 슬라이딩 윈도우 연습
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class  Basic62 {

	public static ArrayList<Integer> solution(int n, int m, int[] a, int []b)
	{
		int p1 = 0, p2 = 0;
		Arrays.sort(a);
		Arrays.sort(b);

		ArrayList<Integer> arr = new ArrayList<>();
		while (p1 < n && p2 < m)
		{
			if (a[p1] == b[p2]){
				arr.add(a[p1]);
				p1++;
				p2++;
			}
			else if (a[p1] > b[p2])
				p2++;
			else if (a[p1] < b[p2])
				p1++;
		}
		return arr;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] a = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++)
			a[i] = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		int [] b = new int[m];

		st = new StringTokenizer(br.readLine());
		for (int i=0; i<m; i++)
			b[i] = Integer.parseInt(st.nextToken());

		ArrayList<Integer> ans = solution(n, m, a, b);
		for (int x : ans)
			System.out.print(x + " ");
	}
}
