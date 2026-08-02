import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentManager {

    private ArrayList<Student> students;

    public StudentManager() {
        students = FileManager.loadStudents();
    }

    // Add Student
    public boolean addStudent(Student student) {

        for (Student s : students) {
            if (s.getStudentId() == student.getStudentId()) {
                System.out.println("Student ID already exists.");
                return false;
            }
        }

        students.add(student);
        FileManager.saveStudents(students);
        System.out.println("Student added successfully.");
        return true;
    }

    // View Students
    public void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("\nNo student records found.");
            return;
        }

        System.out.println("\n==============================================================");
        System.out.printf("%-10s %-20s %-5s %-15s %-5s\n",
                "ID","Name","Age","Department","CGPA");
        System.out.println("==============================================================");

        for (Student s : students) {
            System.out.println(s);
        }

        System.out.println("==============================================================");
    }

    // Search by ID
    public Student searchById(int id) {

        for (Student s : students) {
            if (s.getStudentId() == id) {
                return s;
            }
        }

        return null;
    }

    // Search by Name
    public void searchByName(String name) {

        boolean found = false;

        for (Student s : students) {

            if (s.getName().equalsIgnoreCase(name)) {

                if (!found) {
                    System.out.printf("%-10s %-20s %-5s %-15s %-5s\n",
                            "ID","Name","Age","Department","CGPA");
                }

                System.out.println(s);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No student found.");
        }
    }

    // Update Student
    public void updateStudent(int id,
                              String name,
                              int age,
                              String department,
                              double cgpa) {

        Student student = searchById(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        student.setName(name);
        student.setAge(age);
        student.setDepartment(department);
        student.setCgpa(cgpa);

        FileManager.saveStudents(students);

        System.out.println("Student updated successfully.");
    }
        // Delete Student
    public void deleteStudent(int id) {

        Student student = searchById(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        students.remove(student);
        FileManager.saveStudents(students);

        System.out.println("Student deleted successfully.");
    }

    // Sort by Name
    public void sortByName() {

        Collections.sort(students,
                Comparator.comparing(Student::getName));

        System.out.println("Students sorted by name.");
        viewStudents();
    }

    // Sort by CGPA (Highest First)
    public void sortByCgpa() {

        Collections.sort(students,
                Comparator.comparing(Student::getCgpa).reversed());

        System.out.println("Students sorted by CGPA.");
        viewStudents();
    }

    // Display Topper
    public void displayTopper() {

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        Student topper = Collections.max(students,
                Comparator.comparing(Student::getCgpa));

        System.out.println("\n========== TOPPER ==========");
        System.out.printf("%-10s %-20s %-5s %-15s %-5s\n",
                "ID", "Name", "Age", "Department", "CGPA");
        System.out.println(topper);
    }

    // Average CGPA
    public void averageCgpa() {

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        double total = 0;

        for (Student s : students) {
            total += s.getCgpa();
        }

        System.out.printf("Average CGPA : %.2f%n",
                total / students.size());
    }

    // Total Students
    public void totalStudents() {
        System.out.println("Total Students : " + students.size());
    }

    // Getter
    public ArrayList<Student> getStudents() {
        return students;
    }
}