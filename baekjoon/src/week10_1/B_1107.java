package week10_1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B_1107 {
	static boolean[] broken = new boolean[10]; // 고장난 버튼
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 이동하려는 채널
		int M = Integer.parseInt(br.readLine()); 

		if(M != 0) {
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++)
				broken[Integer.parseInt(st.nextToken())] = true;
		}
		int min = Math.abs(N - 100); // + 또는 -로 이동하는 경우로 초기화
		boolean flag;
		
		for(int i=0;i<=999999;i++) {
			flag = false;
			String strI = String.valueOf(i);
			
			for(int j=0;j<strI.length();j++)
				if(broken[strI.charAt(j)-'0']) {
					flag = true;
					break;
				}
			
			if(!flag)
				min = Math.min(min, Math.abs(N - i) + strI.length()); 
			
		}
		
		System.out.println(min);
		
	}
	
}
