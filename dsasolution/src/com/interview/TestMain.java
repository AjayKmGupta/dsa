package com.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestMain {

    public static void main(String[] args) {

        int val1 = returnM();
        System.out.println(val1);

        int[] array = {2, 2, 1, 4, 4, 1, 3};

        int val = 0;

        for(int arrVal: array) {
            val = val ^ arrVal;
        }

        System.out.println(val);

        int[] start = {3, 0, 1, 5, 8, 5};
        int[] end = {4, 6, 2, 7, 9, 9};
        List<Job> jobs = new ArrayList<>();

        for (int i = 0; i < start.length; i++) {
            jobs.add(new Job(start[i], end[i], i ));
        }

        jobs.sort(Comparator.comparingInt(j -> j.end));

        List<Integer> selected = new ArrayList<>();
        int lastEnd = -1;

        for(Job job: jobs) {
            if(job.start >= lastEnd ) {
                selected.add(job.index);
                lastEnd = job.end;
            }
        }

        System.out.println(selected);

    }

    static class Job {
        int start;
        int end;
        int index; // original index

        Job(int s, int e, int idx) {
            start = s;
            end = e;
            index = idx;
        }
    }


    static int returnM() {
        try {
            System.out.println("Test");
            return 5;
        } finally {
            System.out.println("Hello");
            return 6;
        }
    }

}
