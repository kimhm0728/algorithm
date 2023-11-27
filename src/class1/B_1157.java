package class1;
import java.util.Scanner;

public class B_1157 {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		String str = stdin.next();
		stdin.close();
		str = str.toUpperCase(); // 모든 알파벳을 대문자로 전환
		
		int []array = new int[26]; // 알파벳 26개의 출현 갯수를 저장할 배열
		for(int i=0;i<str.length();i++) {
			int index = str.charAt(i)-'A'; // A가 array[0]에 대응할 수 있도록
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
