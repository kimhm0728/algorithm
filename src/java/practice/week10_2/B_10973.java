package java.practice.week10_2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_10973 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int idx = -1;
		for(int i=n-1;i>0;i--)
			if(arr[i] < arr[i-1]) {
				idx = i-1;
				break;
			}

		if(idx == -1) {
			System.out.println(-1);
			return;
		}

		for(int i=n-1;i>idx;i--)
			if(arr[idx] > arr[i]) {
				int tmp = arr[idx];
				arr[idx] = arr[i];
				arr[i] = tmp;
				break;
			}

		for(int i=0;i<=idx;i++)
			sb.append(arr[i]).append(' ');

		int tmpArr[] = Arrays.copyOfRange(arr, idx+1, n);
		Arrays.sort(tmpArr);

		for(int i=tmpArr.length-1;i>=0;i--)
			sb.append(tmpArr[i]).append(' ');

		System.out.println(sb);
	}

}
