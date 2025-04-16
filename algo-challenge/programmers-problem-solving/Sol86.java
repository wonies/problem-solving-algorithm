// 멀쩡한 사각형
import java.io.*;
import java.util.*;

class Sol86 {

	private int gcd(int a, int b)
	{
		while (b != 0)
		{
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	public long solution(int w, int h) {
		long square = (long)w * (long)h - ( w + h - gcd(w, h) );

		return square;
	}
}
