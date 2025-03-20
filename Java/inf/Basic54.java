package inf;

import java.io.*;
import java.util.*;

public class Basic54 {

	private static void dfs(int n)
	{
		if (n==0)
			return ;
		dfs(n-1);
		System.out.print(n + " ");
	}

	public static void main(String[] args) {
		dfs(3);
	}


}
