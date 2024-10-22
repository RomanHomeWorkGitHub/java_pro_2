package com.example.java_pro_2.service;

import com.example.java_pro_2.dto.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiService {
    public static List<?> removingAllDuplicates(List<?> list) {
        return list.stream()
                .distinct()
                .toList();
    }

    public static Integer thirdLargestNumber(List<Integer> list) {
        return list.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .skip(2)
                .findFirst().get();
    }

    public static Integer thirdLargestUniqueNumber(List<Integer> list) {
        return list.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .skip(2)
                .findFirst().get();
    }

    public static Integer thirdLargestUniqueNumber2(List<Integer> list) {
        return thirdLargestUniqueNumber((List<Integer>) removingAllDuplicates(list));
    }

    public static List<String> listNamesEmployeesEngineer(List<Employee> list) {
        return list.stream()
                .sorted(Comparator.comparing(Employee::getAge).reversed())
                .filter(employee -> "Инженер".equals(employee.getFunction()))
                .limit(3)
                .map(Employee::getName)
                .toList();
    }

    public static Double calculateAgeEmployeesEngineer(List<Employee> list) {
        return list.stream()
                .filter(employee -> "Инженер".equals(employee.getFunction()))
                .map(Employee::getAge)
                .mapToInt(a -> a)
                .average()
                .getAsDouble();
    }

    public static String longestWord(List<String> list) {
        return list.stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .findFirst()
                .get();
    }

    public static HashMap<String, Integer> createHashMapStrings(String string) {
        return (HashMap<String, Integer>) Arrays.stream(string.split(" "))
                .collect(Collectors.toMap(k -> k, v -> 1, (oldValue, newValue) -> oldValue + 1));
    }

    public static void printListString(List<String> list) {
        list.stream()
                .sorted(Comparator.comparing(String::length).thenComparing(String::compareTo))
                .forEach(System.out::println);
    }

    public static String longestWordArrayStrings(String[] arr) {
        return Arrays.stream(arr)
                .map(s -> s.split(" "))
                .flatMap(Arrays::stream)
                .sorted(Comparator.comparing(String::length).reversed())
                .findFirst()
                .get();
    }
}
