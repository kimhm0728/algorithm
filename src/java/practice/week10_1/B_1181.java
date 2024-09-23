package java.practice.week10_1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class B_1181 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		for(int i=0;i<n;i++) 
			arr[i] = br.readLine();
		
		Arrays.sort(arr, (s1, s2) -> {
			if(s1.length() == s2.length())
				return s1.compareTo(s2);
			else
				return s1.length() - s2.length();
		});
		
		String tmp = "";
		for(int i=0;i<n;i++) {
			if(tmp.equals(arr[i]))
				continue;
			sb.append(arr[i]+'\n');
			tmp = arr[i];
		}

		System.out.println(sb);
	}

}
