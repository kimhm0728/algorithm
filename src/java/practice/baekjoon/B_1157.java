package java.practice.baekjoon;
import java.util.Scanner;

public class B_1157 {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		String str = stdin.next();
		stdin.close();
		str = str.toUpperCase(); // ��� ���ĺ��� �빮�ڷ� ��ȯ
		
		int []array = new int[26]; // ���ĺ� 26���� ���� ������ ������ �迭
		for(int i=0;i<str.length();i++) {
			int index = str.charAt(i)-'A'; // A�� array[0]�� ������ �� �ֵ���
			array[index]++;
		}

		int max=0;
		int max_index = 0;
		for(int i=0;i<array.length;i++) {
			if(array[i] > max) {
				max=array[i];
				max_index=i;
			}
			else if(array[i]==max && max!=0) {
				max_index=-1;
			}
		}
		if(max_index<0) 
			System.out.println('?');
		else
			System.out.println((char)(max_index+'A'));
	}

}
