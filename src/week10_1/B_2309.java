package week10_1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class B_2309 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int arr[] = new int[9];
		
		int sum = 0;
		
		for(int i=0;i<9;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		loop:
		for(int i=0;i<9;i++) 
			for(int j=1;j<8;j++) {
					if(sum - arr[i] - arr[j] == 100) {
						arr[i] = 0;
						arr[j] = 0;
						break loop;
					}
			}
		
		Arrays.sort(arr);
		for(int i=2;i<9;i++)
			sb.append(arr[i]).append('\n');
		
		System.out.println(sb);
			
	}

}
