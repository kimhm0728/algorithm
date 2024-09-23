package java.practice.baekjoon;
import java.util.Scanner;

public class B_4344 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int st=sc.nextInt(); // ���̽� ��
        
        for(int i=0;i<st;i++){
            int num=sc.nextInt(); // �л� ��
            int sum=0; 
            int a=0; // ����� �Ѵ� �л� ��
            double per=0.0; // ����
            int n[]=new int[num];
            
            for(int j=0;j<num;j++){
                n[j]=sc.nextInt();
                sum+=n[j];
            }
            
            for(int g : n)
                if(g>(double)sum/num)
                    a++; // ����� �Ѵ� �л� �� ã��
            
            per=(double)a/num*100;
            
            System.out.printf("%.3f%%",per);
        }

        sc.close();
    }
}