// 프로그래머스 [3차] 방금그곡
import java.io.*;
import java.util.*;

class Sol73 {

	public int remainTime(String start, String end)
	{
		String[] s = start.split(":");
		String[] e = end.split(":");
		int startMin = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
		int endMin = Integer.parseInt(e[0]) * 60 + Integer.parseInt(e[1]);

		return endMin - startMin;
	}

	private String convertMelody(String s)
	{
		return s.replaceAll("C#", "c")
			.replaceAll("D#", "d")
			.replaceAll("F#", "f")
			.replaceAll("G#", "g")
			.replaceAll("A#", "a")
			.replaceAll("B#", "b");
	}


	public String solution(String m, String[] musicinfos) {
		String answer = "(None)";
		m = convertMelody(m);
		int maxTime = -1;
		for (String info : musicinfos)
		{
			String[] parts = info.split(",");
			int times = remainTime(parts[0], parts[1]);
			String title = parts[2];
			String lyrics = convertMelody(parts[3]);

			StringBuilder sb = new StringBuilder();
			for (int i=0; i<times; i++)
				sb.append(lyrics.charAt(i % lyrics.length()));
			String fullLyrics = sb.toString();
			if (fullLyrics.contains(m) && times > maxTime)
			{
				answer = title;
				maxTime = times;
			}
		}
		return answer;
	}
}
