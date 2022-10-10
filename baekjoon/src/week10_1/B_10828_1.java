package week10_1;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class B_10828_1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int size = 0;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			
			switch(st.nextToken()) {
			case "push":
				arr[size++] = Integer.parseInt(st.nextToken());
				break;
			case "pop":
				if(size != 0) 
					sb.append(arr[--size]).append('\n');
				else
					sb.append("-1").append('\n');
				break;
			case "size":
				sb.append(size).append('\n');
				break;
			case "empty":
				if(size == 0)
					sb.append('1').append('\n');
				else
					sb.append('0').append('\n');
				break;
			case "top":
				if(size != 0)
					sb.append(arr[size-1]).append('\n');
				else
					sb.append("-1").append('\n');
				break;
			}
		}
		System.out.println(sb);
	}

}
