package inf;

// 매출액의 종류

import java.io.*;
import java.util.*;

public class Basic34 {

	public static void solution(int n, int k, int [] arr)
	{
		int right = k-1;
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i=0; i<n; i++)
		{
			int left = i;
			// int right = i + k - 1;
			while (left <= right)
			{
				map.put(arr[left], map.getOrDefault(arr[left], 0) + 1);
				left++;
				// map.forEach((key, value)->System.out.println("key : " + key + "\nvalue " + value));
			}
			// System.out.println("left " + left + "size : " + map.size());
			int size = map.size();
			System.out.println(size + " ");
			right++;
			map.clear();
			if (right == n) {
				return ;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = {20, 12, 20, 10, 23, 17, 10};
		solution(7, 4, arr);
	}


}
