// 조이스틱
import java.io.*;
import java.util.*;

class Sol91 {
	public int solution(String name) {
		int cnt = 0;

		for (int i=0; i<name.length(); i++) {
			char ch = name.charAt(i);
			cnt += Math.min(ch - 'A', 'Z' - ch + 1);
			System.out.println("name : " + ch + " cnt : " + cnt);
		}

		int move = name.length() - 1;
		for (int i=0; i<name.length(); i++) {
			int next = i + 1;

			while (next < name.length() && name.charAt(next) == 'A')
				next++;
			int dist = i + name.length() - next + Math.min(i, name.length() - next);
			move = Math.min(move, dist);
		}


		return cnt + move;
	}
}
