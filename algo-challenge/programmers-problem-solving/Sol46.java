package study;

import java.io.*;
import java.util.*;

class Sol46 {

	private int calFee(int acc, int[] fees)
	{
		if (acc < fees[0])
			return fees[1];
		else
		{
			int overTime = acc - fees[0];
			int overTimeFee = (int) Math.ceil((double) overTime / fees[2]) * fees[3];
			return fees[1] + overTimeFee;
		}
	}

	public int[] solution(int[] fees, String[] records) {
		int[] answer = {};
		HashMap<String, Object[]> map = new HashMap<>();

		for (String record : records)
		{
			String rec[] = record.split(" ");
			String time = rec[0];
			String carNum = rec[1];
			String inout = rec[2];

			String timePart[] = time.split(":");

			int hours = Integer.parseInt(timePart[0]);
			int mins = Integer.parseInt(timePart[1]);

			int tot = (hours * 60) + mins;

			if (inout.equals("IN"))
			{
				if (!map.containsKey(carNum))
				{
					Object[] carInfo = new Object[3];
					carInfo[0] = tot;
					carInfo[1] = 0;
					carInfo[2] = true;
					map.put(carNum, carInfo);
				}
				else
				{
					Object[] carInfo = map.get(carNum);
					carInfo[0] = tot;
					carInfo[2] = true;
					map.put(carNum, carInfo);
				}
			}
			else
			{
				Object[] carInfo = map.get(carNum);
				int init = (Integer) carInfo[0];
				int accTime = (Integer) carInfo[1];

				carInfo[1] = accTime + (tot - init);
				carInfo[2] = false;
				map.put(carNum, carInfo);
			}
		}

		int endTime = (23 * 60) + 59;

		for (Map.Entry<String, Object[]> entry : map.entrySet())
		{
			String carNums = entry.getKey();
			Object[] carInfo = entry.getValue();
			boolean isParked = (boolean) carInfo[2];

			if (isParked)
			{
				int init = (Integer) carInfo[0];
				int accTime = (Integer) carInfo[1];

				int addTime = endTime - init;
				carInfo[1] = accTime + addTime;
				carInfo[2] = false;
				map.put(carNums, carInfo);
			}
		}

		List<String> carNumbers = new ArrayList<>(map.keySet());
		Collections.sort(carNumbers);

		answer = new int[carNumbers.size()];

		for (int i=0; i<carNumbers.size(); i++)
		{
			String carNum = carNumbers.get(i);
			Object[] carInfo = map.get(carNum);
			int accTime = (Integer) carInfo[1];

			int fee = calFee(accTime, fees);
			answer[i] = fee;
		}

		return answer;
	}
}
