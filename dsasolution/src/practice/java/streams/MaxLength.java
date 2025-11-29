package practice.java.streams;

import java.util.Arrays;
import java.util.Comparator;

public class MaxLength {

    public static void main(String[] args) {

        String s = "I am learning stream API in Java";

        // Highest length
        System.out.println(Arrays.stream(s.split(" ")).max(Comparator.comparing(String::length)).get());

        s = "dabcadefg";
        // Remove duplicates
        Arrays.stream(s.split("")).distinct().forEach(System.out::print);

        System.out.println();

        // Second highest length
        s = "I am learning stream API in Java";
        System.out.println(Arrays.stream(s.split(" ")).sorted(Comparator.comparing(String::length).reversed()).skip(1).limit(1).findFirst().get());

    }

}
