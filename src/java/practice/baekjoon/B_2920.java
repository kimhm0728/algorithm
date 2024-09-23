package java.practice.baekjoon;
import java.io.*;

public class B_2920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String scale = br.readLine();
		scale = scale.replaceAll(" ", "");
		
		if(scale.equals("12345678"))
			System.out.println("ascending");
		else if(scale.equals("87654321"))
			System.out.println("descending");
		else
			System.out.println("mixed");
	}

}
