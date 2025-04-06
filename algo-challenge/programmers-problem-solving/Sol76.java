// 76번째 문제 - 괄호변환
import java.io.*;
import java.util.*;

class Sol76 {

	public String reverse(String s) {
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray())
			sb.append(c == '(' ? ')' : '(');
		return sb.toString();
	}

	public boolean isCorrect(String p)
	{
		Stack<Character> stack = new Stack<>();
		for (char c : p.toCharArray())
		{
			if (c == '(') stack.push(c);
			else
			{
				if (stack.isEmpty()) return false;
				stack.pop();
			}
		}
		return stack.isEmpty();
	}

	public String[] splitBalance(String p)
	{
		int open = 0, close = 0;
		int idx = 0;
		for (int i=0; i<p.length();i++)
		{
			if (p.charAt(i) == '(')
				open++;
			else
				close++;
			if (open == close)
			{
				idx = i + 1;
				break ;
			}
		}
		String u = p.substring(0, idx);
		String v = p.substring(idx);
		return new String[] {u, v};
	}


	public String convert(String p)
	{
		System.out.println("convert() 호출됨: p = " + p);
		if (p.equals(""))
			return "";

		String[] uv = splitBalance(p);
		String u = uv[0];
		String v = uv[1];
		System.out.println("u = " + u + ", v = " + v);

		if (isCorrect(u))
		{
			System.out.println("u가 올바른 괄호입니다: " + u);
			return u + convert(v);

		}
		else
		{
			System.out.println("u가 올바르지 않음. 고치는 중: " + u);
			StringBuilder sb = new StringBuilder();
			sb.append('(');
			sb.append(convert(v));
			sb.append(')');
			String trimmed = u.substring(1, u.length()-1);
			String reversed = reverse(trimmed);
			System.out.println("u 내부를 자르고 뒤집은 결과: " + reversed);
			sb.append(reversed);
			System.out.println("최종 변환 결과: " + sb.toString());
			return sb.toString();
		}
	}


	public String solution(String p) {
		String answer = "";
		return this.convert(p);
	}
}
