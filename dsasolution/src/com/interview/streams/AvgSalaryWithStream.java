package com.interview.streams;

import static java.util.Map.Entry;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AvgSalaryWithStream {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("A", "IT", 50000.0),
                new Employee("B", "IT", 70000.0),
                new Employee("C", "HR", 40000.0),
                new Employee("D", "HR", 60000.0),
                new Employee("E", "FIN", 80000.0),
                new Employee("F", "FIN", 90000.0)
        );

        Map<String, Double> deptWiseAvgSal = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        List<Map.Entry<String, Double>> sortedAvgSalaries = deptWiseAvgSal.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .collect(Collectors.toList());
        System.out.println(sortedAvgSalaries.get(1).getValue());

        Map<String, Double> avgByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        List<Entry<String, Double>> sortedAvgSalByDept = avgByDept.entrySet().stream()
                .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))
                .toList();

        if(sortedAvgSalByDept.size() < 2) {
            System.out.println("Not enough departments");
            return;
        }

        Entry<String, Double> secondHighestSalAndDept = sortedAvgSalByDept.get(1);

        System.out.println("Dept name: " + secondHighestSalAndDept.getKey() + " and value: " + secondHighestSalAndDept.getValue());
    }

}

class Employee {

    private String name;
    private String department;
    private Double salary;

    public Employee(String name, String department, Double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}