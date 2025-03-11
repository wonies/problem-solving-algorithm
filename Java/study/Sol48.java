package study;

import java.io.*;
import java.util.*;


class Sol48 {

	class File {
		String origin;
		String head;
		int num;
		String tail;

		public File(String origin, String head, int num, String tail)
		{
			this.origin = origin;
			this.head = head;
			this.num = num;
			this.tail = tail;
		}
	}

	public String[] solution(String[] files) {
		String[] answer = new String[files.length];

		ArrayList<File> fList = new ArrayList<>();

		for (String file : files)
		{
			int idx = 0;
			for (int i=0; i<file.length(); i++)
			{
				if (Character.isDigit(file.charAt(i)))
				{
					// System.out.print(file.charAt(i) + " ");
					idx = i;
					break ;
				}
			}

			int numEnd = idx;
			while (numEnd < file.length() && Character.isDigit(file.charAt(numEnd)))
				numEnd++;

			String head = file.substring(0, idx);
			int num = Integer.parseInt(file.substring(idx, numEnd));
			String tail = file.substring(numEnd);
			fList.add(new File(file, head.toLowerCase(), num, tail.toLowerCase()));
		}
		Collections.sort(fList, (f1, f2) -> {
			int headCompare = f1.head.compareTo(f2.head);
			if (headCompare != 0) {
				return headCompare;
			}
			return f1.num - f2.num;
		});

		for (int i=0; i < files.length; i++)
			answer[i] = fList.get(i).origin;


		return answer;
	}
}
