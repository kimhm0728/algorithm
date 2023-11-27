package baekjoon;

public class B_4673 {
	static int[] num=new int[10036];
	// 0~10000 중 9999를 생성자로 가지는 10035이 가장 큰 수이므로 
	public static void main(String[] args) {
		for(int i=1;i<=10000;i++)
			num[selfNumber(i)]++;
		// 생성자의 갯수만큼 배열의 값을 가짐. 즉 셀프 넘버는 값이 0
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
