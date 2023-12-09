import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private char grade;
    public Student(String name, int rollNumber, char grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }
	public int getRollNumber(){
		return rollNumber;
	}
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                ", grade=" + grade +
                '}';
    }
}

class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }
    public void addStudent(Student student) {
        students.add(student);
    }
    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }
    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
    public List<Student> getStudents() {
        return students;
    }
}
public class StudentManagementSystemApp {
    public static void main(String[] args) {
        StudentManagementSystem studentManagementSystem = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search for Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    addStudent(scanner, studentManagementSystem);
                    break;
                case 2:
                    removeStudent(scanner, studentManagementSystem);
                    break;
                case 3:
                    searchStudent(scanner, studentManagementSystem);
                    break;
                case 4:
                    studentManagementSystem.displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting the Student Management System. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
    private static void addStudent(Scanner scanner, StudentManagementSystem studentManagementSystem) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter grade: ");
        char grade = scanner.next().charAt(0);
        scanner.nextLine(); 
        Student newStudent = new Student(name, rollNumber, grade);
        studentManagementSystem.addStudent(newStudent);
        System.out.println("Student added successfully!");
    }
    private static void removeStudent(Scanner scanner, StudentManagementSystem studentManagementSystem) {
        System.out.print("Enter roll number to remove: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); 
        studentManagementSystem.removeStudent(rollNumber);
        System.out.println("Student removed successfully!");
    }
    private static void searchStudent(Scanner scanner, StudentManagementSystem studentManagementSystem) {
        System.out.print("Enter roll number to search: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); 
        Student foundStudent = studentManagementSystem.searchStudent(rollNumber);
        if (foundStudent != null) {
            System.out.println("Student found: " + foundStudent);
        } else {
            System.out.println("Student not found.");
        }
    }
}
