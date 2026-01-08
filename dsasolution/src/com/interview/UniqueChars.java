package com.interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class UniqueChars {

    public static void main(String[] args) {

        String value = "dddfvbbterrrsssgghd";
        String output = "dfvbtersghd";

        StringBuilder sb = new StringBuilder();

        char prevChar = 0;

        for(char ch: value.toCharArray() ) {
            if(ch != prevChar) {
                sb.append(ch);
            }
            prevChar = ch;
        }

        System.out.println(sb.toString());

    }

}
