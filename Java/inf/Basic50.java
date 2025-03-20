package inf;

//이분검색
import java.io.*;
import java.nio.IntBuffer;
import java.util.*;

public class Basic50 {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		for (int i=0; i<n; i++)
		{
			if (arr[i] == m)
			{
				System.out.println(i + 1);
				return ;
			}
		}
	}
}
