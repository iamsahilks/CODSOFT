package GradeCalculator;

import java.util.Scanner;

public class GradeCalculator {
    static void  FindGrade(int[] marks ,int n){
        int totalmark=0;
        for (int i = 0; i <n; i++) {
            totalmark+=marks[i];
        }
        float percentage=(totalmark/n);
        int p=(int)(percentage);
        String Grade;
        if(p>=90 && p<=100){
            Grade="A";
        } else if (p>=80 && p<90) {
            Grade="B";
        }
        else if (p>=70 && p<80) {
            Grade="C";
        }
        else if (p>=60 && p<70) {
            Grade="D";
        }else{
            Grade="E";
        }
        display(totalmark,percentage,Grade);
    }
    static void display(int totalmark,Float percentage,String Grade){
        System.out.println("Total Marks obtained : "+totalmark);
        System.out.println("Average percentage : "+ percentage);
        System.out.println("Grade : "+ Grade );
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Enter number of Subject : ");
        int n=in.nextInt();
        int[] marks = new int[n];
        System.out.println("Enter marks : ");
        for (int i = 0; i <n ; i++) {
            int c=in.nextInt();
            if(c>100 ||c<0){
                System.out.println("Enter valid input");
            }else {
                marks[i] = c;
            }
        }
        FindGrade(marks,n);



    }

}
