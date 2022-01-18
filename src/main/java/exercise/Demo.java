package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
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

    public static void main(String[] args) {

        Employee[] employeesArray = {
                new Employee("Ben", 38, "developer", 80000f),
                new Employee("Sofie", 38, "architect", 60000f),
                new Employee("Sam", 28, "designer", 70000f),
                new Employee("John", 32, "developer", 92000f),
                new Employee("Greg", 38, "architect", 50000f),
        };


        List<Employee> employees = new ArrayList<>(Arrays.asList(employeesArray));

        Map<String, Float> averageSalaries = employees
                .stream()
                .collect(Collectors.groupingBy(
                        (employee -> employee.jobTitle)
                ))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        (entry) -> entry.getKey(),
                        (entry) -> entry.getValue()
                                .stream()
                                .map(employee -> employee.salary)
                                .reduce(0f, (acc, x) -> acc + x / entry.getValue().size())
                ));

        System.out.println(averageSalaries);

    }

}
