package inf;


import java.io.*;
import java.util.*;

public class Basic26 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> arr = new ArrayList<>();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++)
			arr.add(Integer.parseInt(st.nextToken()));
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int j=0; j<m; j++)
			arr.add(Integer.parseInt(st.nextToken()));

		Collections.sort(arr);
		for (int x : arr)
			System.out.print(x + " ");
	}
}
