
import java.util.*;
import java.io.*;


public class Basic3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		int maxLen = 0;
		int strLen = 0;
		String ans = "";
		int startlen = 0;

		for (int i = 0; i < len; i++){
			char c = str.charAt(i);
			if (c == ' ')
			{
				if (maxLen < strLen)
				{
					maxLen = strLen;
					ans = str.substring(startlen, i);
				}
				strLen = 0;
				startlen = i + 1;
			}
			else
				strLen++;
		}
		if (maxLen < strLen)
			ans = str.substring(startlen);

		System.out.println(ans);
	}
}
