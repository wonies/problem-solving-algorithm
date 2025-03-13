package inf;

import java.io.*;
import java.util.*;
import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {
	public int x, y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Point obj) {
		if (this.x == obj.x) return this.y - obj.y;
		else return this.x - obj.x;
	}
}

public class Basic49 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Point> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr.add(new Point(x, y));
		}
		Collections.sort(arr);
		for (Point o : arr)
			System.out.println(o.x + " " + o.y);
	}
}
