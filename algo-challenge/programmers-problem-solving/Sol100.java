
import java.util.*;

public class Sol100 {
	static char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
	static boolean[] visited = new boolean[8];
	static String[] conditions;
	static int answer = 0;

	public static int solution(int n, String[] data) {
		conditions = data;
		permute("", 0);
		return answer;
	}

	private static void permute(String arrangement, int depth) {
		if (depth == 8) {
			if (isValid(arrangement)) {
				answer++;
			}
			return;
		}

		for (int i = 0; i < 8; i++) {
			if (!visited[i]) {
				visited[i] = true;
				permute(arrangement + friends[i], depth + 1);
				visited[i] = false;
			}
		}
	}

	private static boolean isValid(String arrangement) {
		for (String cond : conditions) {
			char a = cond.charAt(0);
			char b = cond.charAt(2);
			char op = cond.charAt(3);
			int dist = cond.charAt(4) - '0';

			int posA = arrangement.indexOf(a);
			int posB = arrangement.indexOf(b);
			int gap = Math.abs(posA - posB) - 1;

			switch (op) {
				case '=':
					if (gap != dist) return false;
					break;
				case '<':
					if (gap >= dist) return false;
					break;
				case '>':
					if (gap <= dist) return false;
					break;
			}
		}
		return true;
	}
}
