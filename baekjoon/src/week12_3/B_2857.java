package week12_3;

import java.io.*;
import java.util.regex.*;

public class B_2857 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Pattern pattern = Pattern.compile("FBI");
		// .*FBI.*
		
		for(int i=0;i<5;i++) {
			String input = br.readLine();
			Matcher matcher = pattern.matcher(input);
			
			if(matcher.find())
				sb.append(i + 1).append(' ');
		}
		
		if(sb.toString().equals(""))
			System.out.println("HE GOT AWAY!");
		else
			System.out.println(sb);
		
		br.close();
	}

}
