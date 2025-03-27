package study;
import java.util.*;
import java.io.*;

public class Sol12 {

	public int solution(int n) {
		int ans = 0;
		int temp = n;

		while (temp > 0)
		{
			if (temp % 2 == 0)
				temp = temp / 2;
			else
			{
				temp -= 1;
				ans++;
			}
		}
		return ans;
	}
}
