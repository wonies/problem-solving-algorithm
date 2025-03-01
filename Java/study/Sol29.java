package study;
//전화번호목록
import java.io.*;
import java.util.*;


class Sol29 {
	public boolean solution(String[] phone_book) {
		boolean answer = true;
		HashSet<String> set = new HashSet<>();

		for (String num : phone_book)
			set.add(num);
		for (String num : phone_book)
		{
			for (int i=1; i <num.length(); i++)
			{
				if (set.contains(num.substring(0, i)))
					return false;
			}
		}

		return answer;
	}
}
