package Monde.main;

import java.util.List;
import java.util.Arrays;

public class monde2 {
    public static void main(String[] args){
        List<String> noms = Arrays.asList(args);
        for(int i=0;i<args.length;i++){
            System.out.println((i+1) + " Bonjour " + noms.get(i));
        }
    }
}
