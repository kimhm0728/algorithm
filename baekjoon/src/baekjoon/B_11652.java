package baekjoon;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_11652 {
	public static void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] num = new long[N];
		for(int i=0;i<N;i++)
			num[i] = Long.parseLong(br.readLine());
		Arrays.sort(num);
		
		int count = 1; // for문을 돌며 각 정수의 횟수를 저장
		int countMax = 1; // 가장 많이 가지고 있는 정수의 출현횟수
		int indexMax = 0; // 가장 많이 가지고 있는 정수의 인덱스
		for(int i=1;i<N;i++) {
			if(num[i-1] == num[i]) 
				count++;
			else 
				count = 1;
			if(countMax < count) { 
				// 현재 숫자의 count가 countMax보다 크면 countMax에 count를 대입
				indexMax = i;
				countMax = count; 
			}
			//else if(countMax == count)
			// 오름차순으로 정렬했으므로 이전 숫자보다 현재 숫자가 더 큼. 즉 index 값 변경 x
		}
		System.out.println(num[indexMax]);
	}
}