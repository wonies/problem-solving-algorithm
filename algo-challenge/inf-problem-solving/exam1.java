package inf;

import java.util.*;



public class  exam1 {
	static ArrayList<Integer>[] graph;
	static boolean[] selected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 정점 수
		int M = sc.nextInt(); // 간선 수

		// 그래프 초기화
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		// 간선 정보 입력
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a].add(b);
			graph[b].add(a);
		}

		selected = new boolean[N + 1];
		int maxCount = 0;

		// 모든 가능한 조합 시도
		for (int state = 0; state < (1 << N); state++) {
			boolean valid = true;
			int count = 0;

			// 현재 상태가 유효한지 확인
			for (int i = 1; i <= N; i++) {
				if ((state & (1 << (i-1))) != 0) {
					// i번 정점이 선택된 경우
					for (int next : graph[i]) {
						if ((state & (1 << (next-1))) != 0) {
							// 인접한 두 정점이 모두 선택된 경우
							valid = false;
							break;
						}
					}
					if (!valid) break;
					count++;
				}
			}

			if (valid) {
				maxCount = Math.max(maxCount, count);
			}
		}

		System.out.println(maxCount);
	}
}