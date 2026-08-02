import java.io.Serializable;

public class Student implements Serializable {

    private int studentId;
    private String name;
    private int age;
    private String department;
    private double cgpa;

    public Student(int studentId, String name, int age, String department, double cgpa) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.department = department;
        this.cgpa = cgpa;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public String toString() {
        return String.format(
                "%-10d %-20s %-5d %-15s %-5.2f",
                studentId, name, age, department, cgpa
        );
    }
}