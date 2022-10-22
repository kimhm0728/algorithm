package week10_2;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_10972 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int list[] = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++)
			list[i] = Integer.parseInt(st.nextToken());
		
		int idx = -1;
		for(int i=n-1;i>0;i--)
			if(list[i] > list[i-1]) {
				idx = i-1;
				break;
			}
		
		if(idx == -1) {
			System.out.println(-1);
			return;
		}
		
		int min = 10001;
		int minIdx = idx+1;
		for(int i=idx+1;i<n;i++)
			if(list[i] > list[idx] && min > list[i]) {
				min = list[i];
				minIdx = i;
		}
		
		int tmp = list[idx];
		list[idx] = min;
		list[minIdx] = tmp;
		
		for(int i=0;i<=idx;i++)
			sb.append(list[i]).append(' ');
		
		int tmpList[] = Arrays.copyOfRange(list, idx+1, list.length);
		Arrays.sort(tmpList);
		
		for(int i=0;i<tmpList.length;i++)
			sb.append(tmpList[i]).append(' ');
		
		System.out.println(sb);
		
	}

}
