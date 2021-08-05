package baekjoon;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_4344_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine()); // 케이스의 개수
		StringTokenizer st;
		int[] grade;
		
		for(int i=0;i<C;i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 케이스 별 학생의 수
			int sum = 0;
			grade = new int[N];
			for(int j=0;j<N;j++) {
				grade[j] = Integer.parseInt(st.nextToken());
				sum += grade[j];
			}
			double avg = (double)sum / N;
			int count = 0; // 평균보다 성적이 높은 학생 수 카운트
			for(int j=0;j<N;j++)
				if(grade[j] > avg)
					count++;
			System.out.printf("%.3f%%\n", ((double)count/N)*100);
		}
	}
}