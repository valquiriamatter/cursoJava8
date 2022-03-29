package main.java;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class OrdenaStrings {
    public static void main(String[] args) {

        List<String> palavras = new ArrayList<>();
        palavras.add("alura online");
        palavras.add("editora");
        palavras.add("caelum");

        Collections.sort(palavras);
        System.out.println(palavras);

        palavras.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {

                //se o primeiro elemento for vim antes do segundo elemento vc devolve negativo
                if(s1.length() < s2.length()) return -1;

                //se o primeiro elemento for vim depois do segundo elemento vc devolve positivo
                if(s1.length() > s2.length()) return 1;

                //se for igual retorna 0
                return 0;
            }
        });

        System.out.println(palavras);

        for (String p : palavras) {
            System.out.println(p);
        }

        // com a variável local
        Consumer<String> consumidor = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        // dando o new direto
        palavras.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });



        //usando lambdas
        palavras.forEach(s -> System.out.println(s));



        Function<String, Integer> funcao = s -> s.length();
        Function<String, Integer> funcao2 = String::length;

        Comparator<String> comparator = Comparator.comparing(funcao);

        Consumer<String> impressor = System.out::println;

        palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));


                                            //dado um objeto //invoque um método
        palavras.sort(Comparator.comparing(s -> s.length()));


                                     //quero invocar o metodo lenght da String
        palavras.sort(Comparator.comparingInt(String::length));




        palavras.forEach(s -> System.out.println(s));

        new Thread(()-> System.out.println("Executando um Runnable")).start();

        palavras.forEach(System.out::println);


        palavras.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println(palavras);





    }
}


