package main.java;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalUnit;
import java.util.Locale;

public class Datas {

    public static void main(String[] args) {

        //pega a data atual
        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);

        //setando uma data
        LocalDate meuNascimento = LocalDate.of(2022, Month.JULY, 9);

        //pegando a diferenca em anos
        int anos = meuNascimento.getYear() - hoje.getYear();
        System.out.println(anos);

        //pegando um periodo
        Period periodo = Period.between(hoje, meuNascimento);
        System.out.println(periodo.getYears());

        System.out.println("Meu aniversário será num(a) " + meuNascimento.plusYears(1).getDayOfWeek() + " no próximo ano");

        //criando um formatador
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(hoje.format(dateTimeFormatter));

        DateTimeFormatter dateTimeFormatterHora = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");

        LocalDateTime agora = LocalDateTime.now();
        System.out.println(agora.format(dateTimeFormatterHora));



    }

}
