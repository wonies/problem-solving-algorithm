package inf;

import java.util.*;

public class exam2 {
	static int N, K, P;
	static int[][] board;
	static int[] power;
	static int minPower = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력 받기
		N = sc.nextInt(); // 과녁 크기
		K = sc.nextInt(); // 화살 종류
		P = sc.nextInt(); // 목표 점수

		// 과녁 점수 입력
		board = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		// 화살별 필요한 힘 입력
		power = new int[K+1];
		for(int i = 0; i < K; i++) {
			power[i] = sc.nextInt();
		}

		// 모든 가능한 조합 시도
		dfs(0, 0, 0);

		System.out.println(minPower == Integer.MAX_VALUE ? -1 : minPower);
	}

	// 화살을 쏘는 모든 경우의 수를 시도하는 DFS
	static void dfs(int totalScore, int totalPower, int count) {
		// 목표 점수를 달성한 경우
		if(totalScore >= P) {
			minPower = Math.min(minPower, totalPower);
			return;
		}

		// 모든 위치와 모든 화살 크기에 대해 시도
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int size = 1; size <= K; size++) {
					int score = calculateScore(i, j, size);
					dfs(totalScore + score, totalPower + power[size], count + 1);
				}
			}
		}
	}

	// 특정 위치에 특정 크기의 화살을 쏘았을 때 얻는 점수 계산
	static int calculateScore(int x, int y, int size) {
		int score = 0;

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				// 현재 위치와의 거리 계산
				double distance = Math.sqrt(Math.pow(x-i, 2) + Math.pow(y-j, 2));
				// 화살 크기 내에 있는 경우 점수 추가
				if(distance < size) {
					score += board[i][j];
				}
			}
		}

		return score;
	}
}