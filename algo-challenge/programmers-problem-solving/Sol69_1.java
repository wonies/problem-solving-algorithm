// 숫자카드나누기

class Sol69_1 {

	public int gcd(int a, int b)
	{
		while (b!=0)
		{
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	public int arrayGcd(int []array)
	{
		if (array.length == 0) return 0;
		int res = array[0];
		for (int i=1; i<array.length; i++)
			res = gcd(res, array[i]);
		return res;
	}


	public int solution(int[] arrayA, int[] arrayB) {
		int answer = 0;
		int a = arrayGcd(arrayA);
		int b = arrayGcd(arrayB);

		// System.out.println("a , b : " + a + " " + b);

		boolean validA = true;
		boolean validB = true;

		for (int x : arrayA)
		{
			if (x % b == 0)
				validA = false;
		}

		for (int y : arrayB)
		{
			if (y % a == 0)
				validB = false;
		}

		if (!validA && !validB)
			return 0;
		else if (!validA)
			return a;
		else if (!validB)
			return b;
		else
			return Math.max(a,b);
	}
}
