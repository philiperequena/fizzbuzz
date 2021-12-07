package com.philiperequena.fizzbuzz.utils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FizzBuzzResolver {

    public static List<String> solveProblem(List<Integer> listNumbers) {
        return listNumbers.stream().map(FizzBuzzResolver::solveNumber).filter(Objects::nonNull).collect(Collectors.toList());
    }

    private static String solveNumber(Integer number) {
        if ((number % 3) == 0) {
            if ((number % 5) == 0) {
                return "fizzbuzz";
            } else {
                return "fizz";
            }
        } else if ((number % 5) == 0) {
            return "buzz";
        }
        return null;
    }

}
