package java.practice.baekjoon;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class B_1107 {
	static int[] button = new int[10]; // ���峵���� �Ǵ�
	static int N; // ������ ä��
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
				// ���峭 ��ư�� 1�� ����
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
		if(minButton(0) != -1) { // ���峪�� ���� ��ư�� �ϳ��� �ִٸ� ����
			for(int i=0;i<len;i++) { // Case 1
				int num = strN.charAt(i) - '0';
				if(button[num] == 0) // ���峪�� �ʾ����� ������
					str += num;
				else  // ���峵�ٸ� ���峪�� ���� ��ư �� �� ��ư�� ���� ����� ��ư�� ������
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
	static int minButton(int n) { // ���峪�� ���� ��ư �߿� n�� ���� ���̰� ���� ��ư ã��
		int min = 10;
		int index = -1;
		for(int i=0;i<button.length;i++) {
			if(button[i] == 0 && Math.abs(n - i) < min) {
				min = n - i; 
				index = i;
			}
		}
		// index�� -1�̶�� if���� �ѹ��̶� �������� ���� ��. �� ��ư ��� ����
		return index;
	}
}
