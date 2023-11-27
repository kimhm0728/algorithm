package week12_3;

import java.io.*;
import java.util.regex.*;

public class B_2671 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		boolean result = Pattern.matches("(100+1+|01)+", input);
		if(result)
			System.out.println("SUBMARINE");
		else
			System.out.println("NOISE");
		
		br.close();
	}

}
