package class2;
import java.io.*;

public class B_1259 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		A: while(true) {
			String input = br.readLine();
			
			if(input.equals("0"))
				break;
			
			for(int i=0;i<input.length()/2;i++) {
				if(input.charAt(i) != input.charAt(input.length()-1-i)) {
					sb.append("no");
					sb.append("\n");
					continue A;
				}
			}
			sb.append("yes");
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
