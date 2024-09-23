package java.practice.baekjoon;

public class B_4673 {
	static int[] num=new int[10036];
	// 0~10000 �� 9999�� �����ڷ� ������ 10035�� ���� ū ���̹Ƿ� 
	public static void main(String[] args) {
		for(int i=1;i<=10000;i++)
			num[selfNumber(i)]++;
		// �������� ������ŭ �迭�� ���� ����. �� ���� �ѹ��� ���� 0
		for(int i=1;i<=10000;i++)
			if(num[i] == 0)
				System.out.println(i);
	}
	static int selfNumber(int n) {
		int result = n;
		for(int i=4;i>=0;i--) {
			result += n / Math.pow(10, i);
			n %= Math.pow(10, i);
		}
		return result;
	}
}
