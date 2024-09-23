package java.practice.week12_3;

import java.util.regex.*;
import java.io.*;

public class B_2941 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		
		Pattern pattern = Pattern.compile("(c=|c-|dz=|d-|lj|nj|s=|z=|[a-z])");
		Matcher matcher = pattern.matcher(br.readLine());
		
		while(matcher.find())
			cnt++;
		System.out.println(cnt);
		
		br.close();
	}

}
