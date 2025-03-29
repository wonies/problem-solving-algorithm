//Sol69 숫자카드나누기
import java.io.*;
import java.util.*;

class Solution {


	public int gcd(int a, int b)
	{
		while (b != 0)
		{
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}


	public int solution(int[] arrayA, int[] arrayB) {
		int answer = 0;
		int divide = findValue(arrayA, arrayB);
		System.out.println("divide val : " + divide)
		return answer;
	}

	public static void main(String[] args) {
		int[] arr = {10, 17};
		int[] arr2 = {5, 20};
		int[] arr3 = {10, 20};
		int[] arr4 = {5, 17};
		System.out.println(solution(arr, arr2));
		System.out.println(solution(arr3, arr4));
	}
}
