package baekjoon;
import java.util.Scanner;

public class B_10950 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
/*        int num[][]=new int[n][2];
        for(int i=0;i<n;i++)
            for(int j=0;j<2;j++)
                num[i][j]=sc.nextInt();
        
        for(int i=0;i<n;i++){
            int a=0;
            for(int j=0;j<2;j++)
                a+=num[i][j];
            System.out.println(a);
        }
*/        

        for(int i=0;i<n;i++) {
        	int A=sc.nextInt();
        	int B=sc.nextInt();
        	
        	System.out.println(A+B);
        }
        sc.close();
    }
}