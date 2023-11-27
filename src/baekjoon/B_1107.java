package baekjoon;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class B_1107 {
	static int[] button = new int[10]; // 고장났는지 판단
	static int N; // 가야할 채널
	static int ans = Integer.MAX_VALUE, len;
	static String strN;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		strN = Integer.toString(N);
		len = strN.length();
		if(M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++)
				// 고장난 버튼을 1로 설정
				button[Integer.parseInt(st.nextToken())] = 1;
		}
		if(N == 100)
			System.out.println(0);
		else {
			int tmp = remote(N);
			if(tmp < ans)
				System.out.println(tmp);
		} 
	}
	static int remote(int n) {
		int cnt = 0;
		String str = "";
		String strN = Integer.toString(N);
		int len = strN.length();
		if(minButton(0) != -1) { // 고장나지 않은 버튼이 하나라도 있다면 실행
			for(int i=0;i<len;i++) { // Case 1
				int num = strN.charAt(i) - '0';
				if(button[num] == 0) // 고장나지 않았으면 누르기
					str += num;
				else  // 고장났다면 고장나지 않은 버튼 중 그 버튼과 가장 가까운 버튼을 누르기
					str += minButton(num);
			} 
			if(str.equals(strN)) // Case 1-1
				cnt = len;
			else // Case 1-2
				cnt = len + Math.abs(Integer.parseInt(str) - N);
		}
		if(cnt > Math.abs(N - 100)) // Case 2
			cnt = Math.abs(N - 100);
		return cnt;
	}
	static int minButton(int n) { // 고장나지 않은 버튼 중에 n과 가장 차이가 적은 버튼 찾기
		int min = 10;
		int index = -1;
		for(int i=0;i<button.length;i++) {
			if(button[i] == 0 && Math.abs(n - i) < min) {
				min = n - i; 
				index = i;
			}
		}
		// index가 -1이라면 if문을 한번이라도 만족하지 않은 것. 즉 버튼 모두 고장
		return index;
	}
}
