package study;

//124나라의 숫자
import java.io.*;
import java.util.*;

class Sol67 {
	public String solution(int n) {
		String[] digits = {"4", "1", "2"};
		String res = "";
		while (n > 0)
		{
			res = digits[n % 3] + res;
			n = (n - 1) / 3;
		}
		return res;
	}
}
