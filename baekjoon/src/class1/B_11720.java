package class1;
import java.util.*;

public class B_11720 {
	public static void main(String []args) {
		Scanner stdin=new Scanner(System.in);
		int n=stdin.nextInt();
//		if(n<1  || n>100) System.exit(0);
		String[] array=new String[n];
		
		String str=stdin.next();
		array=str.split("");
		int sum=0;
		
		for(int i=0;i<n;i++) 
			sum+=Integer.parseInt(array[i]);

		System.out.println(sum);
		stdin.close();
	}
}