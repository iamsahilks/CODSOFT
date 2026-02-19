package NumberGame;

import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        int count=50;
        int score=100;
        int min=1;
        int max=100;
        int x= (int)(Math.random()*((max-min)+1))+min;
        System.out.println("Enter the Number Between 1 to 100 : ");

        Scanner in =new Scanner(System.in);
        int y=in.nextInt();

        if(y<0  || y>100){
            System.out.println("Please enter valid Number ");
        }
        Guess(y,count,x,score);
        System.out.println("Game Over");
        System.out.println("do you want to play more");
        Scanner inter =new Scanner(System.in);
        boolean z=inter.nextBoolean();
        while(z){
            x= (int)(Math.random()*((max-min)+1))+min;
            Guess(y,count,x,score);
        }

    }
    static void Guess(int number,int count,int x,int score){

        if(count==0){
            return;
        }
        if(number==x){
            System.out.println("Your guess is correct");
            System.out.println("your Score is :"+ score);
        }else{
            if(x>number){
                System.out.println("your guess is incorrect & smaller");
            }
            if(x<number){
                System.out.println("your guess is incorrect & larger");
            }
            System.out.println("Guess new Number");

            Scanner in =new Scanner(System.in);
            score--;
            int z=in.nextInt();

            count--;
            Guess(z,count,x,score);


        }
    }
}
