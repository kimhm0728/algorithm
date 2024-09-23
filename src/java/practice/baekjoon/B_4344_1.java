package java.practice.baekjoon;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_4344_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine()); // ���̽��� ����
		StringTokenizer st;
		int[] grade;
		
		for(int i=0;i<C;i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // ���̽� �� �л��� ��
			int sum = 0;
			grade = new int[N];
			for(int j=0;j<N;j++) {
				grade[j] = Integer.parseInt(st.nextToken());
				sum += grade[j];
			}
			double avg = (double)sum / N;
			int count = 0; // ��պ��� ������ ���� �л� �� ī��Ʈ
			for(int j=0;j<N;j++)
				if(grade[j] > avg)
					count++;
			System.out.printf("%.3f%%\n", ((double)count/N)*100);
		}
	}
}