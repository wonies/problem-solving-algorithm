import java.io.*;

public class Basic1 {
	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String line = br.readLine().trim().toLowerCase();
			char c = Character.toLowerCase(br.readLine().trim().charAt(0));

			int cnt = 0;
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) == c) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}
