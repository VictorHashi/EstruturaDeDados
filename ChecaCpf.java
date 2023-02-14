package Exercícios1302;

import java.util.Scanner;

public class ChecaCpf {

    public static void main(String[] args) {

        System.out.println("CPF:");
        Scanner scan = new Scanner(System.in);
        String cpf = scan.next();
        boolean valid = true;
        if(!checaString(cpf))
            valid = false;

        if(!checaNumerico(cpf))
            valid = false;

        if(!valid){
            System.out.println("Inválido");
        }else if (checaValor(cpf)){
            System.out.println("CPF Válido");
        }else {
            System.out.println("Dígito verificador inválido(s)");
        }
        
    }

    public static boolean checaString(String cpf) {

        if (cpf.length() != 14) {
            return false;
        }

        if (cpf.charAt(3) != '.'
            || cpf.charAt(7) != '.'
            || cpf.charAt(11) != '-') {
            return false;
        }

        return true;
    }
    public static boolean checaValor(String cpf) {

        String aux = cpf.replaceAll("\\p{Punct}", "");
        int firstSum = 0;
        int secondSum = 0;

        for (int i = 0; i < 9; i++) {
            firstSum += Character.getNumericValue(aux.charAt(i)) * (10 - i);
            secondSum += Character.getNumericValue(aux.charAt(i)) * (11 - i);
        }

        secondSum += (Character.getNumericValue(cpf.charAt(12)) * 2);

        if ((11 - (firstSum % 11) == Character.getNumericValue(cpf.charAt(12)))
        && (11 - (secondSum % 11) == Character.getNumericValue(cpf.charAt(13))))
            return true;

        return false;
    }

    public static boolean checaNumerico(String cpf){

        if(!cpf.substring(0,2).matches("[0-9]*")
        || !cpf.substring(4,6).matches("[0-9]*")
        || !cpf.substring(8,10).matches("[0-9]*")
        || !cpf.substring(12,13).matches("[0-9]*"))
            return false;

        return true;
    }

}


