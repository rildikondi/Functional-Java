package composition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo {

    public static class Employee {
        private String name;
        private int age;
        private String jobTitle;
        private float salary;

        public Employee(String name, int age, String jobTitle, float salary) {
            this.name = name;
            this.age = age;
            this.jobTitle = jobTitle;
            this.salary = salary;
        }
    }

    Function<Employee, String> getName = employee -> employee.name;

    public static void main(String[] args) {
        Function<Integer, Integer> timesTwo = x -> x * 2;
        Function<Integer, Integer> minusOne = x -> x - 1;

        Function<Integer, Integer> timesTwoMinusOne = timesTwo.andThen(minusOne);

        System.out.println(timesTwoMinusOne.apply(10));


        Employee[] employeesArray = {
                new Employee("Ben", 38, "developer", 80000f),
                new Employee("Sofie", 38, "architect", 60000f),
                new Employee("Sam", 28, "designer", 70000f),
                new Employee("John", 32, "developer", 92000f),
                new Employee("Greg", 38, "architect", 50000f),
        };


        List<Employee> employees = new ArrayList<>(Arrays.asList(employeesArray));


        Function<String, String> reverse = str -> new StringBuilder(str).reverse().toString();
        Function<String, String> uppercase = str -> str.toUpperCase();
        Function<Employee, String> getName = employee -> employee.name;
        Function<Employee, String> getReversedUppercasedName = getName.andThen(reverse).andThen(uppercase);

        List<String> results = employees.stream().map(getReversedUppercasedName).collect(Collectors.toList());

        System.out.println(results);
    }
}
