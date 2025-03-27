package study;

// 영어끝말잇기

import java.util.*;

public class Sol15 {
	private static boolean checkValid(String[] words, String word, int idx)
	{
		for (int i=0; i<idx; i++)
		{
			if (words[i].equals(word))
				return false;
		}
		return true;
	}

	public static int[] solution(int n, String[] words) {
		int[] answer = new int[2];
		boolean check = true;
		for (int i=1; i<words.length; i++){
			if (words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)) {

				answer[0] = ((i + 1) % n == 0) ? n : (i + 1) % n;
				answer[1] = (i / n) +  1;
				return answer;
			}
			check = checkValid(words, words[i], i);
			if (!check) {
				answer[0] = ((i + 1) % n == 0) ? n : (i + 1) % n;
				answer[1] = (i / n) +  1;
				return answer;
			}
		}
		return answer;
	}


	public static void main(String[] args) {
		String[] word = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		String[] word2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
		String[] word3 = {"hello", "one", "even", "never", "now", "world", "draw"};
		String[] word4 = {"hello", "one", "even", "even", "now", "draw"};
		System.out.println(Arrays.toString(solution(3, word)));
		System.out.println(Arrays.toString(solution(5, word2)));
		System.out.println(Arrays.toString(solution(2, word3)));
		System.out.println(Arrays.toString(solution(4, word4)));
	}
}
