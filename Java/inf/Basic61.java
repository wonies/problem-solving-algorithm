package inf;

// 투 포인트 알고리즘:  두 배열 합치기
import java.io.*;
import java.util.*;

public class Basic61 {

	public static ArrayList<Integer> solution(int n, int m, int[]arr, int []arr_comp)
	{
		ArrayList<Integer> answer = new ArrayList<>();
		int p1=0, p2=0;
		while (p1 < n && p2 < m) {
			if (arr[p1] < arr_comp[p2]) answer.add(arr[p1++]);
			else answer.add(arr_comp[p2++]);
		}
		while (p1 < n) answer.add(arr[p1++]);
		while (p2 < m) answer.add(arr_comp[p2++]);
		return answer;
	}


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

		ArrayList<Integer> ans = solution(n, m, arr, arr_comp);
		for (int x : ans)
			System.out.print(x + " ");
	}
}
