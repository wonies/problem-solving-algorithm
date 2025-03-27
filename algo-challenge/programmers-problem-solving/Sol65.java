package study;
//호텔대실
import java.io.*;
import java.util.*;

class Sol65 {

	public int convertTime(String time)
	{
		String[] part = time.split(":");
		return (Integer.parseInt(part[0]) * 60) + Integer.parseInt(part[1]);
	}

	public int solution(String[][] book_time) {

		List<int[]> rooms = new ArrayList<>();

		for (int i=0; i<book_time.length; i++)
		{
			String start = book_time[i][0];
			String end = book_time[i][1];
			int startTime = convertTime(start);
			int endTime = convertTime(end);
			rooms.add(new int[]{startTime, endTime});
		}
		rooms.sort((a, b)->Integer.compare(a[0], b[0]));

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int[] room : rooms)
		{
			if (!pq.isEmpty() && pq.peek() <= room[0])
				pq.poll();
			pq.add(room[1] + 10);
		}

		return pq.size();
	}
}
