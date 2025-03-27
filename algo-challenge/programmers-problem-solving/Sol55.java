package study;

//쿼드 압축 후 개수 세기

import java.io.*;
import java.util.*;

class Sol55 {
	static int zero;
	static int one;

	private static void compress(int x, int y, int size, int[][] arr, int depth) {
		// 현재 재귀 깊이와 검사 영역 출력
		String indent = "  ".repeat(depth);
		System.out.println(indent + "재귀 깊이: " + depth + ", 검사 영역: (" + x + "," + y + ") 크기: " + size);

		// 현재 영역 출력
		System.out.println(indent + "현재 영역:");
		for (int i = x; i < x + size; i++) {
			System.out.print(indent);
			for (int j = y; j < y + size; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		int init = arr[x][y];
		boolean isSame = true;

		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (arr[i][j] != init) {
					isSame = false;
					break;
				}
			}
			if (!isSame) break;
		}

		if (isSame) {
			if (init == 0) {
				zero++;
				System.out.println(indent + "모든 값이 0으로 동일 -> zero 증가: " + zero);
			} else {
				one++;
				System.out.println(indent + "모든 값이 1로 동일 -> one 증가: " + one);
			}
		} else {
			System.out.println(indent + "값이 다름 -> 4등분하여 재귀 호출");
			int newsize = size / 2;

			System.out.println(indent + "좌상단 재귀 호출 | size : " + size );
			compress(x, y, newsize, arr, depth + 1);

			System.out.println(indent + "우상단 재귀 호출 | size : " + size);
			compress(x, y + newsize, newsize, arr, depth + 1);

			System.out.println(indent + "좌하단 재귀 호출 | size : " + size);
			compress(x + newsize, y, newsize, arr, depth + 1);

			System.out.println(indent + "우하단 재귀 호출 | size : " + size);
			compress(x + newsize, y + newsize, newsize, arr, depth + 1);
		}

		System.out.println(indent + "재귀 깊이 " + depth + " 종료");
	}

	public static int[] solution(int[][] arr) {
		// 카운터 초기화
		zero = 0;
		one = 0;

		System.out.println("압축 시작");
		compress(0, 0, arr.length, arr, 0);
		System.out.println("압축 완료: 0의 개수=" + zero + ", 1의 개수=" + one);

		return new int[] {zero, one};
	}

	public static void main(String[] args) throws IOException {
		int[][] arr = {
			{1, 1, 0, 0},
			{1, 0, 0, 0},
			{1, 0, 0, 1},
			{1, 1, 1, 1}
		};

		System.out.println("원본 배열:");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

		int[] result = Sol55.solution(arr);

		// 결과 출력
		System.out.println("\n최종 결과 -> zero: " + result[0] + ", one: " + result[1]);
	}
}
