package backTracking;

import java.io.*;

public class B_2661 {
	static int N;
	static String[] arr = {"1", "2", "3"};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		DFS(1, new StringBuilder("1"), "1");
	}
	
	static void DFS(int depth, StringBuilder sb, String pre) {
		if(depth == N) {
			System.out.println(sb);
			System.exit(0);
		}
		
		for(int i=0;i<3;i++) {			
			if(pre.equals(arr[i]))
				continue;
			sb.append(arr[i]);
			int len = sb.length();
			
			if(check(sb.toString(), len)) {
				DFS(depth + 1, sb, arr[i]);
				sb.setLength(len - 1);
			}
			else
				sb.setLength(len - 1);
		}
	}
	
	static boolean check(String str, int len) {
		for(int i=len/2;i>=2;i--) {
			if(str.substring(len - i - i, len - i).equals(str.substring(len - i, len)))
					return false;
		}
		return true;
	}

}
