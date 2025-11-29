package com.interview.dp;

import java.io.*;
import java.util.List;
public class Solution {

    public static void main(String[] args) throws IOException {

        List<Long> result = Result.waysToChooseSum(1, 200);

        result.stream().forEach(System.out::println);
    }

}
