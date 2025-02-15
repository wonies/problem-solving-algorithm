package inf;

import java.util.*;

public class exam2 {
	static int N, K, P;
	static int[][] board;
	static int[] power;
	static int minPower = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();
		P = sc.nextInt();

		board = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		power = new int[K+1];
		for(int i = 0; i < K; i++) {
			power[i] = sc.nextInt();
		}

		dfs(0, 0, 0);

		System.out.println(minPower == Integer.MAX_VALUE ? -1 : minPower);
	}

	static void dfs(int totalScore, int totalPower, int count) {
		if(totalScore >= P) {
			minPower = Math.min(minPower, totalPower);
			return;
		}

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int size = 1; size <= K; size++) {
					int score = calculateScore(i, j, size);
					dfs(totalScore + score, totalPower + power[size], count + 1);
				}
			}
		}
	}

	static int calculateScore(int x, int y, int size) {
		int score = 0;

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				double distance = Math.sqrt(Math.pow(x-i, 2) + Math.pow(y-j, 2));
				if(distance < size) {
					score += board[i][j];
				}
			}
		}

		return score;
	}
}