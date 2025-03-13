package inf;
// 교육과정설계
import java.io.*;
import java.util.*;

public class Basic45 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ord = br.readLine();
		String subs  = br.readLine();

		Queue<Character> queue = new LinkedList<>();

		for (char c : ord.toCharArray())
		{
			queue.offer(c);
		}
		boolean valid = true;
		for (char c : subs.toCharArray())
		{
			if (queue.contains(c))
			{
				if (queue.peek() != c)
				{
					valid = false;
					break;
				}
				queue.poll();
			}
		}
		if (valid && queue.isEmpty())
			System.out.println("YES");
		else
			System.out.println("NO");

	}
}
