package week10_1;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class B_9093 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			String[] arr = new String[st.countTokens()];
			
			int j = 0;
			while(st.hasMoreTokens())
				arr[j++] = st.nextToken();
			
			for(int k=0;k<arr.length;k++) 
				sb.append(wordReverse(arr[k])).append(' ');

			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	private static String wordReverse(String str) {
		for(int i=0;i<str.length()/2;i++) {
			char[] chars = str.toCharArray();
			char tmp = chars[i];
			chars[i] = str.charAt(str.length() - i - 1);
			chars[str.length() - i - 1] = tmp;
			str = String.valueOf(chars);
		} 
		return str;
	}

}
