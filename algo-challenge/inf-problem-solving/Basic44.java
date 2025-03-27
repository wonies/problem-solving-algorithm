package inf;
// 공주구하기
import java.io.*;
import java.util.*;

public class Basic44 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Queue<Integer> list = new LinkedList<>();
		for (int i=1; i<=n; i++)
			list.offer(i);
		while (list.size() > 1)
		{
			for (int i=1; i<m; i++)
			{
				list.offer(list.poll());
			}
			list.poll();
		}
		System.out.println(list.poll());
	}
}
