package com.github.alexkovalenko.sieveoferatosthenes;

import java.util.ArrayList;
import java.util.List;

public class SieveOfEratosthenes {

    public List<Integer> primes(int n) {
        boolean[] marks = prepareMarks(n);
        unmarkNotPrimes(n, marks);
        return getMarkedPrimes(marks);
    }

    private boolean[] prepareMarks(int n) {
        boolean[] marks = new boolean[n];
        for (int i = 0; i < n; i++) {
            marks[i] = true;
        }
        return marks;
    }

    private void unmarkNotPrimes(int n, boolean[] marks) {
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (marks[i]) {
                for (int j = (i * i); j < n; j = j + i) {
                    marks[j] = false;
                }
            }
        }
    }

    private List<Integer> getMarkedPrimes(boolean[] marks) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 0; i < marks.length; i++) {
            if (marks[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        SieveOfEratosthenes sieveOfEratosthenes = new SieveOfEratosthenes();
        System.out.println(sieveOfEratosthenes.primes(500000000));
    }
}
