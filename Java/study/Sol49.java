package study;

//오픈채팅방
import java.io.*;
import java.util.*;

class Sol49 {
	public String[] solution(String[] record) {

		HashMap<String, String> map = new HashMap<>();
		ArrayList<String> arr = new ArrayList<>();

		for (String rec : record)
		{
			String[] parts = rec.split(" ");
			String action = parts[0];
			String uid = parts[1];

			if (action.equals("Enter") || action.equals("Change"))
			{
				String nickname = parts[2];
				map.put(uid, nickname);
			}
		}

		for (String rec : record)
		{
			String[] parts = rec.split(" ");
			String action = parts[0];
			String uid = parts[1];

			if (action.equals("Enter"))
				arr.add(map.get(uid) + "님이 들어왔습니다.");
			else if (action.equals("Leave"))
				arr.add(map.get(uid) + "님이 나갔습니다.");
		}

		return arr.toArray(new String[arr.size()]);
	}
}
