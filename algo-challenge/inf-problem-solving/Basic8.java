package inf;

import java.io.*;

public class Basic8 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine().toLowerCase();
		int left = 0;
		int right = line.length() - 1;
		while (left < right)
		{
			if (!Character.isAlphabetic(line.charAt(left)))
				left++;
			else if (!Character.isAlphabetic(line.charAt(right)))
				right--;
			else {
				if (line.charAt(left) != line.charAt(right)){
					System.out.println("NO");
					return ;
				}
				left++;
				right--;
			}
		}
		System.out.println("YES");
	}
}
