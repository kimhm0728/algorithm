package java.practice.baekjoon;
import java.util.Scanner;

public class B_19532{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int x[]=new int[6];
        for(int i=0;i<6;i++){
            x[i]=sc.nextInt();
            if(x[i]<-999||x[i]>999)
                break;
        }
        int a=x[0];
        int b=x[1];
        int c=x[2];
        int d=x[3];
        int e=x[4];
        int f=x[5];
        int ans1, ans2;
        int temp=a*e-b*d;
        ans1=(c*e-b*f)/temp;
        ans2=(a*f-c*d)/temp;
        if((ans1>=-999&&ans1<=999)&&(ans2>=-999&&ans2<=999))
            System.out.print(ans1+" "+ans2);
        sc.close();
    }
}