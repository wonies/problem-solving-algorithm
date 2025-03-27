package inf;

import java.io.*;
import java.util.*;

public class Basic20 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] cnts = new int [n];
		for (int i = 0; i < n; i++)
			cnts[i] = Integer.parseInt(st.nextToken());
		int cnt = 0;
		int tag = 0;
		for (int i = 0; i < n; i++) {
			if (cnts[i] == 1) {
				cnt++;
				cnt += tag;
				tag++;
			}
			else {
				tag = 0;
			}
		}
		System.out.println(cnt);
	}
}
