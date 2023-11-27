package class1;
import java.io.*;

public class B_8958 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			String quiz = br.readLine();
			int score = 0;
			int cnt = 0;
			for(int j=0;j<quiz.length();j++) {
				if(quiz.charAt(j) == 'O') {
					score += ++cnt;
				}
				else
					cnt = 0;
			}
			System.out.println(score);
		}
	}

}
