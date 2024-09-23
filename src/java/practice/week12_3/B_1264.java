package java.practice.week12_3;

import java.io.*;
import java.util.regex.*;

public class B_1264 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Pattern pattern = Pattern.compile("(?i)(a|e|i|o|u)");
		
		while(true) {
			int cnt = 0;
			String input = br.readLine();
			if(input.equals("#"))
				break;
			
			Matcher m = pattern.matcher(input);
			while(m.find())
				cnt++;
			
			sb.append(cnt).append('\n');
		}
		
		System.out.println(sb);
		br.close();
	}

}
