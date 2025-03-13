package inf;

//장난꾸러기
import java.io.*;
import java.util.*;

public class Basic48 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int [] arr = new int[n];

		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int [] cpy = new int[n];
		for (int i=0; i<n; i++)
		{
			cpy[i] = arr[i];
		}

		Arrays.sort(cpy);

		for(int i=0; i<n; i++)
		{
			if (arr[i] != cpy[i])
				System.out.print((i + 1) + " ");
		}

	}
}
