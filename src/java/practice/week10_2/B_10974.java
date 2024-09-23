package java.practice.week10_2;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class B_10974 {
	private static StringBuilder sb = new StringBuilder();
	private static int list[];
	private static int n, pac;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		list = new int[n];
		
		for(int i=0;i<n;i++)
			list[i] = i+1;
		
		pac = pactorial(n);
		
		for(int i=0;i<pac;i++) {
			solution(i);
			sb.append('\n');
		}
		System.out.println(sb);
		
	}
	
	private static void solution(int num) {
		if(num == 0) {
			for(int i=0;i<n;i++)
				sb.append(list[i]).append(' ');
			return;
		}
		
		int idx = -1;
		for(int i=n-1;i>0;i--)
			if(list[i] > list[i-1]) {
				idx = i-1;
				break;
			}

		int min = idx + 1;
		for(int i=n-1;i>idx;i--)
			if(list[i] > list[idx]) {
				min = i;
				break;
		}
		
		int tmp = list[idx];
		list[idx] = list[min];
		list[min] = tmp;
		
		int tmpList[] = Arrays.copyOfRange(list, idx+1, list.length);
		Arrays.sort(tmpList);
		
		for(int i=idx+1;i<n;i++)
			list[i] = tmpList[i-(idx+1)];
		
		for(int i=0;i<n;i++)
			sb.append(list[i]).append(' ');
	}
	
	private static int pactorial(int n) {
		if(n == 1) return 1;
		return n * pactorial(n-1);
	}

}
