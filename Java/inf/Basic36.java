package inf;

//K번째 수
import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Basic36 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] cards = new int[n];
		for (int i=0; i<n; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}

		TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

		for (int i=0; i<n; i++)
		{
			for (int j=i+1; j<n; j++)
			{
				for (int k=j+1; k<n; k++)
					set.add(cards[i] + cards[j] + cards[k]);
			}
		}
		int cnt = 0;
		int res = -1;

		for (int num : set)
		{
			cnt++;
			if (cnt == m)
			{
				res = num;
				break ;
			}
		}
		System.out.println(res);
	}
}
