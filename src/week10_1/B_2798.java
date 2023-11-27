package week10_1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B_2798 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int max = -1;
		for(int i=0;i<n-2;i++)
			for(int j=1;j<n-1;j++)
				for(int k=2;k<n;k++) {
					int tmp = arr[i] + arr[j] + arr[k];
					if(max < tmp && tmp <= m && i != j && j !=k && i != k)
						max = tmp;
				}
		
		System.out.println(max);
	}

}
