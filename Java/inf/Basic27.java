package inf;

import java.io.*;
import java.util.*;

public class Basic27 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] arr = new int [n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		int [] arrm = new int[m];
		st = new StringTokenizer(br.readLine());

		for (int i=0; i<m; i++)
			arrm[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		Arrays.sort(arrm);

		ArrayList<Integer> ans = new ArrayList<>();
		int i=0, j=0;
		while (i<n && j<m)
		{
			if (arr[i] == arrm[j]){
				ans.add(arr[i]);
				i++;
				j++;
			}
			else if (arr[i] < arrm[j])
				i++;
			else
				j++;
		}
		for (int num: ans)
			System.out.print(num+ " ");
	}
}
