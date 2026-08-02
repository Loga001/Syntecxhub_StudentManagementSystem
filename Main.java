public class Main {

    public static void main(String[] args) {

        StudentManager manager = new StudentManager();

        while (true) {

            System.out.println("\n======================================");
            System.out.println("     STUDENT MANAGEMENT SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Search Student by Name");
            System.out.println("5. Update Student");
            System.out.println("6. Delete Student");
            System.out.println("7. Sort by Name");
            System.out.println("8. Sort by CGPA");
            System.out.println("9. Display Topper");
            System.out.println("10. Average CGPA");
            System.out.println("11. Total Students");
            System.out.println("12. Exit");

            int choice = InputValidator.getInt("\nEnter your choice: ");

            switch (choice) {

                case 1:

                    int id = InputValidator.getInt("Enter Student ID: ");
                    String name = InputValidator.getString("Enter Name: ");
                    int age = InputValidator.getInt("Enter Age: ");
                    String dept = InputValidator.getString("Enter Department: ");
                    double cgpa = InputValidator.getDouble("Enter CGPA: ");

                    manager.addStudent(new Student(id, name, age, dept, cgpa));
                    break;

                case 2:
                    manager.viewStudents();
                    break;

                case 3:

                    int searchId = InputValidator.getInt("Enter Student ID: ");

                    Student student = manager.searchById(searchId);

                    if (student != null) {

                        System.out.printf("%-10s %-20s %-5s %-15s %-5s\n",
                                "ID", "Name", "Age", "Department", "CGPA");

                        System.out.println(student);

                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                case 4:

                    String searchName =
                            InputValidator.getString("Enter Name: ");

                    manager.searchByName(searchName);

                    break;

                case 5:

                    int updateId =
                            InputValidator.getInt("Enter Student ID: ");

                    String newName =
                            InputValidator.getString("Enter New Name: ");

                    int newAge =
                            InputValidator.getInt("Enter New Age: ");

                    String newDept =
                            InputValidator.getString("Enter New Department: ");

                    double newCgpa =
                            InputValidator.getDouble("Enter New CGPA: ");

                    manager.updateStudent(updateId,
                            newName,
                            newAge,
                            newDept,
                            newCgpa);

                    break;

                case 6:

                    int deleteId =
                            InputValidator.getInt("Enter Student ID: ");

                    manager.deleteStudent(deleteId);

                    break;

                case 7:
                    manager.sortByName();
                    break;

                case 8:
                    manager.sortByCgpa();
                    break;

                case 9:
                    manager.displayTopper();
                    break;

                case 10:
                    manager.averageCgpa();
                    break;

                case 11:
                    manager.totalStudents();
                    break;

                case 12:

                    FileManager.saveStudents(manager.getStudents());

                    System.out.println("\nThank you for using the Student Management System!");

                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}