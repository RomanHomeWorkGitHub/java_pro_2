package com.example.java_pro_2.service;

import com.example.java_pro_2.dto.Employee;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.example.java_pro_2.service.StreamApiService.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class StreamApiServiceTest {

    List<Integer> list = List.of(5, 2, 10, 9, 4, 3, 10, 1, 13);
    List<String> listStr = List.of("asss", "sss", "qwer", "zxcvt", "asss", "bsss", "sss", "qaz", "asss", "qwer", "iwer");
    String[] arrStr = new String[]
            {"asss sss qwer zxcvt asss",
            "ssqqs qaz asss qwer asdfg",
            "sqss qasdwz assqqs qqqwer asdfg",
            "sss qasdz asssds qsdwer asdfg",
            "ssfes qawwqz aqwersss qwe1wer asdfg"};

    List<Employee> employeeList = List.of(
            new Employee("Александр", 44, "Лоботряс"),
                new Employee("Захар", 33, "Инженер"),
                new Employee("Мефодий", 22, "Врач"),
                new Employee("Иннокентий", 88, "Лоботряс"),
                new Employee("Гаврила", 66, "Инженер"),
                new Employee("Иннокентий", 99, "Инженер"),
                new Employee("Аркадий", 55, "Инженер"),
                new Employee("Галина", 66, "Лоботряс"),
                new Employee("Феофан", 77, "Программист")
        );

    @Test
    void removingAllDuplicatesTest() {
        System.out.println(list);
        List<?> resList = removingAllDuplicates(list);
        assertNotEquals(list.size(), resList.size());
        System.out.println(resList);
    }

    @Test
    void removingAllDuplicatesStringTest() {
        System.out.println(listStr);
        List<?> resList = removingAllDuplicates(list);
        assertNotEquals(list.size(), resList.size());
        System.out.println(resList);
    }

    @Test
    void thirdLargestNumberTest() {
        System.out.println(list);
        Integer res = thirdLargestNumber(list);
        assertEquals(10, res);
        System.out.println(res);
    }

    @Test
    void thirdLargestUniqueNumberTest() {
        System.out.println(list);
        Integer res = thirdLargestUniqueNumber(list);
        assertEquals(9, res);
        System.out.println(res);
    }

    @Test
    void thirdLargestUniqueNumber2Test() {
        System.out.println(list);
        Integer res = thirdLargestUniqueNumber2(list);
        assertEquals(9, res);
        System.out.println(res);
    }

    @Test
    void listNamesEmployeesEngineerTest() {
        employeeList.stream()
                .filter(e -> ("Инженер".equals(e.getFunction())))
                .forEach(System.out::println);
        List<String> res = listNamesEmployeesEngineer(employeeList);
        assertEquals(3, res.size());
        System.out.println(res);
    }

    @Test
    void calculateAgeEmployeesEngineerTest() {
        employeeList.stream()
                .filter(e -> ("Инженер".equals(e.getFunction())))
                .map(Employee::getAge)
                .forEach(System.out::println);
        Double res = calculateAgeEmployeesEngineer(employeeList);
        assertEquals(63.25, res);
        System.out.println(res);
    }

    @Test
    void longestWordTest() {
        System.out.println(listStr);
        String res = longestWord(listStr);
        assertEquals("zxcvt", res);
        System.out.println(res);
    }

    @Test
    void createHashMapStringsTest() {
        String str = "asss sss aasss asss asss sss assss";
        System.out.println(str);
        HashMap<String, Integer> map = createHashMapStrings(str);
        assertEquals(1, map.get("aasss"));
        assertEquals(1, map.get("assss"));
        assertEquals(2, map.get("sss"));
        assertEquals(3, map.get("asss"));
        System.out.println(map);
    }

    @Test
    void printListStringTest() {
        System.out.println(listStr);
        printListString(listStr);
        System.out.println(listStr);
    }

    @Test
    void longestWordArrayStringsTest() {
        Arrays.stream(arrStr).forEach(System.out::println);
        String res = longestWordArrayStrings(arrStr);
        assertEquals("aqwersss", res);
        System.out.println(res);
    }
}