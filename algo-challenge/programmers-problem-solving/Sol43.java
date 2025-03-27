package study;

//스킬트리
import java.io.*;
import java.util.*;

class Sol43 {
	public int solution(String skill, String[] skill_trees) {
		int cnt = 0;

		for (String tree : skill_trees)
		{
			Queue<Character> queue = new LinkedList<>();

			for (char c : skill.toCharArray())
				queue.offer(c);
			boolean check = true;
			for (char c : tree.toCharArray())
			{
				if (queue.contains(c))
				{
					if (c != queue.peek())
					{
						check = false;
						break ;
					}
					else
						queue.poll();
				}
			}
			if (check == true)
				cnt++;
		}
		return cnt;
	}
}
