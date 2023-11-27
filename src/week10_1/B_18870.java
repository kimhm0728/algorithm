package week10_1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B_18870 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] sort = new int[n];
		HashMap<Integer, Integer> map = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			int value = Integer.parseInt(st.nextToken());
			arr[i] = value;
			sort[i] = value;
		}
		
		Arrays.sort(sort);
		
		int cnt = 0;
		
		for(int v : sort) 
			if(!map.containsKey(v))
				map.put(v, cnt++);
			
		for(int i=0;i<n;i++)
			sb.append(map.get(arr[i])+" ");

		System.out.println(sb);
		
	}

}
