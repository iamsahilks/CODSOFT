package StudentManagementSystem;

import java.io.IOException;
import java.io.*;
import java.util.*;

    public class StudentManagementSystem {

        private static final String FILE_NAME = "students.txt";
        private static List<Student> students = new ArrayList<>();
        private static Scanner sc = new Scanner(System.in);

        public static void main(String[] args) {
            loadStudents();
            int choice;

            do {
                System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
                System.out.println("1. Add Student");
                System.out.println("2. Remove Student");
                System.out.println("3. Search Student");
                System.out.println("4. Display All Students");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                choice = getValidInt();

                switch (choice) {
                    case 1 -> addStudent();
                    case 2 -> removeStudent();
                    case 3 -> searchStudent();
                    case 4 -> displayStudents();
                    case 5 -> {
                        saveStudents();
                        System.out.println("Data saved. Exiting...");
                    }
                    default -> System.out.println("Invalid choice!");
                }
            } while (choice != 5);
        }

        private static int getValidInt() {
            while (!sc.hasNextInt()) {
                System.out.print("Invalid input. Enter number: ");
                sc.next();
            }
            return sc.nextInt();
        }

        private static void addStudent() {
            sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            if (name.isBlank()) {
                System.out.println("Name cannot be empty!");
                return;
            }

            System.out.print("Enter Roll Number: ");
            int roll = getValidInt();

            for (Student s : students) {
                if (s.getRollNumber() == roll) {
                    System.out.println("Roll number already exists!");
                    return;
                }
            }

            sc.nextLine();
            System.out.print("Enter Grade: ");
            String grade = sc.nextLine();

            students.add(new Student(name, roll, grade));
            System.out.println("Student added successfully!");
        }

        private static void removeStudent() {
            System.out.print("Enter Roll Number: ");
            int roll = getValidInt();

            students.removeIf(s -> s.getRollNumber() == roll);
            System.out.println("If roll existed, student removed.");
        }

        private static void searchStudent() {
            System.out.print("Enter Roll Number: ");
            int roll = getValidInt();

            for (Student s : students) {
                if (s.getRollNumber() == roll) {
                    System.out.println("Student Found:");
                    System.out.println("Roll: " + s.getRollNumber());
                    System.out.println("Name: " + s.getName());
                    System.out.println("Grade: " + s.getGrade());
                    return;
                }
            }
            System.out.println("Student not found!");
        }

        private static void displayStudents() {
            if (students.isEmpty()) {
                System.out.println("No students available.");
                return;
            }

            System.out.println("\n--- Student List ---");
            for (Student s : students) {
                System.out.println("Roll: " + s.getRollNumber() +
                        ", Name: " + s.getName() +
                        ", Grade: " + s.getGrade());
            }
        }

        private static void saveStudents() {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
                for (Student s : students) {
                    bw.write(s.toString());
                    bw.newLine();
                }
            } catch (IOException e) {
                System.out.println("Error saving file.");
            }
        }

        private static void loadStudents() {
            File file = new File(FILE_NAME);
            if (!file.exists()) return;

            try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
                String line;
                while ((line = br.readLine()) != null) {
                    students.add(Student.fromString(line));
                }
            } catch (IOException e) {
                System.out.println("Error loading file.");
            }
        }
    }

