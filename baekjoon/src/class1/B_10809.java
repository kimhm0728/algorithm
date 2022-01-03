package class1;
import java.io.*;
import java.util.Arrays;

public class B_10809 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		int[] alpha = new int[26];
		Arrays.fill(alpha, -1);

		for(int i=0;i<word.length();i++) 
			if(alpha[word.charAt(i)-97] == -1)
				alpha[word.charAt(i)-97] = i;
		
		for(int i=0;i<26;i++)
			System.out.print(alpha[i] + " ");
	}

}
