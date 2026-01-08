package practice.java.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPractice {

    private static Employee[] arrayOfEmps = {
            new Employee(1, "Jeff Bezos", 100000.0),
            new Employee(2, "Bill Gates", 200000.0),
            new Employee(3, "Mark Zuckerberg", 300000.0)
    };

    public static void main(String[] args) {

        //Stream creation
        Stream.of(arrayOfEmps);
        List<Employee> empList = Arrays.asList(arrayOfEmps);
        empList.stream();
        Stream.of(arrayOfEmps[0], arrayOfEmps[1], arrayOfEmps[2]);
        Stream.Builder<Employee> empStreamBuilder = Stream.builder();
        empStreamBuilder.accept(arrayOfEmps[0]);
        empStreamBuilder.accept(arrayOfEmps[1]);
        empStreamBuilder.accept(arrayOfEmps[2]);
        Stream<Employee> empStream = empStreamBuilder.build();

        //for each example
        empList.stream().forEach(e -> e.salaryIncrement(10.0));
        empList.forEach(System.out::println);
        // map example
        System.out.println(empList.stream().map(Employee::getId).toList());
        //collect example
        List<Integer> empIds = empList.stream().map(Employee::getId).collect(Collectors.toList());
        System.out.println(empIds);
        //filter
        System.out.println(empList.stream().filter(e -> e.getSalary() > 200000).toList());
        // findFirst
        System.out.println(empList.stream().filter(e -> e.getSalary() > 100000).findFirst().orElse(null));
        // toArray()
        Employee[] employees = empList.stream().toArray(Employee[]::new);
        System.out.println("to Array" + employees[0] + " " + employees[1] + " " + employees[2]);
        //flatMap
        List<List<String>> namesNested = Arrays.asList(
                Arrays.asList("Jeff", "Bezos"),
                Arrays.asList("Bill", "Gates"),
                Arrays.asList("Mark", "Zuckerberg"));
        System.out.println(namesNested.stream().flatMap(Collection::stream).toList());
        //peek
        empList.stream().peek(System.out::println).toList();
        //mapToInt
        List<String> numbersAsString = Arrays.asList("100000000", "200000000");
        numbersAsString.stream().mapToInt(Integer::parseInt).forEach(System.out::println);
        //mapToLong
        numbersAsString = Arrays.asList("10000000000", "20000000000");
        numbersAsString.stream().mapToLong(Long::parseLong).forEach(System.out::println);
        //mapToDouble
        numbersAsString = Arrays.asList("1.5", "2.5", "3.5");
        numbersAsString.stream().mapToDouble(Double::parseDouble).forEach(System.out::println);
        //flatMapToInt
        Stream<String> strings = Stream.of("1,2,3", "4,5");
        strings.flatMapToInt(s -> Arrays.stream(s.split(",")).mapToInt(Integer::parseInt)).forEach(System.out::println);
        //flatMapToLong
        strings = Stream.of("10000000000,20000000000", "30000000000");
        strings.flatMapToLong(s -> Arrays.stream(s.split(",")).mapToLong(Long::parseLong)).forEach(System.out::println);
        //flatMapToDouble
        strings = Stream.of("1.1,2.2", "3.3,4.4");
        strings.flatMapToDouble(s -> Arrays.stream(s.split(",")).mapToDouble(Double::parseDouble)).forEach(System.out::println);
        //mapMulti
        Stream.of(1, 2, 3).<String>mapMulti((number, consumer) -> {
            consumer.accept(number + "a");
            consumer.accept(number + "b");
        }).forEach(System.out::println);
        //mapMultiToInt
        Stream.of("1,2", "3,4").mapMultiToInt((s, consumer) -> {
            Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).map(n -> 10 * n).forEach(consumer);
        }).forEach(System.out::println);
        //mapMultiToLong
        Stream.of("10000000000,20000000000").mapMultiToLong((s, consumer) -> {
            Arrays.stream(s.split(",")).mapToLong(Long::parseLong).forEach(consumer);
        }).forEach(System.out::println);
        //mapMultiToDouble
        Stream.of("1.1,2.2").mapMultiToDouble((s, consumer) -> {
            Arrays.stream(s.split(",")).mapToDouble(Double::parseDouble).forEach(consumer);
        }).forEach(System.out::println);
        //count
        System.out.println(empList.stream().filter(e -> e.getSalary() > 200000).count());
        //iterate, skip, limit (short-circuit operations)
        Stream<Integer> infiniteStream = Stream.iterate(2, i -> i * 2);
        List<Integer> collects = infiniteStream.skip(3).limit(5).toList();
        System.out.println(collects);
        //Lazy evaluation, Computation on the source data is only performed when the terminal operation is initiated, and source elements are consumed only as needed.
        Integer[] empIdsArr = {1, 2, 3, 4};
        Stream<Integer> strm = Arrays.stream(empIdsArr).skip(3).limit(5);
        System.out.println(strm);
        //sorted - Comparison based stream operations
        System.out.println(empList.stream().sorted((e1, e2) -> e1.getName().compareTo(e2.getName())).toList());
        //min and max
        Employee emp = empList.stream().min((e1, e2) -> e1.getId() - e2.getId()).orElseThrow(NoSuchElementException::new);
        System.out.println(emp);
        Employee maxSalEmp = empList.stream().max(Comparator.comparing(Employee::getSalary)).orElseThrow(NoSuchElementException::new);
        System.out.println("Max salary: " + maxSalEmp);
        //second max
        Employee secondMax = empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst().orElseThrow(NegativeArraySizeException::new);
        System.out.println(secondMax);
        //distinct
        List<Integer> intList = Arrays.asList(2, 5, 3, 2, 4, 3);
        System.out.println(intList.stream().distinct().toList());
        //allMatch, anyMatch, noneMatch
        intList = Arrays.asList(2, 4, 5, 6, 8);
        boolean allEven = intList.stream().allMatch(i -> i % 2 == 0);
        boolean oneEven = intList.stream().anyMatch(i -> i % 2 == 0);
        boolean noneMultipleOfSeven = intList.stream().noneMatch(i -> i % 7 == 0);
        System.out.println(allEven);
        System.out.println(oneEven);
        System.out.println(noneMultipleOfSeven);

        List<String> setences = Arrays.asList("Hello World", "Java streams are powerful", "flatMap is useful");
        System.out.println(setences.stream().flatMap(s -> {
            System.out.println("Each stream: " + s);
            return Arrays.stream(s.split(" "));
        }).map(String::toUpperCase).toList());

        // Joining strings
        String concatenatedNames = namesNested.stream().flatMap(Collection::stream).map(String::toUpperCase).collect(Collectors.joining(", "));
        System.out.println(concatenatedNames);

        // Summarizing data
        List<Integer> integers = Stream.iterate(1, x -> x + 1).limit(100).toList();
        IntSummaryStatistics stats = integers.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Max: " + stats.getMax());

        //Calculate Average
        Double average = integers.stream().collect(Collectors.averagingInt(x -> x));
        System.out.println("Average: " + average);

        Long count = integers.stream().collect(Collectors.counting());
        System.out.println("Count: " + count);

        // Grouping elements
        List<String> words = Arrays.asList("hello", "world", "java", "streams", "collecting");
        Map<Integer, List<String>> grouped = words.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(grouped);
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length, Collectors.joining(", "))));
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length, Collectors.counting())));
        TreeMap<Integer, Long> collect = words.stream().collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));
        System.out.println(collect);
        // Partitioning Elements
        Map<Boolean, List<String>> partitioningMap = words.stream().collect(Collectors.partitioningBy(x -> x.length() > 5));
        System.out.println(partitioningMap);

        //Mapping and Collecting
        List<String> collect1 = words.stream().collect(Collectors.mapping(x -> x.toUpperCase(), Collectors.toList()));
        System.out.println(collect1);

        // Counting word occurences
        String sentence = "hello world hello java world";
        System.out.println(Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(x -> x, Collectors.counting())));

        //Partitioning even and odd numbers
        List<Integer> l2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(l2.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0)));

        // Summing values in a map
        Map<String, Integer> items = new HashMap<>();
        items.put("Apple", 10);
        items.put("Banana", 20);
        items.put("Orange", 30);
        System.out.println(items.values().stream().reduce(Integer::sum));
        System.out.println(items.values().stream().collect(Collectors.summingInt(x -> x)));
        System.out.println(items.values().stream().mapToInt(x -> x).sum());

        // Creating a map from stream elements
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");
        System.out.println(fruits.stream().collect(Collectors.toMap(String::toUpperCase, String::length)));

        //Count of the word occurrences in the list
        List<String> words2 = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        System.out.println(words2.stream().collect(Collectors.toMap(x -> x, v -> 1, Integer::sum)));
        System.out.println(words2.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting())));

        //Average
        DoubleStream doubleStream = empList.stream().mapToDouble(Employee::getSalary);
        System.out.println(empList.stream().mapToDouble(Employee::getSalary).average().orElseThrow());

        // Employee name by first char
        Map<Character, List<Employee>> groupByAlphabet = empList.stream().collect(
                Collectors.groupingBy(e -> e.getName().charAt(0)));
        System.out.println(groupByAlphabet);

        // Employees first char with ids as array
        Map<Character, List<Integer>> idGroupedByAlphabet = empList.stream().collect(
                Collectors.groupingBy(e -> e.getName().charAt(0),
                        Collectors.mapping(Employee::getId, Collectors.toList())));
        System.out.println(idGroupedByAlphabet);

        System.out.println(Stream.iterate(1, i -> i + 1).takeWhile(i -> i <= 10).map(i -> i * i).toList());

        System.out.println(Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0)
                .dropWhile(x -> x <= 5)
                .toList());

        //Iterate with predicate to create finite stream
        System.out.println(Stream.iterate(1, i -> i < 256, i -> i * 2).toList());

        //Conact two streams
        Stream<String> firstStream = Stream.of("A", "B", "C");
        Stream<String> secondStream = Stream.of("D", "E", "F");
        Stream<String> concatenatedStream = Stream.concat(firstStream, secondStream);
        System.out.println(concatenatedStream.toList());

        //Concat Intstream
        IntStream firstStream1 = IntStream.of(1, 2, 3);
        IntStream secondStream1 = IntStream.of(4, 5, 6);

        System.out.println(Arrays.toString(IntStream.concat(firstStream1, secondStream1).toArray()));

    }

    static class Employee {

        int id;
        String name;
        Double salary;

        public Employee(int id, String name, Double salary) {
            this.id = id;
            this.salary = salary;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }

        public void salaryIncrement(double percent) {
            this.salary = this.salary + this.salary * percent / 100;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }
}
