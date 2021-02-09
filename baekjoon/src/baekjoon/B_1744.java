package baekjoon;
import java.util.*;

public class B_1744 {
	public static void main(String[] args) {
		Scanner stdin=new Scanner(System.in);
		int n=stdin.nextInt();
		int []array=new int[n];
		
		for(int i=0;i<n;i++)
			array[i]=stdin.nextInt();
		stdin.close();
		Arrays.sort(array);

		int start=0, end=n-1;
		int sum=0;
		
		for(;start<end;start+=2) { // 음수인 경우
			if(array[start]<1 && array[start+1]<1)
				sum+=array[start]*array[start+1];
			else break;
		}
		
		for(;end>0;end-=2) { // 1보다 큰 경우
			if(array[end]>1 && array[end-1]>1)
				sum+=array[end]*array[end-1];
			else break;
		}
		
		for(;start<=end;end--) // 1이거나 위의 경우에 해당되지 않는 경우
			sum+=array[end];
		System.out.println(sum);
	}

}
