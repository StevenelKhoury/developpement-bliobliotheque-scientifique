package Exercice2.main;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class Monde {
    public static void main(String[] args){
        List<String> noms = Arrays.asList(args);
        Scanner scanner = new Scanner (System.in);
        String nom= scanner.nextLine();
        for(int i=0;i<args.length;i++){
            System.out.println((i+1) + " Bonjour " + noms.get(i));
        }
    }
}