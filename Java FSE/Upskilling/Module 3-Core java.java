import java.io.*;
import java.nio.file.*;
import java.sql.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class CoreJavaExercises {

    static Scanner sc = new Scanner(System.in);

    // 1. Hello World Program
    static void exercise1_HelloWorld() {
        System.out.println("Hello, World!");
    }

    // 2. Simple Calculator
    static void exercise2_SimpleCalculator() {
        System.out.print("Enter first number: ");
        double a = sc.nextDouble();
        System.out.print("Enter second number: ");
        double b = sc.nextDouble();
        sc.nextLine(); // consume newline
        System.out.print("Choose operation (+ - * /): ");
        String op = sc.nextLine();

        double result = 0;
        switch (op) {
            case "+" -> result = a + b;
            case "-" -> result = a - b;
            case "*" -> result = a * b;
            case "/" -> {
                if (b != 0) result = a / b;
                else {
                    System.out.println("Division by zero is undefined.");
                    return;
                }
            }
            default -> {
                System.out.println("Invalid operation.");
                return;
            }
        }
        System.out.println("Result: " + result);
    }

    // 3. Even or Odd Checker
    static void exercise3_EvenOrOdd() {
        System.out.print("Enter an integer: ");
        int num = sc.nextInt();
        System.out.println(num % 2 == 0 ? "Even" : "Odd");
    }

    // 4. Leap Year Checker
    static void exercise4_LeapYearChecker() {
        System.out.print("Enter a year: ");
        int year = sc.nextInt();
        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        System.out.println(year + " is " + (isLeap ? "a leap year." : "not a leap year."));
    }

    // 5. Multiplication Table
    static void exercise5_MultiplicationTable() {
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %d = %d%n", n, i, n * i);
        }
    }

    // 6. Data Type Demonstration
    static void exercise6_DataTypeDemo() {
        int i = 10;
        float f = 10.5f;
        double d = 20.99;
        char c = 'A';
        boolean b = true;
        System.out.println("int: " + i);
        System.out.println("float: " + f);
        System.out.println("double: " + d);
        System.out.println("char: " + c);
        System.out.println("boolean: " + b);
    }

    // 7. Type Casting Example
    static void exercise7_TypeCasting() {
        double d = 9.78;
        int i = (int) d;
        System.out.println("Double value: " + d);
        System.out.println("After casting to int: " + i);
        int x = 100;
        double y = x;
        System.out.println("Int value: " + x);
        System.out.println("After casting to double: " + y);
    }

    // 8. Operator Precedence
    static void exercise8_OperatorPrecedence() {
        int result = 10 + 5 * 2; // 5*2=10, then 10+10=20
        System.out.println("Expression: 10 + 5 * 2");
        System.out.println("Result: " + result);
        System.out.println("Explanation: Multiplication (*) has higher precedence than addition (+).");
    }

    // 9. Grade Calculator
    static void exercise9_GradeCalculator() {
        System.out.print("Enter marks out of 100: ");
        int marks = sc.nextInt();
        char grade;
        if (marks >= 90) grade = 'A';
        else if (marks >= 80) grade = 'B';
        else if (marks >= 70) grade = 'C';
        else if (marks >= 60) grade = 'D';
        else grade = 'F';
        System.out.println("Grade: " + grade);
    }

    // 10. Number Guessing Game
    static void exercise10_NumberGuessingGame() {
        int target = new Random().nextInt(100) + 1;
        int guess = 0;
        System.out.println("Guess a number between 1 and 100:");
        while (guess != target) {
            guess = sc.nextInt();
            if (guess < target) System.out.println("Too low, try again:");
            else if (guess > target) System.out.println("Too high, try again:");
            else System.out.println("Correct! You guessed the number.");
        }
    }

    // 11. Factorial Calculator
    static void exercise11_FactorialCalculator() {
        System.out.print("Enter a non-negative integer: ");
        int n = sc.nextInt();
        if (n < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
            return;
        }
        long fact = 1;
        for (int i = 1; i <= n; i++) fact *= i;
        System.out.println("Factorial of " + n + " is " + fact);
    }

    // 12. Method Overloading
    static int add(int a, int b) {
        return a + b;
    }
    static double add(double a, double b) {
        return a + b;
    }
    static int add(int a, int b, int c) {
        return a + b + c;
    }
    static void exercise12_MethodOverloading() {
        System.out.println("add(2, 3) = " + add(2, 3));
        System.out.println("add(2.5, 3.5) = " + add(2.5, 3.5));
        System.out.println("add(1, 2, 3) = " + add(1, 2, 3));
    }

    // 13. Recursive Fibonacci
    static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    static void exercise13_RecursiveFibonacci() {
        System.out.print("Enter position n for Fibonacci: ");
        int n = sc.nextInt();
        System.out.println("Fibonacci number at position " + n + " is " + fibonacci(n));
    }

    // 14. Array Sum and Average
    static void exercise14_ArraySumAverage() {
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int sum = 0;
        for (int num : arr) sum += num;
        double avg = (double) sum / n;
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + avg);
    }

    // 15. String Reversal
    static void exercise15_StringReversal() {
        System.out.print("Enter a string: ");
        sc.nextLine(); // consume leftover newline
        String s = sc.nextLine();
        String reversed = new StringBuilder(s).reverse().toString();
        System.out.println("Reversed string: " + reversed);
    }

    // 16. Palindrome Checker
    static void exercise16_PalindromeChecker() {
        System.out.print("Enter a string: ");
        sc.nextLine();
        String s = sc.nextLine();
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        System.out.println(cleaned.equals(reversed) ? "Palindrome" : "Not a palindrome");
    }

    // 17. Class and Object Creation
    static class Car {
        String make;
        String model;
        int year;

        Car(String make, String model, int year) {
            this.make = make;
            this.model = model;
            this.year = year;
        }

        void displayDetails() {
            System.out.println("Make: " + make + ", Model: " + model + ", Year: " + year);
        }
    }
    static void exercise17_ClassAndObject() {
        Car car1 = new Car("Toyota", "Camry", 2020);
        Car car2 = new Car("Honda", "Accord", 2021);
        car1.displayDetails();
        car2.displayDetails();
    }

    // 18. Inheritance Example
    static class Animal {
        void makeSound() {
            System.out.println("Animal sound");
        }
    }
    static class Dog extends Animal {
        @Override
        void makeSound() {
            System.out.println("Bark");
        }
    }
    static void exercise18_InheritanceExample() {
        Animal animal = new Animal();
        Dog dog = new Dog();
        animal.makeSound();
        dog.makeSound();
    }

    // 19. Interface Implementation
    interface Playable {
        void play();
    }
    static class Guitar implements Playable {
        public void play() {
            System.out.println("Playing guitar");
        }
    }
    static class Piano implements Playable {
        public void play() {
            System.out.println("Playing piano");
        }
    }
    static void exercise19_InterfaceImplementation() {
        Playable guitar = new Guitar();
        Playable piano = new Piano();
        guitar.play();
        piano.play();
    }

    // 20. Try-Catch Example
    static void exercise20_TryCatchExample() {
        System.out.print("Enter first integer: ");
        int a = sc.nextInt();
        System.out.print("Enter second integer: ");
        int b = sc.nextInt();
        try {
            int res = a / b;
            System.out.println("Result: " + res);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero.");
        }
    }

    // 21. File Writing and Reading
    static void exercise21_FileIO() {
        String filename = "testfile.txt";
        try {
            // Write to file
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write("Hello, this is a test file.");
            writer.newLine();
            writer.write("Java File I/O example.");
            writer.close();

            // Read from file
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            System.out.println("File content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

            // Delete file
            // Files.deleteIfExists(Paths.get(filename)); // Uncomment to delete after test

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    // 22. Lambda Expression
    static void exercise22_LambdaExpression() {
        List<String> names = List.of("Alice", "Bob", "Charlie");
        System.out.println("Names:");
        names.forEach(name -> System.out.println(name.toUpperCase()));
    }

    // 23. Stream API Example
    static void exercise23_StreamAPI() {
        List<Integer> numbers = Arrays.asList(5, 10, 15, 20, 25);
        int sum = numbers.stream().filter(n -> n % 10 == 0).mapToInt(Integer::intValue).sum();
        System.out.println("Sum of numbers divisible by 10: " + sum);
    }

    // 24. Thread Example
    static void exercise24_ThreadExample() {
        Runnable r = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread message " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ignored) {}
            }
        };
        Thread t = new Thread(r);
        t.start();
        try {
            t.join();
        } catch (InterruptedException ignored) {}
    }

    // 25. Generics Example
    static <T> void printArray(T[] arr) {
        for (T t : arr) System.out.print(t + " ");
        System.out.println();
    }
    static void exercise25_GenericsExample() {
        Integer[] intArr = {1, 2, 3, 4};
        String[] strArr = {"one", "two", "three"};
        printArray(intArr);
        printArray(strArr);
    }

    // 26. Collections Example
    static void exercise26_CollectionsExample() {
        List<String> fruits = new ArrayList<>(List.of("Apple", "Banana", "Cherry"));
        fruits.add("Date");
        fruits.remove("Banana");
        System.out.println("Fruits list: " + fruits);
    }

    // 27. Enum Example
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
    static void exercise27_EnumExample() {
        Day today = Day.WEDNESDAY;
        System.out.println("Today is " + today);
    }

    // 28. Serialization Example
    static class Person implements Serializable {
        String name;
        int age;
        Person(String n, int a) {
            name = n; age = a;
        }
        public String toString() {
            return name + " (" + age + ")";
        }
    }
    static void exercise28_SerializationExample() {
        String file = "person.ser";
        Person p = new Person("John", 25);
        try {
            // Serialize
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(p);
            oos.close();

            // Deserialize
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            Person p2 = (Person) ois.readObject();
            ois.close();

            System.out.println("Deserialized person: " + p2);

            // Files.deleteIfExists(Paths.get(file)); // Uncomment to delete file after test
        } catch (Exception e) {
            System.out.println("Serialization error: " + e.getMessage());
        }
    }

    // 29. JDBC Connection Example (Dummy)
    static void exercise29_JDBCExample() {
        System.out.println("JDBC connection example (demo only).");
        System.out.println("In real use, configure database, load driver, establish connection.");
    }

    // 30. Swing GUI Example (Basic)
    static void exercise30_SwingGUIExample() {
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("Simple GUI");
            javax.swing.JLabel label = new javax.swing.JLabel("Hello Swing!", javax.swing.SwingConstants.CENTER);
            frame.getContentPane().add(label);
            frame.setSize(300, 100);
            frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    // 31. Basic REST API with SparkJava (placeholder)
    static void exercise31_RESTAPIExample() {
        System.out.println("REST API example requires external libraries (e.g., SparkJava).");
        System.out.println("Run in proper environment with dependencies.");
    }

    // 32. Java Date and Time API
    static void exercise32_DateTimeAPI() {
        java.time.LocalDate today = java.time.LocalDate.now();
        java.time.LocalTime now = java.time.LocalTime.now();
        System.out.println("Current date: " + today);
        System.out.println("Current time: " + now);
    }

    // 33. Regular Expressions
    static void exercise33_RegexExample() {
        System.out.print("Enter email to validate: ");
        sc.nextLine();
        String email = sc.nextLine();
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        boolean valid = email.matches(regex);
        System.out.println(email + " is " + (valid ? "valid" : "invalid"));
    }

    // 34. Recursive Factorial
    static long recursiveFactorial(int n) {
        if (n <= 1) return 1;
        return n * recursiveFactorial(n - 1);
    }
    static void exercise34_RecursiveFactorial() {
        System.out.print("Enter a non-negative integer: ");
        int n = sc.nextInt();
        System.out.println("Factorial (recursive) of " + n + " is " + recursiveFactorial(n));
    }

    // 35. Find max and min in array
    static void exercise35_MaxMinArray() {
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i=0; i<n; i++) arr[i] = sc.nextInt();
        int max = arr[0], min = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }

    // 36. Bubble Sort
    static void exercise36_BubbleSort() {
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i=0; i<n; i++) arr[i] = sc.nextInt();

        for (int i=0; i<n-1; i++) {
            for (int j=0; j<n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j]; arr[j] = arr[j+1]; arr[j+1] = temp;
                }
            }
        }
        System.out.println("Sorted array:");
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }

    // 37. Count vowels in string
    static void exercise37_CountVowels() {
        System.out.print("Enter a string: ");
        sc.nextLine();
        String s = sc.nextLine().toLowerCase();
        int count = 0;
        for (char ch : s.toCharArray()) {
            if ("aeiou".indexOf(ch) >= 0) count++;
        }
        System.out.println("Number of vowels: " + count);
    }

    // 38. Check Prime Number
    static void exercise38_CheckPrime() {
        System.out.print("Enter an integer: ");
        int n = sc.nextInt();
        if (n <= 1) {
            System.out.println(n + " is not prime.");
            return;
        }
        boolean isPrime = true;
        for (int i=2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }
        System.out.println(n + (isPrime ? " is prime." : " is not prime."));
    }

    // 39. Swap two numbers without temp variable
    static void exercise39_SwapNumbers() {
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        System.out.println("Before swap: a=" + a + ", b=" + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("After swap: a=" + a + ", b=" + b);
    }

    // 40. Sum digits of an integer
    static void exercise40_SumDigits() {
        System.out.print("Enter an integer: ");
        int n = sc.nextInt();
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        System.out.println("Sum of digits: " + sum);
    }

    // 41. Print pattern (Triangle of stars)
    static void exercise41_PrintPattern() {
        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=i; j++) System.out.print("* ");
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Uncomment the exercise you want to run:

        // exercise1_HelloWorld();
        // exercise2_SimpleCalculator();
        // exercise3_EvenOrOdd();
        // exercise4_LeapYearChecker();
        // exercise5_MultiplicationTable();
        // exercise6_DataTypeDemo();
        // exercise7_TypeCasting();
        // exercise8_OperatorPrecedence();
        // exercise9_GradeCalculator();
        // exercise10_NumberGuessingGame();
        // exercise11_FactorialCalculator();
        // exercise12_MethodOverloading();
        // exercise13_RecursiveFibonacci();
        // exercise14_ArraySumAverage();
        // exercise15_StringReversal();
        // exercise16_PalindromeChecker();
        // exercise17_ClassAndObject();
        // exercise18_InheritanceExample();
        // exercise19_InterfaceImplementation();
        // exercise20_TryCatchExample();
        // exercise21_FileIO();
        // exercise22_LambdaExpression();
        // exercise23_StreamAPI();
        // exercise24_ThreadExample();
        // exercise25_GenericsExample();
        // exercise26_CollectionsExample();
        // exercise27_EnumExample();
        // exercise28_SerializationExample();
        // exercise29_JDBCExample();
        // exercise30_SwingGUIExample();
        // exercise31_RESTAPIExample();
        // exercise32_DateTimeAPI();
        // exercise33_RegexExample();
        // exercise34_RecursiveFactorial();
        // exercise35_MaxMinArray();
        // exercise36_BubbleSort();
        // exercise37_CountVowels();
        // exercise38_CheckPrime();
        // exercise39_SwapNumbers();
        // exercise40_SumDigits();
        // exercise41_PrintPattern();

        System.out.println("Uncomment one exercise method call in main() to run.");
    }
}
