package baekjoon;
import java.util.Scanner;

public class B_2475 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=0;
        for(int i=0;i<5;i++)
            n+=Math.pow(sc.nextInt(),2);
        System.out.println(n%10);
        
        sc.close();
    }
}
