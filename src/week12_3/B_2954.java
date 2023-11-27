package week12_3;

import java.util.regex.*;
import java.io.*;

public class B_2954 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringBuilder sb = new StringBuilder(input);
		
		Pattern pattern = Pattern.compile("(a|e|i|o|u)");
		Matcher matcher = pattern.matcher(input);
		boolean flag = false;

		while(matcher.find()) {
			if(!flag) {
				int pos = matcher.start();
				sb.replace(pos + 1, pos + 3, "**");
			}
			flag = !flag;
		}
		
		// input = input.replaceAll("(?:(a|e|i|o|u))(p)(a|e|i|o|u)", "$1");
		System.out.println(sb.toString().replaceAll("\\*\\*", ""));
		br.close();
	}

}
