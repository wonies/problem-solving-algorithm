package inf;
//응급실
import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Basic46 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine()); // 첫 번째 줄 읽기
		int n = Integer.parseInt(st.nextToken()); // n (5)
		int m = Integer.parseInt(st.nextToken()); // m (2)

		st = new StringTokenizer(br.readLine()); // 두 번째 줄 (환자들의 위험도) 읽기
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			int val = Integer.parseInt(st.nextToken());
			queue.offer(new int[]{val, i}); // (환자 위험도, 원래 인덱스)
		}
		// for (int[] arr : queue) {
		// 	System.out.println(Arrays.toString(arr)); // [값, 인덱스] 형태로 출력됨
		// }
		int cnt = 0;
		while (queue.size() > 1)
		{
			int [] front = queue.poll();
			int key = front[0];
			int idx = front[1];
			boolean danger = false;

			for (int[] p : queue)
			{
				if (p[0] > key)
				{
					danger = true;
					break ;
				}
			}

			if (danger)
			{
				queue.offer(new int[]{key, idx});
			}
			else {
				cnt++;
				if (idx == m)
				{
					System.out.println(cnt);
					break ;
				}
			}
		}



	}
}
