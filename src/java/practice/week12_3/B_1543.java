package java.practice.week12_3;

import java.io.*;
import java.util.regex.*;

public class B_1543 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String word = br.readLine();
		int cnt = 0;
		
		Pattern pattern = Pattern.compile(word);
		Matcher matcher = pattern.matcher(input);
		while(matcher.find())
			cnt++;
		
		System.out.println(cnt);
		br.close();
	}

}
