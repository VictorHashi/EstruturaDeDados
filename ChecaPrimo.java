package Exercícios1302;

import java.util.Scanner;

import static java.lang.Math.*;

public class ChecaPrimo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.printf("Primo?");
        int num = scan.nextInt();
        boolean primo = true;
        if(num < 2) {
            primo = false;
        }else{
            for (int i = 2; i <= sqrt(num); i++) {
                if (num % i == 0){
                    primo = false;
                    break;
                }
            }
        }
        if (primo){
            System.out.printf("Primo");
        }else {
            System.out.printf("Não primo");
        }
    }

}
