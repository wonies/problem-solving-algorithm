package study;

import java.io.*;
import java.util.*;


public class Sol3 {
	public String solution(String s) {
		String answer = "";
		String[] words = s.split(" ", -1);
		int len = words.length;
		for (int i=0; i<len; i++) {
			if (!words[i].isEmpty()) {
				if (Character.isLetter(words[i].charAt(0))) {
					char first = Character.toUpperCase(words[i].charAt(0));
					String rest = words[i].substring(1).toLowerCase();
					words[i] = first + rest;
				} else {
					words[i] = words[i].toLowerCase();
				}
			}

			answer += words[i];
			if (i < words.length - 1) {
				answer += " ";
			}
		}
		return answer;
	}
}
