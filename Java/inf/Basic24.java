package inf;
import java.io.*;
import java.util.*;

public class Basic24 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] classes = new int[n][5];

		for (int i=0; i<n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<5; j++)
			{
				classes[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int [] count = new int[n];
		for (int i=0; i<n; i++)
		{
			for (int j=0; j<n; j++)
			{
				if (i==j) continue;
				for (int k=0; k<5; k++)
				{
					if (classes[i][k] == classes[j][k])
					{
						count[i]++;
						break;
					}
				}
			}
		}
		int leader = 0;
		int maxfri = -1;
		for (int i=0; i<n; i++)
		{
			if (count[i] > maxfri)
			{
				maxfri = count[i];
				leader = i + 1;
			}
		}
		System.out.println(leader);
	}

}
