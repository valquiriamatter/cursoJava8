package main.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Curso {

    private String nome;
    private int alunos;

    public Curso(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public int getAlunos() {
        return alunos;
    }

    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<Curso>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 55));

        cursos.sort(Comparator.comparing(c -> c.getAlunos()));
        cursos.sort(Comparator.comparing(Curso::getAlunos));

        //com method reference não tem como especificar uma impressão mais detalhada
        //cursos.forEach(System.out::println);

        cursos.forEach(c -> System.out.println(c.getNome()));

        System.out.println("");

        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .forEach(c -> System.out.println(c.getNome()));

        System.out.println("");

        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .map(Curso::getAlunos)
                .forEach(System.out::println);


        int sum = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .mapToInt(Curso::getAlunos)
                .sum();

        System.out.println(sum);


        cursos.stream()
                .filter(c -> c.getAlunos() > 50)
                .forEach(c -> System.out.println(c.getNome()));

        Stream<String> nome = cursos.stream().map(c -> c.getNome());
        Stream<String> nomes = cursos.stream().map(Curso::getNome);

        cursos.stream()
                .filter(c -> c.getAlunos() > 50)
                .map(c -> c.getAlunos())
                .forEach(x -> System.out.println(x));

        cursos.stream()
                .filter(c -> c.getAlunos() > 50)
                .map(Curso::getAlunos)
                .forEach(System.out::println);


        Optional<Curso> cursoOptional = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .findAny();

        //devolve o curso se achar, se não achar devolve uma exception
        Curso curso = cursoOptional.get();

        //devolve o curso ou null
        Curso curso2 = cursoOptional.orElse(null);
        System.out.println(curso2.getNome());

        //se existir faca, senão não faz nada
        cursoOptional.ifPresent(c -> System.out.println(c.getNome()));

        //concatenando tudo junto
        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .findAny()
                .ifPresent(c -> System.out.println(c.getNome()));

        OptionalDouble average = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .mapToInt(Curso::getAlunos)
                .average();

        //manipulando a lista original
        List<Curso> collect = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .collect(Collectors.toList());

       cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .collect(Collectors.toMap(
                        c -> c.getNome(),
                        c -> c.getAlunos()))
                .forEach((nomee, alunos) -> System.out.println(nomee + " tem " + alunos + " alunos."));
















       cursos.stream().filter(c -> c.getAlunos() > 50).findFirst();



    }


}
