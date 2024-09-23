package java.practice.baekjoon;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class B_1181 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String word[] = new String[n];
		
		for(int i=0;i<n;i++) 
			word[i] = br.readLine();
		
		Arrays.sort(word, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) 
					return s1.compareTo(s2); // ���̰� ���� ��� ���� �� ����
				else // ���� ���� ����
					return s1.length() - s2.length();
			}
		});
		
		for(int i=0;i<n;i++) {
			if(i == 0)
				System.out.println(word[i]);
			else {
				if(word[i].equals(word[i-1])) 
					// �ܾ �� �� �ܾ�� ������ ������� �ʰ� �Ѿ
					continue;
				else 
					System.out.println(word[i]);
			}
		}
	
	}

}
