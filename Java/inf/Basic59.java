package inf;

import java.io.*;
import java.util.*;

public class Basic59 {

	static int n;
	static int[] ch;
	public static void dfs(int dep)
	{
		if (dep == n + 1)
		{
			String temp = "";
			for (int i=1; i<=n; i++){
				if (ch[i] == 1) temp += (i + " ");
			}
			if (temp.length() > 0)
				System.out.print("{ " + temp + "}");

			return ;
		}
		ch[dep] = 1;
		dfs(dep + 1);
		ch[dep] = 0;
		dfs(dep + 1);
	}


	public static void main(String[] args) {
		n = 3;
		ch = new int[n + 1];
		dfs(1);
	}
}
