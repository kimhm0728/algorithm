package week10_3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B_11723 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		boolean[] arr = new boolean[21]; // 0은 무시. 1~20 사용
		
		int M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int n;
			
			switch(str) {
			case "add":
				n = Integer.parseInt(st.nextToken());
				arr[n] = true;
				break;
			case "remove":
				n = Integer.parseInt(st.nextToken());
				arr[n] = false;
				break;
			case "check":
				n = Integer.parseInt(st.nextToken());
				sb.append(arr[n] ? 1 : 0).append('\n');
				break;
			case "toggle":
				n = Integer.parseInt(st.nextToken());
				arr[n] = arr[n] ? false : true;
				break;
			case "all":
				for(int j=1;j<21;j++)
					arr[j] = true;
				break;
			case "empty":
				for(int j=1;j<21;j++)
					arr[j] = false;
				break;
			}
		}
		
		System.out.println(sb);
	}

}
