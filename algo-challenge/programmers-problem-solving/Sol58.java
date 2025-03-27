package study;

// 다리를 지나는 트럭

import java.io.*;
import java.util.*;

class Sol58 {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Integer> queue = new LinkedList<>();
		int cur_weight = 0;
		int cnt = 0;

		for (int truck: truck_weights)
		{
			while (true)
			{
				if (queue.size() == bridge_length)
				{
					cur_weight -= queue.poll();
				}
				else
				{
					if (cur_weight + truck <= weight)
					{
						queue.add(truck);
						cur_weight += truck;
						cnt++;
						break;
					}
					else
					{
						queue.add(0);
						cnt++;
					}
				}
			}
		}

		return cnt + bridge_length;
	}
}
