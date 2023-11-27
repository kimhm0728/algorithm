package baekjoon;
import java.util.Scanner;

public class B_4344 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int st=sc.nextInt(); // 케이스 수
        
        for(int i=0;i<st;i++){
            int num=sc.nextInt(); // 학생 수
            int sum=0; 
            int a=0; // 평균을 넘는 학생 수
            double per=0.0; // 비율
            int n[]=new int[num];
            
            for(int j=0;j<num;j++){
                n[j]=sc.nextInt();
                sum+=n[j];
            }
            
            for(int g : n)
                if(g>(double)sum/num)
                    a++; // 평균이 넘는 학생 수 찾기
            
            per=(double)a/num*100;
            
            System.out.printf("%.3f%%",per);
        }

        sc.close();
    }
}