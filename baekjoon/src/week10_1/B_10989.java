package week10_1;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class B_10989 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[10000];
		
		for(int i=0;i<n;i++)
			arr[Integer.parseInt(br.readLine())-1]++;
		
		for(int i=0;i<arr.length;i++)
			if(arr[i]==0)
				continue;
			else 
				for(int j=0;j<arr[i];j++)
					sb.append(i+1).append('\n');
		System.out.println(sb);
	}
}
